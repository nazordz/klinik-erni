/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven.app.service;

import com.mycompany.maven.app.model.LaboratoriumDivision;
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
public class LabDivisionServiceImpl implements ICrudService<LaboratoriumDivision> {
    private static final SessionFactory factory = new Configuration().configure().buildSessionFactory();; 
    
    @Override
    public boolean insert(LaboratoriumDivision data) {
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
    public boolean update(LaboratoriumDivision data) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            LaboratoriumDivision sd = session.find(LaboratoriumDivision.class, data.getId());
            sd.setName(data.getName());
            sd.setCost(data.getCost());
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
            Query query = session.createQuery("DELETE FROM LaboratoriumDivision WHERE id = :id")
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
    public LaboratoriumDivision findById(String id) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            LaboratoriumDivision specialize = session.find(LaboratoriumDivision.class, id);
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
    public List<LaboratoriumDivision> findAll() {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            List<LaboratoriumDivision> listDiv = session.createQuery("FROM LaboratoriumDivision", LaboratoriumDivision.class).list();
            tx.commit();
            return listDiv;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }
    
}
