/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.repository.impl;

import com.uav.pojo.Routebuses;
import com.uav.repository.RoutebusesRepository;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class RoutebusesRepositoryImpl implements RoutebusesRepository {
    
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private Environment env;

    @Override
    public List<Routebuses> getRoutebuses(Map<String, String> params, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Routebuses> q = b.createQuery(Routebuses.class);
        Root root = q.from(Routebuses.class);
        q.select(root);
        
        Query query = session.createQuery(q);
        
        return query.getResultList();
    }

    @Override
    public long countRoutebuses() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        Query q = session.createQuery("Select Count(*) From Routebuses");
        
        return Long.parseLong(q.getSingleResult().toString());
    }

    @Override
    public boolean deleteRoutebuses(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        try {
            Routebuses p = session.get(Routebuses.class, id);
            session.delete(p);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        
    }

    @Override
    public boolean addRoutebuses(Routebuses p) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        try {
            session.save(p);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Routebuses getRoutebusesById(int RoutebusesId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        return session.get(Routebuses.class, RoutebusesId);
    }

    @Override
    public List<Routebuses> getRoutebusesByRouteId(int RouteId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Routebuses> q = builder.createQuery(Routebuses.class);
        Root root = q.from(Routebuses.class);
        
//        q.select(root);
        q.where(builder.equal(root.get("routeId"),RouteId));
        
        
        Query query = session.createQuery(q);
        
        return query.getResultList();
    }
    
}
