/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven.app.service;

import com.mycompany.maven.app.model.Patient;
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
public class PatientServiceImpl implements ICrudService<Patient>{

    private static SessionFactory factory; 

    public PatientServiceImpl() {
        this.factory = new Configuration().configure().buildSessionFactory();
    }
    @Override
    public boolean insert(Patient data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Patient data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Patient findById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Patient> findAll() {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List<Patient> data = session.createQuery("FROM Patient", Patient.class).list();
            tx.commit();
            return data;
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally{
            session.close();
        }
        return null;
    }
    
}
