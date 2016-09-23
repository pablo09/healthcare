package com.pzeszko.healthcare.service;

import com.pzeszko.healthcare.dto.MedicineOrderDto;
import com.pzeszko.healthcare.dto.OrderDto;
import com.pzeszko.healthcare.model.User;

import java.util.List;

/**
 * Created by Pawel on 2016-09-22.
 */
public interface CartService {
    void addToCart(User user, MedicineOrderDto dto);

    List<OrderDto> getOrders(User user);
}
