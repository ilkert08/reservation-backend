package com.ilkerdev.reservation.reservationbackend.service;

import com.ilkerdev.reservation.reservationbackend.entity.Reservation;

import java.util.List;

public interface ReservationService {
    public List<Reservation> findAll();
    public Reservation findById(String id);
    public void deleteById(String id);
    public void save(Reservation reservation, int type);
}
