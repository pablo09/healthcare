package com.pzeszko.healthcare.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Log exception
 */
@Component
@Aspect
@Slf4j
public class ExceptionLogger {

    @Before("@annotation(logException) && args(e)")
    public void logExceptionInfo(LogException logException, Exception e) {
        log.error("Error occurred and it will be map to http status: {},", logException.value(), e);
    }
}