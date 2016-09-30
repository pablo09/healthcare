package com.pzeszko.healthcare.config;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;

@Configuration
public class DozerConfig {

    @Value("classpath:/bean-mappings/dozer-bean-mappings.xml")
    private InputStream mappings;

    @Bean
    public Mapper newDozerBeanMapper() {
        DozerBeanMapper mapper = new DozerBeanMapper();
        mapper.addMapping(mappings);

        return mapper;
    }
}

