package com.ilkerdev.reservation.reservationbackend.service;


import com.ilkerdev.reservation.reservationbackend.dao.TableDao;
import com.ilkerdev.reservation.reservationbackend.dao.UserDao;
import com.ilkerdev.reservation.reservationbackend.entity.Tables;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableServiceImpl implements TableService{


    private TableDao tableDao;

    public TableServiceImpl(TableDao tableDao){
        this.tableDao = tableDao;
    }

    @Override
    public List<Tables> findAll() {
        return tableDao.findAll();
    }

    @Override
    public Tables findById(String id) {
        return tableDao.findById(id);
    }
}
