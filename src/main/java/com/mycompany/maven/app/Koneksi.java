/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Bean
 */
public class Koneksi {
    private Connection con;
    public Connection connect () {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e) {
            System.out.println("Koneksi Gagal" +e);
        }
        String url = "jdbc:mysql://localhost:3306/db_klinik";
        try {
            con = DriverManager.getConnection(url, "root","adb3l1cak");
        } catch (SQLException e) {
            System.out.println("Gagal Koneksi Database");
        }
        return con;
    }
}
