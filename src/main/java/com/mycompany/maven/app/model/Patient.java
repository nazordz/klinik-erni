/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven.app.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @author mac
 */
@Entity
@Table(name = "patients")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class Patient {
    @Id
    @GenericGenerator(name = "UUID4", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "UUID4")
    private String id;

    @Column(name = "patient_number")
    private String patientNumber;

    @Column
    private String name;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "blood_type")
    private String bloodType;

    @Column
    private String gender;

    @Column
    private String address;

    @CreationTimestamp
    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    @CreationTimestamp
    private Timestamp updatedAt;

    public Patient() {}
    public Patient(String patientNumber, String name, Date birthDate, String bloodType, String gender, String address) {
        this.patientNumber = patientNumber;
        this.name = name;
        this.birthDate = birthDate;
        this.bloodType = bloodType;
        this.gender = gender;
        this.address = address;
    }
    
    
    
    
}
