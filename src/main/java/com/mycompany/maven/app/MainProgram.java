/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven.app;

import com.mycompany.maven.app.model.Authentication;
import com.mycompany.maven.app.view.LoginFrame;
import com.mycompany.maven.app.view.MainFrame;
import javax.swing.JFrame;

/** 
 *
 * @author mac
 */
public class MainProgram {
    
    public static Authentication authentication() {
        return new Authentication();
    }
    
    public static void main(String[] args) {
        Authentication auth = authentication();
        MainFrame mainFrame = new MainFrame();
        
        JFrame loginFrame = new LoginFrame(auth, mainFrame);
        loginFrame.setVisible(true);
    }
}
