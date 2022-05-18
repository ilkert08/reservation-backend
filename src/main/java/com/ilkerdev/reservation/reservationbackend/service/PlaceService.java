package com.ilkerdev.reservation.reservationbackend.service;

import com.ilkerdev.reservation.reservationbackend.entity.Place;

import java.util.List;

public interface PlaceService {
    public List<Place> findAll();
    public Place findById(String id);
    public void deleteById(String id);
    public void save(Place place, int type);
}
