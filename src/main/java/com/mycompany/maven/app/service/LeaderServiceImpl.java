/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven.app.service;

import com.mycompany.maven.app.model.Leader;
import java.util.List;
import java.util.Optional;
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
public class LeaderServiceImpl implements ICrudService<Leader>, IFindByEmailService<Leader> {
private static SessionFactory factory; 

    public LeaderServiceImpl() {
        this.factory = new Configuration().configure().buildSessionFactory();
    }
    @Override
    public boolean insert(Leader data) {
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
    public boolean update(Leader data) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            Leader recep = session.find(Leader.class, data.getId());
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
            Leader recep = session.find(Leader.class, id);
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
    public Leader findById(String id) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            Leader recep = session.find(Leader.class, id);
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
    public List<Leader> findAll() {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            List<Leader> receps = session.createQuery("FROM Leader", Leader.class).list();
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
    public Leader findByEmail(String email) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createQuery("FROM Leader WHERE email = :email");
            query.setParameter("email", email);
            Optional<Leader> lead = (Optional<Leader>) query.getSingleResult();
            tx.commit();
            return lead.orElse(null);
        } catch (javax.persistence.NoResultException e)  {}
        catch (HibernateException e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            session.close();
        }
        return null;
    }
    
}
