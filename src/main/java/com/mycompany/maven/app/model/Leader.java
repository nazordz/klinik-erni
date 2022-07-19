/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven.app.model;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
@Table(name = "leaders")
@Data
public class Leader implements Serializable {
    
    @Id
    @GenericGenerator(name = "UUID4", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "UUID4")
    private String id;
    
    @Column(nullable = false)
    private String name;
    
    @Column
    private String address;
    
    @Column(nullable = false, unique = true)
    private String email;
    
    @Column(nullable = false, unique = true)
    private String phone;
    
    @Column(nullable = false)
    private String password;
    
    @Column(name = "created_at", updatable = false, nullable = false)
    @CreationTimestamp
    private Timestamp createdAt;
    
    @Column(name = "updated_at", nullable = false)
    @UpdateTimestamp
    private Timestamp updatedAt;
}
