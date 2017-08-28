package com.example.batch.config;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.stereotype.Component;

/**
 * Created by whilemouse on 17. 8. 28.
 */
@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

    public void afterJob(JobExecution jobExecution) {
        if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
            String test = "test";
        }
    }

}
