package com.example.batch.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Created by whilemouse on 17. 8. 28.
 */
@Configuration
@EnableScheduling
public class SchedulingConfiguration {

    @Scheduled(fixedRate = 5000)
    public void test() {
        String test = "test";
    }

}
