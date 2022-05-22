package com.ilkerdev.reservation.reservationbackend.entity;

import javax.persistence.*;

@Entity
@Table(name = "places")
public class Place {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;



    public Place(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Place(){

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' + '}';
    }
}
