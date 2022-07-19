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
public enum MedicineUse {
    ONE_TIME_THREE("ONE_TIME_THREE"), // 1x3
    ONE_TIME_TWO("ONE_TIME_TWO"), //1x2
    TWO_TIME_ONE("TWO_TIME_ONE"); //2x1
    
    public final String label;

    private MedicineUse(String label) {
        this.label = label;
    }

    @Override 
    public String toString() { 
        return this.label; 
    }
}
