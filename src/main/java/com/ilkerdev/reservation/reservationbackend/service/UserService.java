package com.ilkerdev.reservation.reservationbackend.service;

import com.ilkerdev.reservation.reservationbackend.entity.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();
    public User findById(String id);
    public void deleteById(String id);
    public void save(User user, int type);
}
