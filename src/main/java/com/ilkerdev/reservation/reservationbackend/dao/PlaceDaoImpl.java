package com.ilkerdev.reservation.reservationbackend.dao;

import com.ilkerdev.reservation.reservationbackend.entity.Place;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class PlaceDaoImpl implements PlaceDao{


    private EntityManager entityManager;

    @Autowired
    public PlaceDaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Place> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        String queryString = new String("from Place");
        Query<Place> query = currentSession.createQuery(queryString, Place.class);
        List<Place> places = query.getResultList();

        return places;
    }

    @Override
    public Place findById(String id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Place place = currentSession.get(Place.class, id);
        return place;
    }

    @Transactional
    @Override
    public void deleteById(String id) {
        Session currentSession = entityManager.unwrap(Session.class);
        String query = new String("delete from Place where id=:place_id");
        Query theQuery = currentSession.createQuery(query);
        theQuery.setParameter("place_id", id);
        theQuery.executeUpdate();
    }

    @Transactional
    @Override
    public void save(Place place, int type) { // 0 = add , else = update
        Session currentSession = entityManager.unwrap(Session.class);
        if(type == 0){
            currentSession.save(place);
            System.out.println("Saved!");
        }else{
            currentSession.update(place);
            System.out.println("Updated!");

        }
    }
}
