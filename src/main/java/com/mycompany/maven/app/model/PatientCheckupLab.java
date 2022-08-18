/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven.app.model;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
@Table(name = "patient_checkup_labs")
@Data
public class PatientCheckupLab implements Serializable{
    @Id
    @GenericGenerator(name = "UUID4", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "UUID4")
    private String id;
    
    @Column(name = "patient_checkup_id")
    private String patientCheckupId;
    
    @Column(name = "result_lab_checkup")
    private String resultLabCheckup;
    
    @OneToOne(cascade = CascadeType.ALL, targetEntity = PatientCheckup.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_checkup_id", insertable = false, updatable = false)
    private PatientCheckup patientCheckup;
    
    @Column(name = "laboratorium_id")
    private String laboratoriumId;
    
    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Laboratorium.class)
    @JoinColumn(name = "laboratorium_id", insertable = false, updatable = false)
    private Laboratorium laboratorium;
    
    @Column(name = "created_at")
    @CreationTimestamp
    private Timestamp createdAt;
    
    @Column(name = "updated_at")
    @UpdateTimestamp
    private Timestamp updatedAt;
}
