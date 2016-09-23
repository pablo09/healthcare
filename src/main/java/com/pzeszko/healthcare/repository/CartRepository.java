package com.pzeszko.healthcare.repository;

import com.pzeszko.healthcare.model.Cart;
import org.springframework.stereotype.Repository;

/**
 * Created by Pawel on 2016-09-22.
 */
@Repository
public interface CartRepository extends CrudRepositoryWithOptionalWrapper<Cart, Long> {
}
