package com.example.apigateway2;

import com.netflix.discovery.EurekaNamespace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Apigateway2Application {

    public static void main(String[] args) {
        SpringApplication.run(Apigateway2Application.class, args);
    }

}
