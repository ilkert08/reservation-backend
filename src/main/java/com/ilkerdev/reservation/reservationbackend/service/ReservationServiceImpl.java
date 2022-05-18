package com.ilkerdev.reservation.reservationbackend.service;


import com.ilkerdev.reservation.reservationbackend.entity.Reservation;
import com.ilkerdev.reservation.reservationbackend.dao.ReservationDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    private ReservationDao reservationDao;

    public ReservationServiceImpl(ReservationDao reservationDao){
        this.reservationDao = reservationDao;
    }

    @Override
    public List<Reservation> findAll() {

        return reservationDao.findAll();
    }

    @Override
    public Reservation findById(String id) {
        return reservationDao.findById(id);
    }

    @Override
    public void deleteById(String id) {
        reservationDao.deleteById(id);
    }

    @Override
    public void save(Reservation reservation, int type) { // type 0 = add , else = update
        reservationDao.save(reservation, type);
    }
}
