package com.pzeszko.healthcare.repository;

import com.pzeszko.healthcare.model.Medicine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

/**
 * Created by Pawel on 2016-09-15.
 */
@Repository
public interface MedicineRepository extends CrudRepositoryWithOptionalWrapper<Medicine, Long> {

    /**
     * Finds all medicines
     * @return Stream of all medicines
     */
    @Query("SELECT m FROM Medicine m")
    Stream<Medicine> findAllMedicines();

    /**
     * Finds page of medicines
     * @param pageable Page information
     * @return Page of medicines
     */
    Page<Medicine> findAll(Pageable pageable);
}
