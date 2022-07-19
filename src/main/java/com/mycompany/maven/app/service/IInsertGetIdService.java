package com.mycompany.maven.app.service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mac
 */
public interface IInsertGetIdService<T, R> {
    public R insertGetId(T data);
}
