package com.mall4j.cloud.firmware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = { "com.mall4j.cloud" })
@EnableFeignClients(basePackages = {"com.mall4j.cloud.api.**.feign"})
public class FirmwareApplication {
    public static void main(String[] args) {
        SpringApplication.run(FirmwareApplication.class,args);
    }
}
