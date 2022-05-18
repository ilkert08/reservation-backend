package com.ilkerdev.reservation.reservationbackend.entity;

import javax.persistence.*;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @Column(name = "placeid")
    private int placeId;

    @Column(name = "tableid")
    private int tableId;

    @Column(name = "ownerid")
    private int ownerId;

    @Column(name = "dateid")
    private int dateId;

    public Reservation(String id, int placeId, int tableId, int ownerId, int dateId) {
        this.id = id;
        this.placeId = placeId;
        this.tableId = tableId;
        this.ownerId = ownerId;
        this.dateId = dateId;
    }

    public Reservation(){

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

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public int getDateId() {
        return dateId;
    }

    public void setDateId(int dateId) {
        this.dateId = dateId;
    }
}
