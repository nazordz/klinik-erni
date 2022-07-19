/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author mac
 */
@Entity
@Table(name = "patient_checkup_medicines")
@Data
public class PatientCheckupMedicine {
    @Id
    @GenericGenerator(name = "UUID4", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "UUID4")
    private String id;
    
    @Column(name = "medicine_id")
    private String medicineId;
    
    @Column(name = "patient_checkup_id")
    private String patientCheckupId;
    
    @ManyToOne(targetEntity = Medicine.class, fetch = FetchType.EAGER ,cascade = CascadeType.ALL)
    @JoinColumn(name = "medicine_id", insertable = false, updatable = false)
    private Medicine medicine;
    
    @ManyToOne(targetEntity = PatientCheckup.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_checkup_id", insertable = false, updatable = false)
    private PatientCheckup patientCheckup;
}
