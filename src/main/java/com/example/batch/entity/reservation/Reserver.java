package com.example.batch.entity.reservation;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by whilemouse on 17. 8. 25.
 */
@Entity
@Data
public class Reserver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "reserver")
    private List<Reservation> reservationList;
}
