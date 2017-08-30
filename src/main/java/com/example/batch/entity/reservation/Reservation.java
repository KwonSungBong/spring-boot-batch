package com.example.batch.entity.reservation;

import lombok.Data;
import org.hibernate.annotations.Columns;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.Date;

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

    private Date startDate;

    private Date endDate;

    @Enumerated(EnumType.STRING)
    private RepeatType repeatType;

    @Enumerated(EnumType.STRING)
    private ResultStatus resultStatus;

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTimeAndZone")
    @Columns(columns={@Column(name = "CREATED_DATE"), @Column(name = "CREATED_DATE_TIMEZONE")})
    private DateTime createdDate;

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTimeAndZone")
    @Columns(columns={@Column(name = "LAST_MODIFIED_DATE"), @Column(name = "LAST_MODIFIED_TIMEZONE")})
    private DateTime lastModifiedDate;

    public boolean executableAction() {
        return true;
    }
    public boolean executableAction(Date date) {
        return true;
    }
    public boolean isRepeat(){
        return true;
    }
    public boolean isRepeat(Date date){
        return true;
    }


}
