package com.example.cluvrapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class CluvrApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CluvrApiApplication.class, args);
    }

}
