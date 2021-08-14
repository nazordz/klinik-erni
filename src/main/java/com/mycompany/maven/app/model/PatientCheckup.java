/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven.app.model;

import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
/**
 *
 * @author mac
 */
@Entity
@Table(name = "patient_checkups")
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
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }
    
    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }
    
    public String getPainComplaint() {
        return painComplaint;
    }

    public void setPainComplaint(String painComplaint) {
        this.painComplaint = painComplaint;
    }

    public String getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}
