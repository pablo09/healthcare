package com.pzeszko.healthcare.exception;

/**
 * Created by Pawel on 2016-09-15.
 */
public class NotFoundException extends HealthcareException {

    public NotFoundException() {
        super(ErrorCode.NOT_FOUND);
    }
}
