/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven.app.service;

import com.mycompany.maven.app.model.Room;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 *
 * @author mac
 */
public class RoomService implements ICrudService<Room>{
    private static SessionFactory factory; 
    public RoomService() {
        this.factory = new Configuration().configure().buildSessionFactory();
    }
    @Override
    public boolean insert(Room r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Room r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Room> getAllRooms() {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            List<Room> rooms = session.createQuery("FROM Room", Room.class).list();
            tx.commit();
            return rooms;
        } catch (HibernateException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public Room findById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Room> findAll() {
        return getAllRooms();
    }
    
}
