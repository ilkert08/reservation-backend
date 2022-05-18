package com.ilkerdev.reservation.reservationbackend.dao;

import com.ilkerdev.reservation.reservationbackend.entity.Reservation;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ReservationDaoImpl implements ReservationDao{


    private EntityManager entityManager;

    @Autowired
    public ReservationDaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Reservation> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        String queryString = new String("from Reservation");
        Query<Reservation> query = currentSession.createQuery(queryString, Reservation.class);
        List<Reservation> reservations = query.getResultList();

        return reservations;
    }

    @Override
    public Reservation findById(String id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Reservation reservation = currentSession.get(Reservation.class, id);
        return reservation;
    }

    @Transactional
    @Override
    public void deleteById(String id) {
        Session currentSession = entityManager.unwrap(Session.class);
        String query = new String("delete from User where id=:user_id");
        Query theQuery = currentSession.createQuery(query);
        theQuery.setParameter("user_id", id);
        theQuery.executeUpdate();
    }

    @Transactional
    @Override
    public void save(Reservation reservation, int type) { // 0 = add , else = update
        Session currentSession = entityManager.unwrap(Session.class);
        if(type == 0){
            currentSession.save(reservation);
            System.out.println("Saved!");
        }else{
            currentSession.update(reservation);
            System.out.println("Updated!");

        }
    }
}
