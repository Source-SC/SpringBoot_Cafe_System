package com.example.cafe_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CafeSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(CafeSystemApplication.class, args);
    }

}
