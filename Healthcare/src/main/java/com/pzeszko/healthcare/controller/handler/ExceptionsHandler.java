package com.pzeszko.healthcare.controller.handler;

import com.pzeszko.healthcare.aspect.LogException;
import com.pzeszko.healthcare.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * Created by Pawel on 2016-09-17.
 */
@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @LogException(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleGeneralException(Model model, Exception ex) {
        model.addAttribute("errorMessage", ex.getMessage());
        return "exception";
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @LogException(HttpStatus.NOT_FOUND)
    public String handleNotFoundException(Model model, NotFoundException ex) {
        model.addAttribute("errorMessage", ex.getMessage());
        return "exception";
    }
}
