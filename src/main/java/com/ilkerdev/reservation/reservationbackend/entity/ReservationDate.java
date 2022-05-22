package com.ilkerdev.reservation.reservationbackend.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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

}
