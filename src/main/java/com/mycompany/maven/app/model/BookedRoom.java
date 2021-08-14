/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven.app.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author mac
 */
@Entity
@Table(name = "booked_rooms")
public class BookedRoom implements Serializable{

    @Id
    @GenericGenerator(name = "UUID4", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "UUID4")
    private String id;
    
    @Column(name = "room_id")
    private String roomId;
    
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, targetEntity = Room.class)
    @JoinColumn(name = "room_id", insertable = false, updatable = false)
    private Room room;
    
    @Column(name = "patient_id")
    private String patientId;
    
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, targetEntity = Patient.class)
    @JoinColumn(name = "patient_id", insertable = false, updatable = false)
    private Patient patient;
    
    @Temporal(TemporalType.DATE)
    @Column
    private Date from;
    
    @Temporal(TemporalType.DATE)
    @Column
    private Date until;
    
    @Column(precision = 15, scale = 2)
    private double cost;
    
    @Column(name = "created_at", insertable = false, updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;
    
    public BookedRoom() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getPatientId() {
        return patientId;
    }

    public Room getRoom() {
        return room;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getUntil() {
        return until;
    }

    public void setUntil(Date until) {
        this.until = until;
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
