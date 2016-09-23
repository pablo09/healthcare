package com.pzeszko.healthcare.service;

import com.fasterxml.jackson.databind.RuntimeJsonMappingException;
import com.pzeszko.healthcare.dto.MedicineOrderDto;
import com.pzeszko.healthcare.dto.OrderDto;
import com.pzeszko.healthcare.exception.NotFoundException;
import com.pzeszko.healthcare.model.Cart;
import com.pzeszko.healthcare.model.Medicine;
import com.pzeszko.healthcare.model.MedicineOrder;
import com.pzeszko.healthcare.model.User;
import com.pzeszko.healthcare.repository.CartRepository;
import com.pzeszko.healthcare.repository.MedicineOrderRepository;
import com.pzeszko.healthcare.repository.MedicineRepository;
import com.pzeszko.healthcare.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
public class CartServiceImpl implements CartService {

    private final MedicineRepository medicineRepository;
    private final MedicineOrderRepository medicineOrderRepository;
    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final Mapper mapper;

    @Transactional
    @Override
    public void addToCart(User user, MedicineOrderDto dto) {
        Medicine medicine = medicineRepository.optionalFindOne(dto.getMedicineId()).orElseThrow(NotFoundException::new);
        if (medicine.getQuantity() >= dto.getQuantity()) {
            Cart cart = createCartIfNecessary(user);
            MedicineOrder order = mapper.map(dto, MedicineOrder.class);
            cart.addToCart(order);

        } else throw new RuntimeJsonMappingException("Not enough items");
    }

    @Override
    public List<OrderDto> getOrders(User user) {
        User userEntity = userRepository.findOneByEmail(user.getEmail()).orElseThrow(NotFoundException::new);

        List<MedicineOrder> orders = Optional.of(userEntity)
                                         .map(User::getCart)
                                         .map(Cart::getMedicineOrders)
                                         .orElseGet(Collections::emptyList);
        return orders.stream()
                .map(order -> mapper.map(order, OrderDto.class))
                .collect(Collectors.toList());

    }

    /**
     * Creates and saves cart for user if it doesn't exist yet
     *
     * @param user HC User
     * @return User's cart
     */
    private Cart createCartIfNecessary(User user) {
        Cart cart = user.getCart();

        if (cart == null) {
            cart = new Cart();
            cartRepository.save(cart);
            user.setCart(cart);
            userRepository.save(user);
        }

        return cart;
    }
}
