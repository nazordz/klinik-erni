/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven.app.service;

import com.mycompany.maven.app.model.Patient;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
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
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Long count = (Long) session.createQuery("SELECT count(*) from Patient").uniqueResult();
        data.setPatientNumber(count.intValue() + 1);
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
    public boolean update(Patient data) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            Patient pat = session.find(Patient.class, data.getId());
            pat.setName(data.getName());
//            pat.setPatientNumber(data.getPatientNumber());
            pat.setAddress(data.getAddress());
            pat.setBirthDate(data.getBirthDate());
            pat.setBloodType(data.getBloodType());
            pat.setGender(data.getGender());
            session.save(pat);
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
            Patient pat = session.find(Patient.class, id);
            session.delete(pat);
            tx.commit();
            return true;
        } catch(Exception e) {
            tx.rollback();
        }
        return false;
    }

    @Override
    public Patient findById(String id) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            Patient pat = session.find(Patient.class, id);
            tx.commit();
            return pat;
        } catch(Exception e) {
            tx.rollback();
        }
        return null;
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
