package com.ilkerdev.reservation.reservationbackend.dao;

import com.ilkerdev.reservation.reservationbackend.entity.User;

import java.util.List;

public interface UserDao {

    public List<User> findAll();
    public User findById(String id);
    public void deleteById(String id);
    public void save(User user, int type);
}
