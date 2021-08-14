/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven.app.controller;

import com.mycompany.maven.app.dao.DoctorDAO;
import com.mycompany.maven.app.model.Doctor;
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
public class ManageDoctor implements DoctorDAO{
    private static SessionFactory factory; 
    public ManageDoctor() {
        this.factory = new Configuration().configure().buildSessionFactory();
    }
    @Override
    public boolean insert(Doctor p) {
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
    public boolean update(Doctor p) {
        Session session = factory.openSession();

        try {
            Transaction tx = session.beginTransaction();
            Doctor dokter = session.find(Doctor.class, p.getId());
            dokter.setName(p.getName());
            dokter.setStrNumber(p.getStrNumber());
            dokter.setBirthDate(p.getBirthDate());
            dokter.setAddress(p.getAddress());
            dokter.setSpecialization(p.getSpecialization());
            dokter.setGender(p.getGender());
            session.save(dokter);
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
            Doctor dokter = session.get(Doctor.class, id);
            session.delete(dokter);
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
    public Doctor getDoctorById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Doctor> getAllDoctors() {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List<Doctor> doctors = session.createQuery("FROM Doctor", Doctor.class).list();            
            tx.commit();
            return doctors;
        } catch (HibernateException e) {
            System.out.println("Err: " + e.getMessage());
        }
        return null;
    }
    
}
