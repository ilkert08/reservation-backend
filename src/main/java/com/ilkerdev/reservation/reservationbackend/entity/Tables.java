package com.ilkerdev.reservation.reservationbackend.entity;

import javax.persistence.*;
import javax.persistence.Entity;


@Entity
@Table(name = "tables")
public class Tables {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @Column(name = "placeid")
    private int placeId;

    @Column(name = "rezerved")
    private int reserved;

    public Tables(){

    }

    public Tables(String id, int placeId, int reserved){
        this.id = id;
        this.placeId = placeId;
        this.reserved = reserved;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }

    public int getReserved() {
        return reserved;
    }

    public void setReserved(int reserved) {
        this.reserved = reserved;
    }

    @Override
    public String toString() {
        return "Tables{" +
                "id='" + id + '\'' +
                ", placeId=" + placeId +
                ", reserved=" + reserved +
                '}';
    }
}
