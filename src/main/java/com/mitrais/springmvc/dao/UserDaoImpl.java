package com.mitrais.springmvc.dao;

import com.mitrais.springmvc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public User findUserByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User where username = :username");
        query.setString("username", username);

        return (User) query.uniqueResult();
    }
}
