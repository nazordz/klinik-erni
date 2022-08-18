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
import com.mycompany.maven.app.model.PatientCheckupLab;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author mac
 */
public class CheckupLabServiceImpl implements ICrudService<PatientCheckupLab>{
    private static SessionFactory factory; 
    public CheckupLabServiceImpl() {
        this.factory = new Configuration().configure().buildSessionFactory();
    }
    
    public void deleteByPatientCheckupId(String checkupId) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createQuery("DELETE FROM PatientCheckupLab WHERE patient_checkup_id = :checkup_id");
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

    @Override
    public boolean insert(PatientCheckupLab data) {
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
    public boolean update(PatientCheckupLab data) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            PatientCheckupLab checkupLab = session.find(PatientCheckupLab.class, data.getId());
            checkupLab.setLaboratoriumId(data.getLaboratoriumId());
            checkupLab.setPatientCheckupId(data.getPatientCheckupId());
            checkupLab.setResultLabCheckup(data.getResultLabCheckup());
            session.save(checkupLab);
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
            PatientCheckupLab checkup = session.find(PatientCheckupLab.class, id);
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
    public PatientCheckupLab findById(String id) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            PatientCheckupLab checkup = session.find(PatientCheckupLab.class, id);
            tx.commit();
            return checkup;
        } catch(NullPointerException e) {}
        catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace(); 
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<PatientCheckupLab> findAll() {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List<PatientCheckupLab> checkups = session.createQuery("FROM PatientCheckupLab", PatientCheckupLab.class).list();
            tx.commit();
            return checkups;
        } catch(NullPointerException e) {}
        catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace(); 
        } finally {
            session.close();
        }
        return null;
    }
}
