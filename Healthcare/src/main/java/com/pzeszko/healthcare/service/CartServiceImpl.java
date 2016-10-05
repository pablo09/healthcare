package com.pzeszko.healthcare.service;

import com.pzeszko.healthcare.dto.MedicineOrderDto;
import com.pzeszko.healthcare.dto.OrderDto;
import com.pzeszko.healthcare.dto.TotalOrderDto;
import com.pzeszko.healthcare.exception.NotFoundException;
import com.pzeszko.healthcare.model.*;
import com.pzeszko.healthcare.repository.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Pawel on 2016-09-22.
 */
@Service
@Transactional(readOnly = true)
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class CartServiceImpl implements CartService {

    private final MedicineRepository medicineRepository;
    private final MedicineOrderRepository medicineOrderRepository;
    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final FinalizedOrderRepository finalizedOrderRepository;
    private final Mapper mapper;

    @Transactional
    @Override
    public void addToCart(User user, MedicineOrderDto dto) {
        Medicine medicine = medicineRepository.optionalFindOne(dto.getMedicineId()).orElseThrow(NotFoundException::new);
        if (medicine.getQuantity() >= dto.getQuantity()) {
            addMedicine(user, dto, medicine);
        } else throw new RuntimeException("No enough items");
    }

    /**
     * Adds medicine order to the cart
     * @param user Logged user
     * @param dto Information about the order
     */
    private void addMedicine(User user, MedicineOrderDto dto, Medicine medicine) {
        Cart cart = createCartIfNecessary(user);
        boolean isMedicineAlreadyInCart = cart.getMedicineOrders().stream()
                .anyMatch(medicineOrder -> medicineOrder.getMedicine().getId().equals(dto.getMedicineId()));

        if (isMedicineAlreadyInCart) {
            cart.getMedicineOrders().stream()
                    .filter(medicineOrder -> medicineOrder.getMedicine().getId().equals(dto.getMedicineId()))
                    .forEach(medicineOrder -> medicineOrder.increaseQuantity(dto.getQuantity()));
        } else {
            MedicineOrder order = mapper.map(dto, MedicineOrder.class);
            cart.addToCart(order);
        }

        medicine.decreaseQuantity(dto.getQuantity());
    }

    @Override
    public TotalOrderDto getOrders(User user) {
        User userEntity = userRepository.findOneByEmail(user.getEmail()).orElseThrow(NotFoundException::new);

        List<MedicineOrder> orders = Optional.of(userEntity)
                .map(User::getCart)
                .map(Cart::getMedicineOrders)
                .orElseGet(Collections::emptyList);
        List<OrderDto> ordersDto = orders.stream()
                .map(order -> mapper.map(order, OrderDto.class))
                .collect(Collectors.toList());

        return createTotalOrder(ordersDto);
    }

    @Transactional
    @Override
    public void finalizeOrder(User user) {
        FinalizedOrder order = new FinalizedOrder();
        Cart cart = cartRepository.optionalFindOne(user.getCart().getId()).orElseThrow(NotFoundException::new);

        List<BoughtMedicineOrder> boughtMedicineOrders = cart.getMedicineOrders().stream()
                .map(medicineOrder -> mapper.map(medicineOrder, BoughtMedicineOrder.class))
                .collect(Collectors.toList());
        order.setUser(user);
        order.setMedicines(boughtMedicineOrders);

        finalizedOrderRepository.save(order);
        cart.clearCart();
    }

    @Override
    public Page<FinalizedOrder> getOrderHistory(User user, Pageable pageable) {
        return finalizedOrderRepository.findByUser(user, pageable);
    }


    @Transactional
    private void clearCart (User user) {
        Cart cart = cartRepository.optionalFindOne(user.getCart().getId()).orElseThrow(NotFoundException::new);
        cart.clearCart();
        if(cart != null && cart.getMedicineOrders() != null) {
            medicineOrderRepository.delete(cart.getMedicineOrders());
        } else {
            log.info("User {} has no cart or no orders", user.getEmail());
        }
    }

    /**
     * Creates and saves cart for user if it doesn't exist yet
     *
     * @param user HC User
     * @return User's cart
     */
    private Cart createCartIfNecessary(User user) {
        User userEntity = userRepository.findOneByEmail(user.getEmail()).orElseThrow(NotFoundException::new);
        Cart cart = userEntity.getCart();

        if (cart == null) {
            cart = new Cart();
            cartRepository.save(cart);
            user.setCart(cart);
            userRepository.save(user);
        }

        return cart;
    }

    private TotalOrderDto createTotalOrder(List<OrderDto> orders) {
        TotalOrderDto total = new TotalOrderDto();
        total.setOrders(orders);

        BigDecimal totalDenomination = orders.stream()
                .map(order -> order.getTotalPrice().getDenomination())
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        total.setOrdersTotalPrice(new Money(totalDenomination));

        return total;
    }
}
