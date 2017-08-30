package com.example.batch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ScheduledExecutorFactoryBean;

import java.util.Date;

/**
 * Created by whilemouse on 17. 8. 28.
 */
@Configuration
@EnableScheduling
public class SchedulingConfiguration {

    @Bean
    public ScheduledExecutorFactoryBean scheduledExecutorService() {
        ScheduledExecutorFactoryBean bean = new ScheduledExecutorFactoryBean();
        bean.setPoolSize(5);
        return bean;
    }

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job job;

    @Scheduled(initialDelay = 5000, fixedRate = 5000)
    public void schedule() throws Exception {
//        handle();
    }

    public void handle() throws Exception {
        JobParametersBuilder builder = new JobParametersBuilder();
        builder.addString("time", String.valueOf(System.currentTimeMillis()));
        builder.addDate("date", new Date());
        jobLauncher.run(job, builder.toJobParameters());
//        jobLauncher.run(job, new JobParameters());
    }

}
