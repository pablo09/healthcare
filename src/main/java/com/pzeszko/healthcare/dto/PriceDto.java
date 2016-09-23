package com.pzeszko.healthcare.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by Pawel on 2016-09-23.
 */
@Data
public class PriceDto {
    private BigDecimal denomination;
    private String currency;
}
