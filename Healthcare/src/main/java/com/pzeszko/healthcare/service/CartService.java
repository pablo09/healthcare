package com.pzeszko.healthcare.service;

import com.pzeszko.healthcare.dto.MedicineOrderDto;
import com.pzeszko.healthcare.dto.TotalOrderDto;
import com.pzeszko.healthcare.model.FinalizedOrder;
import com.pzeszko.healthcare.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by Pawel on 2016-09-22.
 */
public interface CartService {
    void addToCart(User user, MedicineOrderDto dto);

    TotalOrderDto getOrders(User user);

    void finalizeOrder(User user);

    Page<FinalizedOrder> getOrderHistory(User user, Pageable pageable);
}
