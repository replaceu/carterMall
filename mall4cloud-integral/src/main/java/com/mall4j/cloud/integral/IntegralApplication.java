package com.mall4j.cloud.integral;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = { "com.mall4j.cloud" })
@EnableFeignClients(basePackages = {"com.mall4j.cloud.api.**.feign"})
public class IntegralApplication {
    public static void main(String[] args) {
        SpringApplication.run(IntegralApplication.class, args);
    }
}
