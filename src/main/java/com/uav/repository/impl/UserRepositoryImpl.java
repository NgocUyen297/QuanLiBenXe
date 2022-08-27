/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.repository.impl;

import com.uav.repository.UserRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import com.uav.pojo.Users;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository{
    
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public boolean addUser(Users user) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(user);
            return true;
        } catch (HibernateException ex) {
            System.err.println("===========" + ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Users> getUser(String username) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Users> q = b.createQuery(Users.class);
        Root root = q.from(Users.class);
        q.select(root);
        
        if(!username.isEmpty())
        {
            Predicate p = b.equal(root.get("username"), username.trim());
            q = q.where(p);
        }
        
        Query query = session.createQuery(q);
        return query.getResultList();
    
    }
    
}
