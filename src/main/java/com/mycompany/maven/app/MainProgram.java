/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven.app;

import com.mycompany.maven.app.enumeration.Role;
import com.mycompany.maven.app.model.Authentication;
import com.mycompany.maven.app.model.Leader;
import com.mycompany.maven.app.service.LeaderServiceImpl;
import com.mycompany.maven.app.util.UpdatableBCrypt;
import com.mycompany.maven.app.view.LoginFrame;
import com.mycompany.maven.app.view.MainFrame;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import javax.swing.JFrame;

/** 
 *
 * @author mac
 */
public class MainProgram {
    private static final UpdatableBCrypt bcrypt = new UpdatableBCrypt(12);
    private static final LeaderServiceImpl leaderService = new LeaderServiceImpl();
    
    public static final Authentication authentication() {
        return new Authentication();
    }
    
    public static void main(String[] args) {
        Authentication auth = authentication();
        MainFrame mainFrame = new MainFrame();
        
        JFrame loginFrame = new LoginFrame(mainFrame);
        loginFrame.setVisible(true);
    }
}
