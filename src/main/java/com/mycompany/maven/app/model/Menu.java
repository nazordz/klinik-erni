/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven.app.model;

import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author mac
 */
public class Menu {
    
    private String name;
    private JPanel menu;
    private JPanel menuComponent;
    private ArrayList<Menu> children;

    public Menu(String name, JPanel menu, JPanel menuComponent) {
        this.name = name;
        this.menu = menu;
        this.menuComponent = menuComponent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the menu
     */
    public JPanel getMenu() {
        return menu;
    }

    /**
     * @param menu the menu to set
     */
    public void setMenu(JPanel menu) {
        this.menu = menu;
    }

    /**
     * @return the menuComponent
     */
    public JPanel getMenuComponent() {
        return menuComponent;
    }

    /**
     * @param menuComponent the menuComponent to set
     */
    public void setMenuComponent(JPanel menuComponent) {
        this.menuComponent = menuComponent;
    }

    public ArrayList<Menu> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Menu> children) {
        this.children = children;
    }
    
}
