package com.pzeszko.healthcare.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by Pawel on 2016-09-15.
 */
@Getter
@AllArgsConstructor
public enum  ErrorCode {
    NOT_FOUND("NOT FOUND");

    private final String code;
}
