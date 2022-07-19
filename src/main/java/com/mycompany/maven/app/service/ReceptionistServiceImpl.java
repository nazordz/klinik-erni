/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven.app.service;

import com.mycompany.maven.app.model.Receptionist;
import java.util.List;
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
public class ReceptionistServiceImpl implements ICrudService<Receptionist>, IFindByEmailService<Receptionist> {
private static SessionFactory factory; 

    public ReceptionistServiceImpl() {
        this.factory = new Configuration().configure().buildSessionFactory();
    }
    @Override
    public boolean insert(Receptionist data) {
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
    public boolean update(Receptionist data) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            Receptionist recep = session.find(Receptionist.class, data.getId());
            recep.setName(data.getName());
            recep.setEmail(data.getEmail());
            recep.setPhone(data.getPhone());
            recep.setAddress(data.getAddress());
            if (data.getPassword() != null) {
                recep.setPassword(data.getPassword());
            }
            session.save(recep);
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
            Receptionist recep = session.find(Receptionist.class, id);
            session.delete(recep);
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
    public Receptionist findById(String id) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            Receptionist recep = session.find(Receptionist.class, id);
            tx.commit();
            return recep;
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<Receptionist> findAll() {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            List<Receptionist> receps = session.createQuery("FROM Receptionist", Receptionist.class).list();
            tx.commit();
            return receps;
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public Receptionist findByEmail(String email) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createQuery("FROM Receptionist WHERE email = :email");
            query.setParameter("email", email);
            Receptionist recep = (Receptionist) query.getSingleResult();
            tx.commit();
            return recep;
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            session.close();
        }
        return null;
    }
    
}
