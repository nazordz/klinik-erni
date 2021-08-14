/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven.app.controller;

import com.mycompany.maven.app.dao.RoomDAO;
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
public class ManageRoom implements RoomDAO{
    private static SessionFactory factory; 
    public ManageRoom() {
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

    @Override
    public Room getRoomById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
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
    
}
