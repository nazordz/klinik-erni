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
import lombok.NoArgsConstructor;

/**
 *
 * @author mac
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Authentication {
    private String name;
    private String email;
    private String phone;
    private Role role;
    private List<String> authorization;
}
