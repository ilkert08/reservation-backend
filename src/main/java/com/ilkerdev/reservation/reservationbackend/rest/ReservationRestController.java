package com.ilkerdev.reservation.reservationbackend.rest;

import com.ilkerdev.reservation.reservationbackend.entity.Reservation;
import com.ilkerdev.reservation.reservationbackend.requests.ReservateRequest;
import com.ilkerdev.reservation.reservationbackend.responses.ReservateResponse;
import com.ilkerdev.reservation.reservationbackend.service.ReservationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api")
public class ReservationRestController {
    private ReservationServiceImpl reservationService;

    @Autowired
    public ReservationRestController(ReservationServiceImpl reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/reservations")
    public List<Reservation> findAll(){
        return reservationService.findAll();
    }

    @PostMapping("/reservations")
    public Reservation addReservation(@RequestBody Reservation reservation){
        // user.setId("");
        reservationService.save(reservation, 0);
        return reservation;
    }

    @PutMapping("/reservations")
    public Reservation updateReservation(@RequestBody Reservation reservation){
        reservationService.save(reservation , 1); // 0 = add , else = update
        return reservation;
    }

    @DeleteMapping("/reservations/{reservationId}")
    public String deleteReservation(@PathVariable String reservationId){
        Reservation reservation = reservationService.findById(reservationId);
        if(reservation == null){
            throw new RuntimeException("reservations not found.");
        }
        reservationService.deleteById(reservationId);
        return "reservations " + reservationId + " is deleted.";
    }

    @GetMapping("/reservations/{reservationId}")
    public Reservation findById(@PathVariable String reservationId){
        Reservation reservation = reservationService.findById(reservationId);
        if (reservation == null){
            throw new RuntimeException("User not found");
        }
        return  reservation;
    }


    @PostMapping("/reservate")
    public ReservateResponse Reservate(@RequestBody ReservateRequest reservateRequest){
        ReservateResponse response = reservationService.reservate(reservateRequest);
        return response;
    }



}
