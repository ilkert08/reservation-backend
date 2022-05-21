package com.ilkerdev.reservation.reservationbackend.dao;

import com.ilkerdev.reservation.reservationbackend.entity.Reservation;
import com.ilkerdev.reservation.reservationbackend.entity.ReservationDate;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ReservationDateDaoImpl implements ReservationDateDao{

    private EntityManager entityManager;

    @Autowired
    public ReservationDateDaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }


    @Override
    public List<ReservationDate> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        String queryString = new String("from ReservationDate");
        Query<ReservationDate> query = currentSession.createQuery(queryString, ReservationDate.class);
        List<ReservationDate> reservations = query.getResultList();

        return reservations;
    }

    @Override
    public ReservationDate findById(String id) {
        Session currentSession = entityManager.unwrap(Session.class);
        ReservationDate reservation = currentSession.get(ReservationDate.class, id);
        return reservation;
    }
}
