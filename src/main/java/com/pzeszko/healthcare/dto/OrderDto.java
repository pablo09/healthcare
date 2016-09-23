package com.pzeszko.healthcare.dto;

import lombok.Data;

/**
 * Created by Pawel on 2016-09-23.
 */
@Data
public class OrderDto {
    private String name;
    private Integer quantity;
    private PriceDto price;

}
