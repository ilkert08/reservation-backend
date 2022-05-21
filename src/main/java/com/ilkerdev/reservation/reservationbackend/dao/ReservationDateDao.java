package com.ilkerdev.reservation.reservationbackend.dao;

import com.ilkerdev.reservation.reservationbackend.entity.Reservation;
import com.ilkerdev.reservation.reservationbackend.entity.ReservationDate;

import java.util.List;

public interface ReservationDateDao {

    public List<ReservationDate> findAll();
    public ReservationDate findById(String id);
}
