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
public enum SpecializationType {
    Gigi("Gigi"),
    Jantung("Jantung"),
    ParuParu("Paru-paru"),
    Umum("Umum");
    public final String label;

    private SpecializationType(String label) {
        this.label = label;
    }

    @Override 
    public String toString() { 
        return this.label; 
    }
}
