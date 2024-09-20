package com.techwiz5.techwiz5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class TechWiz5Application {

    public static void main(String[] args) {
        SpringApplication.run(TechWiz5Application.class, args);
    }

}
