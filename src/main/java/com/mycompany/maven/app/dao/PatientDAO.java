/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven.app.dao;

import com.mycompany.maven.app.model.Patient;
import java.util.List;

/**
 *
 * @author mac
 */
public interface PatientDAO {
    
    public boolean insert(Patient p);
    
    public boolean update(Patient p);

    public boolean delete(String id);

    public Patient getPatientById(String id);

    public List<Patient> getAllPatients();
}

