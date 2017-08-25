package com.example.batch;

import com.example.batch.entity.NextData;
import com.example.batch.entity.reservation.Reservation;
import com.example.batch.entity.reservation.ResultStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

/**
 * Created by whilemouse on 17. 8. 25.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ReservationTests {

    @Autowired
    private EntityManager entityManager;

    @Test
    @Transactional
    public void 추가(){
        Reservation reservation = new Reservation();
        reservation.setResultStatus(ResultStatus.waiting);
        entityManager.persist(reservation);
    }

}
