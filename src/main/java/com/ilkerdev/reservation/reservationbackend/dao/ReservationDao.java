package com.ilkerdev.reservation.reservationbackend.dao;

import com.ilkerdev.reservation.reservationbackend.entity.Reservation;

import java.util.List;

public interface ReservationDao {

    public List<Reservation> findAll();
    public Reservation findById(String id);
    public void deleteById(String id);
    public void save(Reservation reservation, int type);
}
