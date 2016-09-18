package com.pzeszko.healthcare.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Validation error
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FieldErrorResponse {

    private String name;

    private String field;

    private String message;

}