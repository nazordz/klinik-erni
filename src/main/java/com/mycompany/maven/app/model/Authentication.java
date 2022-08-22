/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven.app.model;

import com.mycompany.maven.app.enumeration.Role;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author mac
 */
@AllArgsConstructor
@NoArgsConstructor
public class Authentication {
    @Setter @Getter
    public String id;
    @Setter @Getter
    public String name;
    @Setter @Getter
    public String email;
    @Setter @Getter
    public String phone;
    @Setter @Getter
    public Role role;
    @Setter @Getter
    public List<String> authorization;
    
    public String getRoleText() {
        if (role  == Role.ROLE_ADMIN) {
            return "Admin";
        } else if (role == Role.ROLE_DOCTOR) {
            return "Dokter";
        } else if (role == Role.ROLE_LAB) {
            return "Laboratorium";
        } else if (role == Role.ROLE_LEADER) {
            return "Pimpinan";
        } else if (role == Role.ROLE_PHARMACIST) {
            return "Apoteker";
        } else if (role == Role.ROLE_RECEPCIONIST) {
            return "Resepsionis";
        }
        return null;
    }
}
