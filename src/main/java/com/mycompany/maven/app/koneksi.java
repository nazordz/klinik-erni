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
public class koneksi {
    private Connection con;
    public Connection connect () {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Koneksi Berhasil"); 
        }catch (ClassNotFoundException e) {
            System.out.println("Koneksi Gagal" +e);
        }
        String url = "jdbc:mysql://localhost:3306/db_klinik";
        try {
            con = DriverManager.getConnection(url, "root","");
            System.out.println("Koneksi Database Berhasil");
        } catch (SQLException e) {
            System.out.println("Gagal Koneksi Database");
        }
        return con;
    }
}
