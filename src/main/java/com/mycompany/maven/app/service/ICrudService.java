/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven.app.service;

import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author mac
 * @param <T> Model
 */
public interface ICrudService<T> {
    
    public static SessionFactory factory = new Configuration().configure().buildSessionFactory(); 
    
    public boolean insert(T data);
    
    public boolean update(T data);

    public boolean delete(String id);

    public T findById(String id);

    public List<T> findAll();   
}
