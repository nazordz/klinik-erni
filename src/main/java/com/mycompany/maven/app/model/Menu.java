/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven.app.model;

import javax.swing.JPanel;

/**
 *
 * @author mac
 */
public class Menu {

    private JPanel menu;
    private JPanel menuComponent;

    public Menu(JPanel menu, JPanel menuComponent) {
        this.menu = menu;
        this.menuComponent = menuComponent;
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
    
}
