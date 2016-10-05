package com.pzeszko.healthcare.repository;

import com.pzeszko.healthcare.model.FinalizedOrder;
import com.pzeszko.healthcare.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

/**
 * Created by Pawel on 2016-10-03.
 */
@Repository
public interface FinalizedOrderRepository extends CrudRepositoryWithOptionalWrapper<FinalizedOrder, Long> {

    Page<FinalizedOrder> findByUser(User user, Pageable pageable);
}
