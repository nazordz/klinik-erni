/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven.app.util;

import com.mycompany.maven.app.controller.ManagePatient;
import com.mycompany.maven.app.dao.PatientDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author mac
 */
public class HibernateUtil {
    
    private static SessionFactory sessionFactory;
    private static PatientDAO patientDao;
    
    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable e) {
            Logger.getLogger(HibernateUtil.class.getName()).log(Level.SEVERE, null, e);
            throw new ExceptionInInitializerError(e);
        }
    }
    
//    public static PatientDAO getPatientDao() {
//        if (patientDao == null) {
//            patientDao = new ManagePatient(getSessionFactory().openSession());
//        }
//        return patientDao;
//    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static void shutdown(){
        try {
            sessionFactory.close();
        } catch (HibernateException e) {
            Logger.getLogger(HibernateUtil.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
