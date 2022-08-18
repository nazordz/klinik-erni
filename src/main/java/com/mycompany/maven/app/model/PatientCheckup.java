/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven.app.model;

import com.mycompany.maven.app.enumeration.CheckupStatus;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "patient_checkups")
@Data
public class PatientCheckup implements java.io.Serializable  {
    @Id
    @GenericGenerator(name = "UUID4", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "UUID4")
    private String id;
    
    @Column(name = "checkup_number")
    private Integer checkupNumber;
    
    @Column(name = "checkup_date")
    private Date checkupDate;
    
    @Column(name = "patient_id")
    private String patientId;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Patient.class)
    @JoinColumn(name = "patient_id", insertable = false, updatable = false)
    private Patient patient;
    
    @Column(name = "specialize_doctor_id")
    private String specializeDoctorId;
    
    @Column(name = "laboratorium_division_id")
    private String laboratoriumDivisionId;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = SpecializeDoctor.class)
    @JoinColumn(name = "specialize_doctor_id", insertable = false, updatable = false)
    private SpecializeDoctor specializeDoctor;
    
    @ManyToOne(cascade = CascadeType.ALL, targetEntity = LaboratoriumDivision.class)
    @JoinColumn(name = "laboratorium_division_id", insertable = false, updatable = false)
    private LaboratoriumDivision laboratoriumDivision;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "patientCheckup", targetEntity = PatientCheckupDoctor.class)
    private PatientCheckupDoctor patientCheckupDoctor;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "patientCheckup", targetEntity = PatientCheckupLab.class)
    private PatientCheckupLab PatientCheckupLab;
    
    @Column
    private String note;
    
    @Column(precision = 15, scale = 2)
    private double cost;
    
   @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER, mappedBy = "patientCheckup" )
   private List<PatientCheckupMedicine> patientCheckupMedicines;
   
   @Column(name = "pharmacist_id")
   private String pharmacistId;
   
   @ManyToOne(cascade = CascadeType.ALL, targetEntity = Pharmacist.class)
   @JoinColumn(name = "pharmacist_id", insertable = false, updatable = false)
   private Pharmacist pharmacist;
    
   @Enumerated
   @Column(name = "checkup_status")
   private CheckupStatus checkupStatus;
   
    @Column(name = "created_at")
    @CreationTimestamp
    private Timestamp createdAt;
    
    @Column(name = "updated_at")
    @UpdateTimestamp
    private Timestamp updatedAt;

    public PatientCheckup(){}
    public PatientCheckup(String patientId, String doctorId, String painComplaint, String diagnose, Double cost) {
        this.patientId = patientId;
//        this.doctorId = doctorId;
//        this.painComplaint = painComplaint;
//        this.diagnose = diagnose;
        this.cost = cost;
    }
}
