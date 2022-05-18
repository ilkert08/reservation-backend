package com.ilkerdev.reservation.reservationbackend.dao;

import com.ilkerdev.reservation.reservationbackend.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{


    private EntityManager entityManager;

    @Autowired
    public UserDaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<User> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        String queryString = new String("from User");
        Query<User> query = currentSession.createQuery(queryString, User.class);
        List<User> users = query.getResultList();

        return users;
    }

    @Override
    public User findById(String id) {
        Session currentSession = entityManager.unwrap(Session.class);
        User user = currentSession.get(User.class, id);
        return user;
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
    public void save(User user, int type) { // 0 = add , else = update
        Session currentSession = entityManager.unwrap(Session.class);
        if(type == 0){
            currentSession.save(user);
            System.out.println("Saved!");
        }else{
            currentSession.update(user);
            System.out.println("Updated!");

        }
    }
}
