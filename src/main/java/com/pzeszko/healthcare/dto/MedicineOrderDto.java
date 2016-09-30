package com.pzeszko.healthcare.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by Pawel on 2016-09-22.
 */
@Data
public class MedicineOrderDto {
    @NotNull
    Long medicineId;

    @NotNull
    @Min(1)
    Integer quantity;
}
