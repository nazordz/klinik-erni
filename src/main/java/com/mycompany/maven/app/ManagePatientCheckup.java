/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven.app;

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
//            List<PatientCheckup> checkups = session.get(PatientCheckup.class, "id");
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(PatientCheckup p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(PatientCheckup id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PatientCheckup getPatientCheckupId(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
