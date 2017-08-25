package com.example.batch.controller;

import com.example.batch.entity.NextData;
import com.example.batch.entity.PrevData;
import com.example.batch.entity.reservation.Reservation;
import com.example.batch.entity.reservation.ResultStatus;
import com.example.batch.service.NextDataService;
import com.example.batch.service.PrevDataService;
import com.example.batch.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by whilemouse on 17. 8. 24.
 */
@RestController
@RequestMapping("/data")
public class DataController {

    @Autowired
    private PrevDataService prevDataService;

    @Autowired
    private NextDataService nextDataService;

    @Autowired
    private ReservationService reservationService;

    @RequestMapping(method = RequestMethod.GET, value="prev")
    public List<PrevData> getPrevData(){
        PrevData prevData = new PrevData();
        prevData.setName("prevData");
        prevDataService.create(prevData);
        return prevDataService.data();
    }

    @RequestMapping(method = RequestMethod.GET, value="next")
    public List<NextData> getNextData(){
        NextData nextData = new NextData();
        nextData.setName("nextData");
        nextDataService.create(nextData);
        return nextDataService.data();
    }

    @RequestMapping(method = RequestMethod.GET, value="reservation")
    public List<Reservation> getReservation(){
        Reservation reservation = new Reservation();
        reservation.setResultStatus(ResultStatus.waiting);
        reservationService.create(reservation);
        return reservationService.data();
    }
}
