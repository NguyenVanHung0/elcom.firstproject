package com.elcom.firstproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication
@EntityScan("com.elcom.firstproject.postgresql.model")
public class FirstprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstprojectApplication.class, args);
    }
}
