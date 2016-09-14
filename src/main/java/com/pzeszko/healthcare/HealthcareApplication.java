package com.pzeszko.healthcare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Pawel on 2016-09-10.
 */

@EntityScan(basePackageClasses = {
        HealthcareApplication.class
})
@SpringBootApplication
@ComponentScan("com.pzeszko.healthcare")
public class HealthcareApplication {

    public static void main(String[] args) {
        SpringApplication.run(HealthcareApplication.class, args);
    }
}

