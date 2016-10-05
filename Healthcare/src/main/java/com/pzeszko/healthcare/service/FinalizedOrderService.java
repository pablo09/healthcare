package com.pzeszko.healthcare.service;

import com.pzeszko.healthcare.model.Cart;

/**
 * Created by Pawel on 2016-10-03.
 */
public interface FinalizedOrderService {

    void finalizeOrder(Cart cart);
}
