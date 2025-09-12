package com.carlos.scheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SchedulerApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(SchedulerApiApplication.class, args);
    }
}
