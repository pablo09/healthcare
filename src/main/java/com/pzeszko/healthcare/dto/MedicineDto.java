package com.pzeszko.healthcare.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by Pawel on 2016-09-15.
 */
@Data
public class MedicineDto {
    private Long id;
    private String name;
    private String description;
    private String category;
    private String imgLocation;
    private BigDecimal price;
    private String currency;
}
