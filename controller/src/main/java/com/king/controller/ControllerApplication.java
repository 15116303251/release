package com.king.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations = "spring-context.xml")

public class ControllerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ControllerApplication.class, args);
    }

}
