/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven.app.controller;

import com.mycompany.maven.app.dao.BookedRoomDAO;
import com.mycompany.maven.app.model.BookedRoom;
import com.mycompany.maven.app.model.Record;
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
public class ManageBookedRoom implements BookedRoomDAO {

    private static SessionFactory factory;
    public ManageBookedRoom() {
        this.factory = new Configuration().configure().buildSessionFactory();
    }
    
    public boolean entryRecord(BookedRoom br) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            Record record = new Record();
            record.setBookedRoomId(br.getId());
            record.setPatientId(br.getPatientId());
            record.setCost(br.getCost());
            session.save(record);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            System.err.println("Error Entry record: " + e.getMessage());
        } finally {
            session.close();
        }
        return false;
    }
    
     public boolean updateRecord(BookedRoom br) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createQuery("FROM Record where booked_room_id = :book_room_id");
            query.setParameter("book_room_id", br.getId());
            query.setFirstResult(0);
            query.setMaxResults(1);
            List<Record> r = (List<Record>) (Record) query.list();
            Record myRecord = r.get(0);
            myRecord.setCost(0);
            
            Record record = new Record();
            record.setId(myRecord.getId());
            record.setCost(br.getCost());
            session.save(record);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            System.err.println("Error Entry record: " + e.getMessage());
        } finally {
            session.close();
        }
        return false;
    }
    
    public void deleteRecord(String BookedRoomId) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            Record record = session.get(Record.class, BookedRoomId);
            session.delete(record);
        }  catch (HibernateException e) {
            e.printStackTrace();
            System.out.println("Error : " + e.getMessage());
            if (tx != null) tx.rollback();
        } finally {
            session.close();
        }
    }
    
    @Override
    public boolean insert(BookedRoom br) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(br);
            tx.commit();
            if (!entryRecord(br)) {
                return false;
            }
//            Query query = session.createQuery("FROM Record where room_id = :room_id");
//            query.setParameter("room_id", br.getId());
//            query.setFirstResult(0);
//            query.setMaxResults(1);
//            List<Record> r = (List<Record>) (Record) query.list();
//            Record myRecord = r.get(0);
//            myRecord.setCost(0);
            
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
            System.out.println("Error : " + e.getMessage());
            if (tx != null) tx.rollback();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean update(BookedRoom br) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.update(br);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
            System.out.println("Error : " + e.getMessage());
            if (tx != null) tx.rollback();
//            String err = ((org.hibernate.JDBCException) e.getCause()).getSQL();
//            System.err.println("tes : " + err);
        }
        finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            BookedRoom br = session.find(BookedRoom.class, id);
            session.delete(br);
            tx.commit();
//            deleteRecord(id);
            return true;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public BookedRoom getBookedRoomById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<BookedRoom> getAllBookedRooms() {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            List<BookedRoom> bookedRooms = session.createQuery("From BookedRoom", BookedRoom.class).list();
            tx.commit();
            return bookedRooms;
        } catch (HibernateException e) {
            System.out.println("Error : " + e.getMessage());
        }
        return null;
    }
    
}
