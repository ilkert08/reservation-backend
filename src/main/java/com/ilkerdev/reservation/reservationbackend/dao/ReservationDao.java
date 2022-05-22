package com.ilkerdev.reservation.reservationbackend.dao;

import com.ilkerdev.reservation.reservationbackend.entity.Reservation;
import com.ilkerdev.reservation.reservationbackend.requests.ReservateRequest;

import java.util.List;

public interface ReservationDao {

    public List<Reservation> findAll();
    public Reservation findById(String id);
    public void deleteById(String id);
    public void save(Reservation reservation, int type);

    public int reservate(ReservateRequest reservateRequest);


}
