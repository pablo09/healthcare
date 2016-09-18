package com.pzeszko.healthcare.service;

import com.pzeszko.healthcare.dto.MedicineDto;
import com.pzeszko.healthcare.model.Medicine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Pawel on 2016-09-15.
 */
public interface MedicineService {
    /**
     * Finds all medicines
     * @return Stream of all medicines
     */
    Stream<Medicine> findAllMedicines();

    /**
     * Finds medicine by its identifier
     * @param id Medicine identifier
     * @return Instance of Medicine entity
     */
    MedicineDto findById(Long id);

    /**
     * Finds all medicines
     * @return List of DTO corresponding to all medicines
     */
    List<MedicineDto> findAll();

    /**
     * Fidns page of medicines
     * @param pageable Page information
     * @return Page of DTO corresponding to Medicine
     */
    Page<MedicineDto> findAll(Pageable pageable);
}
