package com.pzeszko.healthcare.mapper;

import com.pzeszko.healthcare.dto.OrderDto;
import com.pzeszko.healthcare.dto.PriceDto;
import com.pzeszko.healthcare.model.MedicineOrder;
import org.dozer.DozerConverter;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * Created by Pawel on 2016-09-24.
 */
public class MedicineOrderConverter extends DozerConverter<MedicineOrder, OrderDto> {

    public MedicineOrderConverter() {
        super(MedicineOrder.class, OrderDto.class);
    }

    public OrderDto convertTo(MedicineOrder source, OrderDto destination) {
        return Optional.of(source)
                .map((medicine -> convert(medicine)))
                .orElseGet(OrderDto::new);
    }

    public MedicineOrder convertFrom(OrderDto source, MedicineOrder destination) {
        throw new RuntimeException("Not supported");
    }

    private OrderDto convert(MedicineOrder entity) {
        OrderDto order = new OrderDto();
        order.setName(entity.getMedicine().getName());

        PriceDto price = new PriceDto();
        price.setDenomination(entity.getMedicine().getPrice().getDenomination());
        price.setCurrency(entity.getMedicine().getPrice().getCurrencyCode());

        order.setPrice(price);

        PriceDto total = new PriceDto();
        total.setDenomination(price.getDenomination().multiply(new BigDecimal(entity.getQuantity())));
        total.setCurrency(entity.getMedicine().getPrice().getCurrencyCode());

        order.setTotalPrice(total);
        order.setQuantity(entity.getQuantity());
        return order;
    }
}
