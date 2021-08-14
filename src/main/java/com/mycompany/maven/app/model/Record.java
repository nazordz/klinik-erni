/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven.app.model;

import java.sql.Timestamp;
import javax.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author mac
 */
@Entity
@Table(name = "records")
public class Record implements java.io.Serializable {
    public Record() {}
    
    @Id
    @GenericGenerator(name = "UUID4", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "UUID4")
    private String id;
    
    @Column(name = "patient_id")
    private String patientId;
    
    @Column(name ="booked_room_id")
    private String bookedRoomId;
    
    @Column(name = "patient_checkup_id")
    private String patientCheckupId;
    
    @Column(precision = 15, scale = 2)
    private double cost;
    
    @Column(name = "created_at")
    @CreationTimestamp
    private Timestamp createdAt;
    
    @ManyToOne(targetEntity = Patient.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id", insertable = false, updatable = false)
    private Patient patient;
    
    @ManyToOne(targetEntity = Doctor.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "doctor_id", insertable = false, updatable = false)
    private Doctor doctor;
    
    @ManyToOne(cascade = CascadeType.ALL, targetEntity = BookedRoom.class)
    @JoinColumn(name = "booked_room_id", insertable = false, updatable = false)
    public BookedRoom bookedRoom;
    
    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
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

    public String getBookedRoomId() {
        return bookedRoomId;
    }

    public void setBookedRoomId(String bookedRoomId) {
        this.bookedRoomId = bookedRoomId;
    }

    public String getPatientCheckupId() {
        return patientCheckupId;
    }

    public void setPatientCheckupId(String patientCheckupId) {
        this.patientCheckupId = patientCheckupId;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
    
}
