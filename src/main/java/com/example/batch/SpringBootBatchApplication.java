package com.example.batch;

import com.example.batch.entity.reservation.RepeatType;
import com.example.batch.entity.reservation.Reservation;
import com.example.batch.service.ReservationService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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
			Date now = new Date();
			IntStream.range(1, 10).forEach(i -> {
				Reservation reservation = new Reservation();
				reservation.setRepeatType(RepeatType.NONE);
				reservation.setStartDate(now);
				reservation.setEndDate(now);
				reservationService.create(reservation);
			});
			IntStream.range(1, 10).forEach(i -> {
				Reservation reservation = new Reservation();
				reservation.setRepeatType(RepeatType.PER_MINUTE);
				reservation.setStartDate(now);
				reservation.setEndDate(now);
				reservationService.create(reservation);
			});
			IntStream.range(1, 10).forEach(i -> {
				Reservation reservation = new Reservation();
				reservation.setRepeatType(RepeatType.PER_HOUR);
				reservationService.create(reservation);
			});
			IntStream.range(1, 10).forEach(i -> {
				Reservation reservation = new Reservation();
				reservation.setRepeatType(RepeatType.DAILY);
				reservationService.create(reservation);
			});
			IntStream.range(1, 10).forEach(i -> {
				Reservation reservation = new Reservation();
				reservation.setRepeatType(RepeatType.WEEKLY);
				reservationService.create(reservation);
			});
			IntStream.range(1, 10).forEach(i -> {
				Reservation reservation = new Reservation();
				reservation.setRepeatType(RepeatType.MONTHLY);
				reservationService.create(reservation);
			});
			IntStream.range(1, 10).forEach(i -> {
				Reservation reservation = new Reservation();
				reservation.setRepeatType(RepeatType.YEARLY);
				reservationService.create(reservation);
			});
		};
	}

}
