package com.example.batch;

import com.example.batch.entity.reservation.Reservation;
import com.example.batch.entity.reservation.ResultStatus;
import com.example.batch.service.ReservationService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.IntStream;

@SpringBootApplication
public class SpringBootBatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBatchApplication.class, args);
	}

	@Autowired
	private ReservationService reservationService;

	@Bean
	@Transactional
	public InitializingBean localInitializingBean(){
		return () -> {
			IntStream.range(1, 10).forEach(i -> {
				Reservation reservation = new Reservation();
				reservation.setResultStatus(ResultStatus.waiting);
				reservationService.create(reservation);
			});
		};
	}

}
