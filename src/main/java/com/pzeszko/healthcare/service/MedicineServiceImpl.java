package com.pzeszko.healthcare.service;

import com.pzeszko.healthcare.dto.MedicineDto;
import com.pzeszko.healthcare.exception.NotFoundException;
import com.pzeszko.healthcare.model.Medicine;
import com.pzeszko.healthcare.repository.MedicineRepository;
import lombok.AllArgsConstructor;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Pawel on 2016-09-15.
 */
@Service
@Transactional(readOnly = true)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MedicineServiceImpl implements MedicineService {

    private final MedicineRepository medicineRepository;
    private final Mapper mapper;

    @Override
    public Stream<Medicine> findAllMedicines() {
        return medicineRepository.findAllMedicines();
    }

    @Override
    public Medicine findById(Long id) {
        return medicineRepository.optionalFindOne(id)
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public List<MedicineDto> findAll() {
        return medicineRepository.findAll().stream()
                .map(medicine -> mapper.map(medicine, MedicineDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Page<MedicineDto> findAll(Pageable pageable) {
        return medicineRepository.findAll(pageable)
                .map(medicine -> mapper.map(medicine, MedicineDto.class));
    }
}
