package com.ilkerdev.reservation.reservationbackend.dao;

import com.ilkerdev.reservation.reservationbackend.entity.Tables;
import com.ilkerdev.reservation.reservationbackend.entity.User;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TableDao {
    public List<Tables> findAll();

    public Tables findById(String id);
}
