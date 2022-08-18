/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven.app.service;

import com.mycompany.maven.app.model.Admin;
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
public class AdminServiceImpl implements ICrudService<Admin>, IFindByEmailService<Admin>{
    private static final SessionFactory factory = new Configuration().configure().buildSessionFactory(); 
    
    @Override
    public boolean insert(Admin p) {
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
    public boolean update(Admin data) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            Admin admin = session.find(Admin.class, data.getId());
            admin.setName(data.getName());
            admin.setEmail(data.getEmail());
            admin.setPhone(data.getPhone());
            admin.setAddress(data.getAddress());
            if (data.getPassword() != null) {
                admin.setPassword(data.getPassword());
            }
            session.save(admin);
            tx.commit();
        } catch (HibernateException e) {
            System.err.println("Gagal");
            e.printStackTrace();
            tx.rollback();
            return false;
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
            Admin admin = session.get(Admin.class, id);
            session.delete(admin);
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
    public Admin findById(String id) {
        Session session = factory.openSession();
        try {
            Transaction tx = session.beginTransaction();
            Admin admin = session.find(Admin.class, id);
            tx.commit();
            return admin;
        } catch (HibernateException e) {
            System.out.println("Err: " + e.getMessage());
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<Admin> findAll() {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List<Admin> admins = session.createQuery("FROM Admin", Admin.class).list();            
            tx.commit();
            return admins;
        } catch (HibernateException e) {
            System.out.println("Err: " + e.getMessage());
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public Admin findByEmail(String email) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();;
        try {
            Query query = session.createQuery("FROM Admin WHERE email = :email", Admin.class);
            query.setParameter("email", email);
            Admin admin = (Admin) query.getSingleResult();
            tx.commit();
            return admin;
        } catch (NoResultException e) {
        } finally {
            session.close();
        }
        return null;
    }
    
}
