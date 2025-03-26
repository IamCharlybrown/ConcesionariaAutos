package com.carlosmontero.concecionaria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ConcecionariaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConcecionariaApplication.class, args);
    }

}
