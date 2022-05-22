package com.ilkerdev.reservation.reservationbackend.requests;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReservateRequest {
    private int reservationId;
    private int status;
}
