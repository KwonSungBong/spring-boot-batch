package com.example.batch.service;

import com.example.batch.entity.reservation.QReservation;
import com.example.batch.entity.reservation.Reservation;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.QBean;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by whilemouse on 17. 8. 25.
 */
@Service
public class ReservationService {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void create(Reservation reservation){
        entityManager.persist(reservation);
    }

    public List<Reservation> data() {
        QBean<Reservation> bean = Projections.bean(Reservation.class, QReservation.reservation.id, QReservation.reservation.resultStatus);
        List<Reservation> list = new JPAQueryFactory(entityManager).select(bean).from(QReservation.reservation).fetch();
        return list;
    }
}
