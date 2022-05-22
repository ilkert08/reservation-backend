package com.ilkerdev.reservation.reservationbackend.service;


import com.ilkerdev.reservation.reservationbackend.entity.Reservation;
import com.ilkerdev.reservation.reservationbackend.dao.ReservationDao;
import com.ilkerdev.reservation.reservationbackend.requests.ReservateRequest;
import com.ilkerdev.reservation.reservationbackend.responses.ReservateResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

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

    @Transactional
    @Override
    public ReservateResponse reservate(ReservateRequest  reservateRequest) {
        int count = reservationDao.reservate(reservateRequest);
        ReservateResponse response = new ReservateResponse();


        TimerTask timerTask = new TimerTask() {
            int counter = 0;
            @Override
            public void run() {
                System.out.println("Counter worked: " + counter++);
            }
        };

        Timer timer = new Timer("ReservateTimer");//create a new Timer
        //timer.scheduleAtFixedRate(timerTask, 10, 1000);
        timer.schedule(timerTask, 1000);




        if(count > 0){
            response.setResponseString("200 - Success");
        }else{
            response.setResponseString("400 - 0 rows affected.");
        }
        return response;
    }


}
