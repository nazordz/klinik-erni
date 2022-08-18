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
import org.hibernate.annotations.SQLDelete;

/**
 * @author mac
 */
@Entity
@Table(name = "patients")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@SQLDelete(sql = "UPDATE products SET is_deleted = true WHERE id = ?")
@Data
public class Patient {
    @Id
    @GenericGenerator(name = "UUID4", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "UUID4")
    private String id;
    
    @Column(name = "patient_number", unique = true, nullable = false, length = 8)
    private Integer patientNumber;

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

    @Column(name = "is_deleted")
    private boolean isDeleted;
}
