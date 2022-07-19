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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PatientCheckupMedicine findById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PatientCheckupMedicine> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
