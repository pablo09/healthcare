package com.pzeszko.healthcare.repository;

import com.pzeszko.healthcare.model.MedicineOrder;
import org.springframework.stereotype.Repository;

/**
 * Created by Pawel on 2016-09-22.
 */
@Repository
public interface MedicineOrderRepository extends CrudRepositoryWithOptionalWrapper<MedicineOrder, Long> {
}
