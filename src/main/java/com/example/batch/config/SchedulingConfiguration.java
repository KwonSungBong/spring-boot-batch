package com.example.batch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Created by whilemouse on 17. 8. 28.
 */
@Configuration
@EnableScheduling
public class SchedulingConfiguration {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job job;

    @Scheduled(fixedRate = 5000)
    public void test() throws Exception {
        handle();
    }

    public void handle() throws Exception {
        jobLauncher.run(job, new JobParameters());
    }

}
