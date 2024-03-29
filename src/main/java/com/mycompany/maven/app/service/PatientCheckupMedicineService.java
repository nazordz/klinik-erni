/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven.app.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import com.mycompany.maven.app.model.PatientCheckupMedicine;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author mac
 */
public class PatientCheckupMedicineService implements ICrudService<PatientCheckupMedicine>{
    private static SessionFactory factory; 
    public PatientCheckupMedicineService() {
        this.factory = new Configuration().configure().buildSessionFactory();
    }
    
    public void deleteByPatientCheckupId(String checkupId) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createQuery("DELETE FROM PatientCheckupMedicine WHERE patient_checkup_id = :checkup_id");
            query.setParameter("checkup_id", checkupId);
            query.executeUpdate();
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        
    }
    
    public List<PatientCheckupMedicine> findByPatientCheckupId(String checkupId) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createQuery("FROM PatientCheckupMedicine WHERE patient_checkup_id = :checkup_id");
            query.setParameter("checkup_id", checkupId);
            List<PatientCheckupMedicine> checkups = query.list();
            tx.commit();
            return checkups;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public boolean insert(PatientCheckupMedicine data) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(data);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean update(PatientCheckupMedicine data) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            PatientCheckupMedicine checkup = session.find(PatientCheckupMedicine.class, data.getId());
            checkup.setMedicineId(data.getMedicineId());
            checkup.setPatientCheckupId(data.getPatientCheckupId());
            checkup.setQuantity(data.getQuantity());
            session.save(checkup);
            tx.commit();
            return true;
        } catch (Exception e) {
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
            PatientCheckupMedicine checkup = session.find(PatientCheckupMedicine.class, id);
            session.delete(checkup);
            tx.commit();
            return true;
        } catch(NullPointerException e) {}
        catch (HibernateException e) {
            tx.rollback();
            e.printStackTrace(); 
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public PatientCheckupMedicine findById(String id) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            PatientCheckupMedicine checkup = session.find(PatientCheckupMedicine.class, id);
            tx.commit();
            return checkup;
        } catch(NullPointerException e) {}
        catch (HibernateException e) {
            tx.rollback();
            e.printStackTrace(); 
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<PatientCheckupMedicine> findAll() {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            List<PatientCheckupMedicine> checkups = session.createQuery("FROM PatientCheckupMedicine").list();
            tx.commit();
            return checkups;
        } catch(NullPointerException e) {}
        catch (HibernateException e) {
            tx.rollback();
            e.printStackTrace(); 
        } finally {
            session.close();
        }
        return null;
    }
}
