package com.pzeszko.healthcare.exception;

import lombok.Getter;

/**
 * Base exception class
 */
@Getter
public class HealthcareException extends RuntimeException {

    private final ErrorCode code;

    public HealthcareException(ErrorCode code) {
        super(code.getCode());
        this.code = code;
    }
}