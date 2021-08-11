/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven.app.dao;
import com.mycompany.maven.app.model.PatientCheckup;
import java.util.List;
/**
 *
 * @author mac
 */
public interface PatientCheckupDAO {
    public boolean insert(PatientCheckup p);
    
    public boolean update(PatientCheckup p);

    public boolean delete(String id);
    
    public PatientCheckup getPatientCheckupId(String id);
    
    public List<PatientCheckup> getAllPatientCheckups();
    public List<PatientCheckup> getAllPatientCheckupPatientId(String PatientId);
}
