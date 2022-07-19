/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven.app.model;

import com.mycompany.maven.app.enumeration.GenderType;
import com.mycompany.maven.app.enumeration.SpecializationType;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

/**
 *
 * @author mac
 */
@Entity
@Table(name = "doctors")
@Data
public class Doctor implements java.io.Serializable {
    
    @Id
    @GenericGenerator(name = "UUID4", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "UUID4")
    private String id;
    
    @Column(name = "str_number")
    private String strNumber;
    
    @Column
    private String name;
    
    @Column(nullable = false, unique = true)
    private String email;
    
    @Column(nullable = false, unique = true)
    private String phone;
    
    @Column(name = "birth_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date BirthDate;
    
    @Column
    @Enumerated(EnumType.STRING)
    private SpecializationType Specialization;
    
    @Enumerated(EnumType.STRING)
    @Column
    private GenderType gender;
    
    @Column
    private String address;
    
    @Column
    private String password;
    
    @Column(name = "created_at")
    @CreationTimestamp
    private Timestamp createdAt;
    
    @Column(name = "updated_at")
    @UpdateTimestamp
    private Timestamp updatedAt;
    
    @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER, mappedBy = "doctor")
    private List<PatientCheckup> patientCheckups; 
}
