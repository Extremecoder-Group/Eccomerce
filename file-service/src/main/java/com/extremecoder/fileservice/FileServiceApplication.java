package com.extremecoder.fileservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FileServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FileServiceApplication.class, args);
    }

}
