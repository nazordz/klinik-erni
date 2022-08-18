/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven.app.service;

import com.mycompany.maven.app.model.Laboratorium;
import java.util.Collections;
import java.util.List;
import javax.persistence.NoResultException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
/**
 *
 * @author mac
 */
public class LaboratoriumServiceImpl implements ICrudService<Laboratorium>, IFindByEmailService<Laboratorium> {
    private static SessionFactory factory; 

    public LaboratoriumServiceImpl() {
        this.factory = new Configuration().configure().buildSessionFactory();
    }
    @Override
    public boolean insert(Laboratorium data) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(data);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            tx.rollback();
            e.printStackTrace(); 
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean update(Laboratorium data) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            Laboratorium labData = session.find(Laboratorium.class, data.getId());
            labData.setName(data.getName());
            labData.setEmail(data.getEmail());
            labData.setPhone(data.getPhone());
            labData.setAddress(data.getAddress());
            labData.setDivisionId(data.getDivisionId());
            if (data.getPassword() != null) {
                labData.setPassword(data.getPassword());
            }
            session.save(labData);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            tx.rollback();
            e.printStackTrace(); 
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            Laboratorium labData = session.find(Laboratorium.class, id);
            session.delete(labData);
            tx.commit();
        } catch (HibernateException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            tx.rollback();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public Laboratorium findById(String id) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            Laboratorium labData = session.find(Laboratorium.class, id);
            tx.commit();
            return labData;
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<Laboratorium> findAll() {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        List<Laboratorium> EmptyList = Collections.<Laboratorium>emptyList();  
        try {
            List<Laboratorium> labs = session.createQuery("FROM Laboratorium", Laboratorium.class).list();
            tx.commit();
            return labs;
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            session.close();
        }
        return EmptyList;
    }

    @Override
    public Laboratorium findByEmail(String email) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createQuery("FROM Laboratorium WHERE email = :email");
            query.setParameter("email", email);
            Laboratorium lead = (Laboratorium) query.getSingleResult();
            tx.commit();
            return lead;
        } catch (NoResultException e) {
        } finally {
            session.close();
        }
        return null;
    }
    
}
