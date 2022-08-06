# E-commerce
Open Source Project Structure for E-commerce

### Technology:
- Java: 11
- Spring Boot: 2.7.2
- Spring Cloud: 2021.0.3

Eureka: http://localhost:8761/eureka/

Cloud Config: https://github.com/Extremecoder-Group/cloud-config-server

### Run Instruction: 
We have to run first "Service-Registry" & then "cloud-config-server" & then Others

### RestTemplate Instruction
We have to add "@LoadBalanced" in the bean declaration. Example:
``` 
@Bean
@LoadBalanced
public RestTemplate restTemplate(){
    return new RestTemplate();
}
```

### How to create one Service
1. we have to add service information in the cloud config repository's application.yaml like:
```
microservice:
  product-service:
    endpoints:
      endpoint:
        uri: http://PRODUCT-SERVICE
  image-service:
    endpoints:
      endpoint:
        uri: http://IMAGE-SERVICE  
```
2. Need to add the bellows dependencies:
```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-config</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
```
3. Need to add the bellow properties in the application yaml:
```
spring:
  application:
    name: <SERVICE_NAME>
  config:
    import: optional:configserver:http://localhost:9900
```
4. Need to add annotation in the Main Application class:
```
@EnableEurekaClient
```
5. Need to add configuration in "cloud-gateway" application yaml file:
```
spring
  cloud:
    gateway:
      routes:
        - id: image-service
          uri: lb://IMAGE-SERVICE
          predicates:
            - Path=/image-service/**
        - id: product-service
          uri: lb://PRODUCT-SERVICE
          predicates:
            - Path=/product-service/**
```

