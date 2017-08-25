package com.example.batch.entity.reservation;

import lombok.Data;
import org.hibernate.annotations.Columns;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;

/**
 * Created by whilemouse on 17. 8. 25.
 */
@Entity
@Data
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "reserver_id")
    private Reserver reserver;

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTimeAndZone")
    @Columns(columns={@Column(name = "START_DATE"), @Column(name = "START_DATE_TIMEZONE")})
    private DateTime startDateTime;

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTimeAndZone")
    @Columns(columns={@Column(name = "END_DATE"), @Column(name = "END_DATE_TIMEZONE")})
    private DateTime endDateTime;

    @Enumerated(EnumType.STRING)
    private RepeatType repeatType;

    @Enumerated(EnumType.STRING)
    private ResultStatus resultStatus;
}
