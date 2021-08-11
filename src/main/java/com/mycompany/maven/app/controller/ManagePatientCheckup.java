/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven.app.controller;

import com.mycompany.maven.app.dao.PatientCheckupDAO;
import com.mycompany.maven.app.model.PatientCheckup;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author mac
 */
public class ManagePatientCheckup implements PatientCheckupDAO {
    private static SessionFactory factory; 

    public ManagePatientCheckup() {
        factory = new Configuration().configure().buildSessionFactory();
    }
    
    @Override
    public List<PatientCheckup> getAllPatientCheckups() {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List<PatientCheckup> checkups = session.createQuery("FROM PatientCheckup", PatientCheckup.class).list();
            tx.commit();
            return checkups;
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace(); 
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public boolean insert(PatientCheckup p) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(p);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace(); 
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean update(PatientCheckup p) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            PatientCheckup checkup = session.find(PatientCheckup.class, p.getId());
            checkup.setDoctorId(p.getDoctorId());
            checkup.setPainComplaint(p.getPainComplaint());
            checkup.setDiagnose(p.getDiagnose());
            checkup.setCost(p.getCost());
            session.save(checkup);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
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
            PatientCheckup checkup = (PatientCheckup) session.get(PatientCheckup.class, id);
            session.delete(checkup);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            System.err.println("Gagal");
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public PatientCheckup getPatientCheckupId(String id) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            PatientCheckup checkup = (PatientCheckup) session.find(PatientCheckup.class, id);
            tx.commit();
            return checkup;
        } catch (HibernateException e) {
            System.err.println("Gagal");
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<PatientCheckup> getAllPatientCheckupPatientId(String PatientId) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM PatientCheckup WHERE patient_id = :patient_id", PatientCheckup.class);
            query.setParameter("patient_id", PatientId);
            List<PatientCheckup> checkups = query.list();
            tx.commit();
            return checkups;
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace(); 
        } finally {
            session.close();
        }
        return null;
    }

}
