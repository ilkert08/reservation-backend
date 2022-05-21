package com.ilkerdev.reservation.reservationbackend.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "rezdates")
public class ReservationDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @Column(name = "rezdate")
    private Date resDate;

    @Column(name = "interval")
    private int interval;

    public ReservationDate(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getResDate() {
        return resDate;
    }



    public void setResDate(Date resDate) {
        this.resDate = resDate;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    @Override
    public String toString() {
        return "ReservationDate{" +
                "id='" + id + '\'' +
                ", resDate=" + resDate +
                ", interval=" + interval +
                '}';
    }
}
