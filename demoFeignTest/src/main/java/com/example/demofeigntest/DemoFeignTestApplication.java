package com.example.demofeigntest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DemoFeignTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoFeignTestApplication.class, args);
    }

}
