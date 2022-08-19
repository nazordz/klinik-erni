/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven.app.service;

import com.mycompany.maven.app.model.Doctor;
import java.util.List;
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
public class DoctorServiceImpl implements ICrudService<Doctor>, IFindByEmailService<Doctor>{
    private static final SessionFactory factory = new Configuration().configure().buildSessionFactory();; 
    
    @Override
    public boolean insert(Doctor p) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(p);
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
    public boolean update(Doctor p) {
        Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
        try {
            Doctor dokter = session.find(Doctor.class, p.getId());
            dokter.setName(p.getName());
            dokter.setStrNumber(p.getStrNumber());
            dokter.setBirthDate(p.getBirthDate());
            dokter.setAddress(p.getAddress());
            dokter.setSpecializeDoctorId(p.getSpecializeDoctorId());
            dokter.setGender(p.getGender());
            if (p.getPassword() != null) {
                dokter.setPassword(p.getPassword());
            }
            session.save(dokter);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            System.err.println("Gagal");
            e.printStackTrace();
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
            Doctor dokter = session.get(Doctor.class, id);
            session.delete(dokter);
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
    public Doctor findById(String id) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Doctor doctor = session.find(Doctor.class, id);            
            tx.commit();
            return doctor;
        } catch (NullPointerException e) {}
        catch (HibernateException e) {
            System.out.println("Err: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Doctor> findAll() {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List<Doctor> doctors = session.createQuery("FROM Doctor", Doctor.class).list();            
            tx.commit();
            return doctors;
        } catch (HibernateException e) {
            System.out.println("Err: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Doctor findByEmail(String email) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();;
        try {
            Query query = session.createQuery("FROM Doctor WHERE email = :email");
            query.setParameter("email", email);
            Doctor doctor = (Doctor) query.getSingleResult();
            tx.commit();
            return doctor;
        } catch (NoResultException e) {
        } finally {
            session.close();
        }
        return null;
    }
    
}
