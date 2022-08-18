/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven.app.service;

import com.mycompany.maven.app.model.SpecializeDoctor;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 *
 * @author mac
 */
public class SpecializeDoctorServiceImpl implements ICrudService<SpecializeDoctor> {
    private static final SessionFactory factory = new Configuration().configure().buildSessionFactory();; 
    
    @Override
    public boolean insert(SpecializeDoctor data) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(data);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean update(SpecializeDoctor data) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            SpecializeDoctor sd = session.find(SpecializeDoctor.class, data.getId());
            sd.setName(data.getName());
            sd.setCheckupFee(data.getCheckupFee());
            session.save(sd);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
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
            Query query = session.createQuery("DELETE FROM SpecializeDoctor WHERE id = :id")
                    .setParameter("id", id);
            query.executeUpdate();
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
        }
        return false;
    }

    @Override
    public SpecializeDoctor findById(String id) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            SpecializeDoctor specialize = session.find(SpecializeDoctor.class, id);
            tx.commit();
            return specialize;
        } catch (Exception e) {
            tx.rollback();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<SpecializeDoctor> findAll() {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            List<SpecializeDoctor> listSpecialize = session.createQuery("FROM SpecializeDoctor", SpecializeDoctor.class).list();
            tx.commit();
            return listSpecialize;
        } catch (Exception e) {
            tx.rollback();
        } finally {
            session.close();
        }
        return null;
    }
    
}
