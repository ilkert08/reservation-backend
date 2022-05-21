package com.ilkerdev.reservation.reservationbackend.service;

import com.ilkerdev.reservation.reservationbackend.entity.Place;
import com.ilkerdev.reservation.reservationbackend.entity.ReservationDate;

import java.util.List;

public interface ReservationDateService {

    public List<ReservationDate> findAll();
    public ReservationDate findById(String id);

}
