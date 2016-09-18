package com.pzeszko.healthcare.controller.handler;

import com.pzeszko.healthcare.aspect.LogException;
import com.pzeszko.healthcare.dto.ErrorResponse;
import com.pzeszko.healthcare.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import static com.pzeszko.healthcare.dto.ErrorResponse.buildErrorResponse;


/**
 * Created by Pawel on 2016-09-17.
 */
@ControllerAdvice
public class ExceptionsHandler {


    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    @LogException(HttpStatus.NOT_FOUND)
    ErrorResponse processNotFoundError(NotFoundException ex) {
        return buildErrorResponse(ex.getCode());
    }
}
