/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven.app;

import com.mycompany.maven.app.dao.PatientDAO;
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
public class ManagePatient implements PatientDAO {
    private static SessionFactory factory; 
    
    public ManagePatient() {
        factory = new Configuration().configure().buildSessionFactory();
    }
    
    @Override
    public boolean insert(Patient p) {
        Transaction tx = null;
        Session session = factory.openSession();
        try {
            tx = session.beginTransaction();
            session.save(p);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            System.err.println("Gagal");
            e.printStackTrace(); 
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean update(Patient p) {
        Session session = factory.openSession();

        try {
            Transaction tx = session.beginTransaction();
            session.update(p);
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
            Patient patient = (Patient) session.get(Patient.class, id);
            session.delete(patient);
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
    public Patient getPatientById(String id) {
        Session session = factory.openSession();
        Patient patient = null;
        try {
            Transaction tx = session.beginTransaction();
            patient = (Patient) session.get(Patient.class, id);
            tx.commit();
            return patient;
        } catch (HibernateException e) {
            System.err.println("Gagal");
            e.printStackTrace();
        } finally {
            session.close();
        }
        return patient;
    }

    @Override
    public List<Patient> getAllPatients() {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List<Patient> patients = session.createQuery("FROM Patient").list();
            tx.commit();
            return patients;
        } catch (HibernateException e) {
            System.err.println("Gagal");
        }
        finally {
            session.close();
        }
        return null;
    }
}
