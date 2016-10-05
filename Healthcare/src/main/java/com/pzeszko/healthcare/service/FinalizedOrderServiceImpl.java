package com.pzeszko.healthcare.service;

import com.pzeszko.healthcare.model.Cart;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Pawel on 2016-10-03.
 */

@Service
@Transactional(readOnly = true)
public class FinalizedOrderServiceImpl implements FinalizedOrderService {

    @Transactional
    @Override
    public void finalizeOrder(Cart cart) {

    }
}

