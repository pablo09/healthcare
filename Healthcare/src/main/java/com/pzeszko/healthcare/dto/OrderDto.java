package com.pzeszko.healthcare.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Pawel on 2016-09-23.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private String name;
    private Integer quantity;
    private PriceDto price;
    private PriceDto totalPrice;
}
