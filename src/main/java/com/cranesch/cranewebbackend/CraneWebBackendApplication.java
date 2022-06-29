package com.cranesch.cranewebbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CraneWebBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(CraneWebBackendApplication.class, args);
    }

}
