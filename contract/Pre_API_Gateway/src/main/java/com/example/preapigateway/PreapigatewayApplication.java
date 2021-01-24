package com.example.preapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class PreapigatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(PreapigatewayApplication.class, args);
    }

}
