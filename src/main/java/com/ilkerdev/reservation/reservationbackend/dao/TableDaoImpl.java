package com.ilkerdev.reservation.reservationbackend.dao;

import com.ilkerdev.reservation.reservationbackend.entity.Tables;
import com.ilkerdev.reservation.reservationbackend.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;


@Repository
public class TableDaoImpl implements TableDao{

    private EntityManager entityManager;

    @Autowired
    public TableDaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Tables> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        String queryString = new String("from Tables");
        Query<Tables> query = currentSession.createQuery(queryString, Tables.class);
        List<Tables> tables = query.getResultList();
        return tables;
    }

    @Override
    public Tables findById(String id) {
        System.out.println(id);
        Session currentSession = entityManager.unwrap(Session.class);
        String customQuery = "select * from tables where id = " + id;
        Query query = currentSession.createNativeQuery(customQuery, Tables.class);
        Tables table = (Tables) query.getSingleResult();
        return table;
    }

}
