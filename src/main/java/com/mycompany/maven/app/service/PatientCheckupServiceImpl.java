/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven.app.service;

import com.mycompany.maven.app.enumeration.CheckupStatus;
import com.mycompany.maven.app.model.PatientCheckup;
import java.util.List;
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
public class PatientCheckupServiceImpl implements ICrudService<PatientCheckup>, IInsertGetIdService<PatientCheckup, String>{
    private static SessionFactory factory; 

    public PatientCheckupServiceImpl() {
        this.factory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public boolean insert(PatientCheckup data) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            Long count = (Long) session.createQuery("SELECT count(*) from PatientCheckup").uniqueResult();
            data.setCheckupNumber(count.intValue() + 1);
            session.save(data);
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

    public boolean directUpdate(PatientCheckup pc) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.update(pc);
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
    public boolean update(PatientCheckup data) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            PatientCheckup pc = session.find(PatientCheckup.class, data.getId());
            pc.setPatientId(data.getPatientId());
            pc.setPharmacistId(data.getPharmacistId());
            pc.setCost(data.getCost());
            
            if (data.getPatientCheckupDoctor() != null) {
                pc.setPatientCheckupDoctor(data.getPatientCheckupDoctor());
            }
            
            if (data.getPatientCheckupLab() != null) {
                pc.setPatientCheckupLab(data.getPatientCheckupLab());
            }
            
            if (data.getLaboratoriumDivisionId() != null) {
                pc.setLaboratoriumDivisionId(data.getLaboratoriumDivisionId());
            }
            
            if (data.getCheckupStatus() != null) {
                pc.setCheckupStatus(data.getCheckupStatus());
            }
            if (data.getCost() > 0) {
                pc.setCost(data.getCost());
            }
            session.save(pc);
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
    public boolean delete(String id) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            PatientCheckup pc = new PatientCheckup();
            pc.setId(id);
            session.delete(pc);
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
    public PatientCheckup findById(String id) {
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
    public List<PatientCheckup> findAll() {
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
    
    public List<PatientCheckup> findBySpecializeDoctorId(String specialize) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List<PatientCheckup> checkups = session.createQuery("FROM PatientCheckup WHERE specialize_doctor_id = :specialize", PatientCheckup.class)
                                            .setParameter("specialize", specialize)
                                            .list();
            tx.commit();
            return checkups;
        } catch (NullPointerException e) {}
        catch (HibernateException e) {
            e.printStackTrace(); 
        } finally {
            session.close();
        }
        return null;
    }
    
    public List<PatientCheckup> findByLaboratoriumDivisionId(String divisionId) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List<PatientCheckup> checkups = session.createQuery("FROM PatientCheckup WHERE laboratorium_division_id = :division", PatientCheckup.class)
                                            .setParameter("division", divisionId)
                                            .list();
            tx.commit();
            return checkups;
        } catch (NullPointerException e) {}
        catch (HibernateException e) {
            e.printStackTrace(); 
        } finally {
            session.close();
        }
        return null;
    }
    
    public List<PatientCheckup> findByCheckupStatus(CheckupStatus status) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            System.out.println("status: ");
            System.out.println(status.ordinal());
            List<PatientCheckup> checkups = session.createQuery("FROM PatientCheckup WHERE checkup_status >= :status", PatientCheckup.class)
                                            .setParameter("status", status.ordinal())
                                            .list();
            tx.commit();
            return checkups;
        } catch (NullPointerException e) {}
        catch (HibernateException e) {
            e.printStackTrace(); 
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public String insertGetId(PatientCheckup data) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            Long count = (Long) session.createQuery("SELECT count(*) from PatientCheckup").uniqueResult();
            data.setCheckupNumber(count.intValue() + 1);
            String id = (String) session.save(data);
            tx.commit();
            return id;
        } catch (HibernateException e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }
    
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
