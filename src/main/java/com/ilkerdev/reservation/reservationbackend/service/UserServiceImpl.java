package com.ilkerdev.reservation.reservationbackend.service;


import com.ilkerdev.reservation.reservationbackend.dao.UserDao;
import com.ilkerdev.reservation.reservationbackend.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public List<User> findAll() {

        return userDao.findAll();
    }

    @Override
    public User findById(String id) {
        return userDao.findById(id);
    }

    @Override
    public void deleteById(String id) {
        userDao.deleteById(id);
    }

    @Override
    public void save(User user, int type) { // type 0 = add , else = update
        userDao.save(user, type);
    }
}
