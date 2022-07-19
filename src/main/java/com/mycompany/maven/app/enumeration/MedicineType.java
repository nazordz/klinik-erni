/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven.app.enumeration;

/**
 *
 * @author mac
 */
public enum MedicineType {
    Pill("Pill"),
    Sirup("Sirup"),
    Salep("Salep");
    
    public final String label;

    private MedicineType(String label) {
        this.label = label;
    }

    @Override 
    public String toString() { 
        return this.label; 
    }
}
