package ru.advantum.kotin.featureflags;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.security.RolesAllowed;

@SpringBootApplication
public class FeatureflagsApplication {
    @RolesAllowed("*")
    public static void main(String[] args) {
        SpringApplication.run(FeatureflagsApplication.class, args);
    }

}
