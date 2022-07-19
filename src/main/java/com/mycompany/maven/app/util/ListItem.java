package com.mycompany.maven.app.util;

import lombok.AllArgsConstructor;
import lombok.Data;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mac
 */
@Data
@AllArgsConstructor
public class ListItem {
    private String key;
    private String value;

    @Override
    public String toString()
    {
        return key;
    }

}
