/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven.app;

import com.mycompany.maven.app.dao.PatientDAO;
import com.mycompany.maven.app.model.Patient;
import com.mycompany.maven.app.util.HibernateUtil;
import com.mycompany.maven.app.view.PasienFormFrame;
import com.mycompany.maven.app.view.PasienPanel;
import java.util.List;
import javax.swing.JFrame;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 *
 * @author mac
 */
public class ManagePatient implements PatientDAO {
    private Session session;
//    private Transaction trans;
    
    public ManagePatient() {
        this.session = HibernateUtil.getSessionFactory().openSession();
//        this.trans = session.beginTransaction();
    }

    public void openForm() {
        JFrame form = new PasienFormFrame();
        form.setVisible(true);
    }
    
    public void refreshTable() {
        PasienPanel panel = new PasienPanel();
        panel.getDataTable();
    }
    
    @Override
    public boolean insert(Patient p) {
        Transaction tx = null;
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
        try {
            Session sesi = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = sesi.beginTransaction();
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
        try {
            return session.createQuery("FROM Patient").list();
        } catch (HibernateException e) {
            System.err.println("Gagal");
        }
        finally {
            session.close();
        }
        return null;
    }
}
