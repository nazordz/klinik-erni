/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven.app.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
@Data
@Entity
@Table(name = "laboratorium_divisions")
public class LaboratoriumDivision implements Serializable{
    @Id
    @GenericGenerator(name = "UUID4", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "UUID4")
    private String id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(name = "cost", precision = 15, scale = 2)
    private double cost;
    
    @OneToMany(cascade = CascadeType.ALL, targetEntity = Laboratorium.class, mappedBy = "division")
    private List<Laboratorium> laboratoriums;
    
    @OneToMany(cascade = CascadeType.ALL, targetEntity = PatientCheckup.class, mappedBy = "laboratoriumDivision")
    private List<PatientCheckup> patientCheckups;
    
    @Column(name = "created_at", updatable = false, nullable = false)
    @CreationTimestamp
    private Timestamp createdAt;
    
    @Column(name = "updated_at", nullable = false)
    @UpdateTimestamp
    private Timestamp updatedAt;
}
