package com.kodilla.patterns2.facade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
public class SpringRunner {
    public static void main(String[] args) {
        SpringApplication.run(SpringRunner.class, args);
    }
}
