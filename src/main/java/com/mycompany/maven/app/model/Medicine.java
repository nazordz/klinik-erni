/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven.app.model;

import com.mycompany.maven.app.enumeration.MedicineType;
import com.mycompany.maven.app.enumeration.MedicineUse;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "medicines")
@Data
public class Medicine {
    @Id
    @GenericGenerator(name = "UUID4", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "UUID4")
    private String id;
    
    @Column
    private String name;
    
    @Column
    @Enumerated(EnumType.STRING)
    private MedicineUse use;
    
    @Column
    @Enumerated(EnumType.STRING)
    private MedicineType type;
            
    @Column
    private Integer stock;
    
    @Column(precision = 15, scale = 2)
    private double price;
    
    @Column(name = "created_at")
    @CreationTimestamp
    private Timestamp createdAt;
    
    @Column(name = "updated_at")
    @UpdateTimestamp
    private Timestamp updatedAt;
}
