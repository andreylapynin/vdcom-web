package com.vdcom.vdcomtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.vdcom.vdcomtest")
@EntityScan("com.vdcom.vdcomtest")
public class VdcomTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(VdcomTestApplication.class, args);
    }

}