package com.example.batch.config;

import com.example.batch.entity.reservation.Reservation;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;

/**
 * Created by whilemouse on 17. 8. 25.
 */
@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    public EntityManagerFactory entityManagerFactory;

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job importJob(JobCompletionNotificationListener listener) {
        return jobBuilderFactory.get("importJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1())
                .end()
                .build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<Reservation, Reservation> chunk(10)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .build();
    }

    @Bean
    public JpaPagingItemReader<Reservation> reader() {
        JpaPagingItemReader<Reservation> reader = new JpaPagingItemReader<>();
        reader.setQueryString("select r from Reservation r");
        reader.setEntityManagerFactory(entityManagerFactory);
        return reader;
    }

    @Bean
    public ReservationItemProcessor processor() {
        return new ReservationItemProcessor();
    }

    @Bean
    public JpaItemWriter<Reservation> writer() {
        JpaItemWriter<Reservation> writer = new JpaItemWriter<>();
        writer.setEntityManagerFactory(entityManagerFactory);
        return writer;
    }

}
