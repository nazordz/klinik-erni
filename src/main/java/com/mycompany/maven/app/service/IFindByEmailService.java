/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven.app.service;

/**
 *
 * @author mac
 * @param <T> email is unique
 */
public interface IFindByEmailService<T> {
    public T findByEmail(String email);
}
