package com.example.batch.config;

import com.example.batch.entity.reservation.Reservation;
import org.springframework.batch.item.ItemProcessor;

/**
 * Created by whilemouse on 17. 8. 28.
 */
public class ReservationItemProcessor implements ItemProcessor<Reservation, Reservation> {

    @Override
    public Reservation process(final Reservation reservation) throws Exception {
        final Reservation transformedPerson = reservation;
        return transformedPerson;
    }

}
