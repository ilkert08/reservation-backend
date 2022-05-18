package com.ilkerdev.reservation.reservationbackend.service;


import com.ilkerdev.reservation.reservationbackend.entity.Place;
import com.ilkerdev.reservation.reservationbackend.dao.PlaceDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceServiceImpl implements PlaceService {

    private PlaceDao placeDao;
    int x;

    public PlaceServiceImpl(PlaceDao placeDao){
        this.placeDao = placeDao;
    }

    @Override
    public List<Place> findAll() {

        return placeDao.findAll();
    }

    @Override
    public Place findById(String id) {
        return placeDao.findById(id);
    }

    @Override
    public void deleteById(String id) {
        placeDao.deleteById(id);
    }

    @Override
    public void save(Place place, int type) { // type 0 = add , else = update
        placeDao.save(place, type);
    }
}
