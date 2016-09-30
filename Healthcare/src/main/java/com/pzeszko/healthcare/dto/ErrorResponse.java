package com.pzeszko.healthcare.dto;

import com.pzeszko.healthcare.exception.ErrorCode;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Error response
 */
@Data
public class ErrorResponse {

    private String errorCode;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private List<FieldErrorResponse> errors = new ArrayList<>();

    public void add(String name, String field, String errorCode) {
        errors.add(new FieldErrorResponse(name, field, errorCode));
    }

    public List<FieldErrorResponse> getErrors() {
        return Collections.unmodifiableList(errors);
    }

    public static ErrorResponse buildErrorResponse(ErrorCode errorCode) {
        return buildErrorResponse(errorCode, Collections.<FieldError>emptyList());
    }

    public static ErrorResponse buildErrorResponse(ErrorCode errorCode, List<FieldError> fieldErrors) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode(errorCode.getCode());
        fieldErrors.forEach(fieldError ->
                errorResponse.add(fieldError.getObjectName(), fieldError.getField(), fieldError.getCode()));
        return errorResponse;
    }
}