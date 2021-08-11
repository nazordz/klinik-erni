/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven.app.dao;

import com.mycompany.maven.app.model.Doctor;
import java.util.List;

/**
 *
 * @author mac
 */
public interface DoctorDAO {
    public boolean insert(Doctor p);
    
    public boolean update(Doctor p);

    public boolean delete(String id);

    public Doctor getDoctorById(String id);

    public List<Doctor> getAllDoctors();
}
