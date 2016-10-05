package com.pzeszko.healthcare.dto;

import com.pzeszko.healthcare.model.Money;
import lombok.Data;

import java.util.List;

/**
 * Created by Pawel on 2016-10-01.
 */
@Data
public class TotalOrderDto {
    private List<OrderDto> orders;
    private Money ordersTotalPrice;
}

