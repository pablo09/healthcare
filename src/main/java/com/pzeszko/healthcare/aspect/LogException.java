package com.pzeszko.healthcare.aspect;

import org.springframework.http.HttpStatus;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Exception logger annotation
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LogException {
    HttpStatus value() default HttpStatus.INTERNAL_SERVER_ERROR;
}
