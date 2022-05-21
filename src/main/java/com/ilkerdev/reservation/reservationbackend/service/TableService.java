package com.ilkerdev.reservation.reservationbackend.service;

import com.ilkerdev.reservation.reservationbackend.entity.Tables;
import com.ilkerdev.reservation.reservationbackend.entity.User;

import java.util.List;

public interface TableService {

    public List<Tables> findAll();
    public Tables findById(String id);
}
