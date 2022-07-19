/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven.app.service;

import com.mycompany.maven.app.model.Medicine;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
/**
 *
 * @author mac
 */
public class MedicineServiceImpl implements ICrudService<Medicine>{
    private static SessionFactory factory; 

    public MedicineServiceImpl() {
        this.factory = new Configuration().configure().buildSessionFactory();
    }
    @Override
    public boolean insert(Medicine data) {
        Transaction tx = null;
        Session session = factory.openSession();
        try {
            tx = session.beginTransaction();
            session.save(data);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace(); 
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean update(Medicine data) {
        Session session = factory.openSession();

        try {
            Transaction tx = session.beginTransaction();
            Medicine medicine = session.find(Medicine.class, data.getId());
            medicine.setName(data.getName());
            medicine.setPrice(data.getPrice());
            medicine.setStock(data.getStock());
            medicine.setType(data.getType());
            medicine.setUse(data.getUse());
            session.save(medicine);
            tx.commit();
        } catch (HibernateException e) {
            System.err.println("Gagal");
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        Session session = factory.openSession();

        try {
            Transaction tx = session.beginTransaction();
            Medicine medicine = session.get(Medicine.class, id);
            session.delete(medicine);
            tx.commit();
        } catch (HibernateException e) {
            System.err.println("Gagal");
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public Medicine findById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Medicine> findAll() {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List<Medicine> data = session.createQuery("FROM Medicine", Medicine.class).list();
            tx.commit();
            return data;
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace(); 
        } finally {
            session.close();
        }
        return null;
    }
    
}
