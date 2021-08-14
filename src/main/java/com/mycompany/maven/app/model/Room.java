/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven.app.model;

import com.mycompany.maven.app.enumeration.InUseType;
import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

/**
 *
 * @author mac
 */
@Entity
@Table(name = "rooms")
public class Room implements Serializable{
    
    @Id
    @GenericGenerator(name = "UUID4", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "UUID4")
    private String id;
    
    @Column
    private String name;
    
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "in_use")
    private InUseType inUse;
    
    @Column
    private String description;
    
    @Column(name = "created_at", insertable = false, updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;
    
    @Column(name = "updated_at", insertable = false, updatable = false)
    @UpdateTimestamp
    private Timestamp updatedAt;
    
    public Room() {}
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public InUseType getInUse() {
        return inUse;
    }

    public void setInUse(InUseType inUse) {
        this.inUse = inUse;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    
}
