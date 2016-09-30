package com.pzeszko.healthcare.service;

import lombok.AllArgsConstructor;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Pawel on 2016-09-15.
 */

@AllArgsConstructor(onConstructor = @__(@Autowired))
public abstract class SimpleDataService {

    private final Mapper mapper;


}
