/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven.app.service;

import com.mycompany.maven.app.model.Pharmacist;
import java.util.List;
import java.util.Optional;
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
public class PharmacistServiceImpl implements ICrudService<Pharmacist>, IFindByEmailService<Pharmacist> {
private static final SessionFactory factory = new Configuration().configure().buildSessionFactory(); 

    @Override
    public boolean insert(Pharmacist data) {
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
    public boolean update(Pharmacist data) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            Pharmacist recep = session.find(Pharmacist.class, data.getId());
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
            Pharmacist recep = session.find(Pharmacist.class, id);
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
    public Pharmacist findById(String id) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            Pharmacist recep = session.find(Pharmacist.class, id);
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
    public List<Pharmacist> findAll() {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            List<Pharmacist> receps = session.createQuery("FROM Pharmacist", Pharmacist.class).list();
            tx.commit();
            return receps;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public Pharmacist findByEmail(String email) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createQuery("FROM Pharmacist WHERE email = :email");
            query.setParameter("email", email);
            Pharmacist pharmacist = (Pharmacist) query.getSingleResult();
            tx.commit();
            return pharmacist;
        }catch (NoResultException e) {
        } finally {
            session.close();
        }
        return null;
    }
    
}
