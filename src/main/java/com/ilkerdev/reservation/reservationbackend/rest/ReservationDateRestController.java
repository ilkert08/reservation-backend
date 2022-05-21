package com.ilkerdev.reservation.reservationbackend.rest;

import com.ilkerdev.reservation.reservationbackend.entity.Place;
import com.ilkerdev.reservation.reservationbackend.entity.ReservationDate;
import com.ilkerdev.reservation.reservationbackend.service.PlaceServiceImpl;
import com.ilkerdev.reservation.reservationbackend.service.ReservationDateServiceImpl;
import com.ilkerdev.reservation.reservationbackend.service.ReservationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReservationDateRestController {

    private ReservationDateServiceImpl reservationDateService;

    @Autowired
    public ReservationDateRestController(ReservationDateServiceImpl reservationDateService) {
        this.reservationDateService = reservationDateService;
    }

    @GetMapping("/reservation-dates")
    public List<ReservationDate> findAll(){
        return reservationDateService.findAll();
    }



    @GetMapping("/reservation-dates/{reservationId}")
    public ReservationDate findById(@PathVariable String reservationId){
        ReservationDate reservationDate = reservationDateService.findById(reservationId);
        if (reservationDate == null){
            throw new RuntimeException("Date not found");
        }
        return reservationDate;

    }

}
