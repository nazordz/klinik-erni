/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven.app.model;

import java.sql.Timestamp;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
/**
 *
 * @author mac
 */
@Entity
@Table(name = "patient_checkups")
@Data
public class PatientCheckup implements java.io.Serializable  {
    @Id
    @GenericGenerator(name = "UUID4", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "UUID4")
    private String id;
    
    @Column(name = "patient_id")
    private String patientId;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Patient.class)
    @JoinColumn(name = "patient_id", insertable = false, updatable = false)
    private Patient patient;
    
    @Column(name = "doctor_id")
    private String doctorId;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Doctor.class)
    @JoinColumn(name = "doctor_id", insertable = false, updatable = false)
    private Doctor doctor;
    
    @Column(name = "pain_complaint")
    private String painComplaint;
    
    @Column
    private String diagnose;
    
    @Column(precision = 15, scale = 2)
    private double cost;
    
   @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER, mappedBy = "patientCheckup" )
   private List<PatientCheckupMedicine> patientCheckupMedicines;
    
    @Column(name = "created_at")
    @CreationTimestamp
    private Timestamp createdAt;
    
    @Column(name = "updated_at")
    @UpdateTimestamp
    private Timestamp updatedAt;

    public PatientCheckup(){}
    public PatientCheckup(String patientId, String doctorId, String painComplaint, String diagnose, Double cost) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.painComplaint = painComplaint;
        this.diagnose = diagnose;
        this.cost = cost;
    }
}
