package com.ilkerdev.reservation.reservationbackend.service;

import com.ilkerdev.reservation.reservationbackend.dao.ReservationDateDao;
import com.ilkerdev.reservation.reservationbackend.entity.ReservationDate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationDateServiceImpl implements ReservationDateService{

    private ReservationDateDao reservationDateDao;

    public ReservationDateServiceImpl(ReservationDateDao reservationDateDao){
        this.reservationDateDao = reservationDateDao;
    }

    @Override
    public List<ReservationDate> findAll() {

        return reservationDateDao.findAll();
    }

    @Override
    public ReservationDate findById(String id) {
        return reservationDateDao.findById(id);
    }

}
