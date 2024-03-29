/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven.app.view;

import com.mycompany.maven.app.enumeration.Role;
import com.mycompany.maven.app.model.Authentication;
import com.mycompany.maven.app.model.Doctor;
import com.mycompany.maven.app.model.Leader;
import com.mycompany.maven.app.model.Pharmacist;
import com.mycompany.maven.app.model.Receptionist;
import com.mycompany.maven.app.model.Admin;
import com.mycompany.maven.app.model.Laboratorium;
import com.mycompany.maven.app.service.AdminServiceImpl;
import com.mycompany.maven.app.service.DoctorServiceImpl;
import com.mycompany.maven.app.service.LaboratoriumServiceImpl;
import com.mycompany.maven.app.service.LeaderServiceImpl;
import com.mycompany.maven.app.service.PharmacistServiceImpl;
import com.mycompany.maven.app.service.ReceptionistServiceImpl;
import com.mycompany.maven.app.util.UpdatableBCrypt;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author mac
 */
public class LoginFrame extends javax.swing.JFrame {
    private static final UpdatableBCrypt bcrypt = new UpdatableBCrypt(12);
    private static final LeaderServiceImpl leaderService = new LeaderServiceImpl();
    private static final ReceptionistServiceImpl recepcionistService = new ReceptionistServiceImpl();
    private static final DoctorServiceImpl doctorService = new DoctorServiceImpl();
    private static final PharmacistServiceImpl pharmacistService = new PharmacistServiceImpl();
    private static final AdminServiceImpl adminService = new AdminServiceImpl();
    private static final LaboratoriumServiceImpl labService = new LaboratoriumServiceImpl();
    private static Authentication authentication;
    private static MainFrame mainFrame;
    /**
     * Creates new form LoginFrame 

     */
    public LoginFrame(Authentication authentication, MainFrame mainFrame) {
        initComponents();
        this.authentication = authentication;
        this.mainFrame = mainFrame;
    }
    
    public Authentication signIn(String email, String password) {
        // Login admin
        Admin admin = adminService.findByEmail(email);
        if (admin != null) {
            if (bcrypt.verifyHash(password, admin.getPassword())) {
                return new Authentication(
                        admin.getId(),
                        admin.getName(),
                        admin.getEmail(),
                        admin.getPhone(),
                        Role.ROLE_ADMIN,
                        Arrays.asList("REPORT")
                );
            } 
        }
        
        //check leader
        Leader user = leaderService.findByEmail(email);
        if (user != null) {  
            if (bcrypt.verifyHash(password, user.getPassword())) {
                return new Authentication(
                        user.getId(),
                        user.getName(),
                        user.getEmail(),
                        user.getPhone(),
                        Role.ROLE_LEADER,
                        Arrays.asList("REPORT")
                );
            }    
        }
        
        // check recepcionist
        Receptionist receptionist = recepcionistService.findByEmail(email);
        if (receptionist != null) {
            if (bcrypt.verifyHash(password, receptionist.getPassword())) {
                return new Authentication(
                        receptionist.getId(),
                        receptionist.getName(),
                        receptionist.getEmail(),
                        receptionist.getPhone(),
                        Role.ROLE_RECEPCIONIST,
                        Arrays.asList("RECEPCIONIST")
                );
            }
        }
        
        // doctor
        Doctor doctor = doctorService.findByEmail(email);
        if (doctor != null) {
            if (bcrypt.verifyHash(password, doctor.getPassword())) {
                return new Authentication(
                        doctor.getId(),
                        doctor.getName(),
                        doctor.getEmail(),
                        doctor.getPhone(),
                        Role.ROLE_DOCTOR,
                        Arrays.asList("DOCTOR")
                );
            }
        }
        
        // pharmacist
        Pharmacist pharmacist = pharmacistService.findByEmail(email);
        if (pharmacist != null) {
            if (bcrypt.verifyHash(password, pharmacist.getPassword())) {
                return new Authentication(
                        pharmacist.getId(),
                        pharmacist.getName(),
                        pharmacist.getEmail(),
                        pharmacist.getPhone(),
                        Role.ROLE_PHARMACIST,
                        Arrays.asList("PHARMACIST")
                );
            }
        }
        
        // lab
        Laboratorium lab = labService.findByEmail(email);
        if (lab != null) {
            if (bcrypt.verifyHash(password, lab.getPassword())) {
                return new Authentication(
                        lab.getId(),
                        lab.getName(),
                        lab.getEmail(),
                        lab.getPhone(),
                        Role.ROLE_LAB,
                        Arrays.asList("LABORATORIUM")
                );
            }
        }
        return null;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Center = new javax.swing.JPanel();
        Logo = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Box = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        LoginPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        EmailInput = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        PasswordInput = new javax.swing.JPasswordField();
        BtnLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login Klinik");
        setBackground(new java.awt.Color(52, 73, 94));
        setName("LoginFrame"); // NOI18N
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(new java.awt.FlowLayout());

        Center.setLayout(new javax.swing.BoxLayout(Center, javax.swing.BoxLayout.Y_AXIS));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/medical-logo.png"))); // NOI18N
        Logo.add(jLabel2);

        Center.add(Logo);

        Box.setBackground(new java.awt.Color(255, 255, 255));
        Box.setPreferredSize(new java.awt.Dimension(260, 180));
        Box.setLayout(new java.awt.BorderLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Login");
        Box.add(jLabel1, java.awt.BorderLayout.NORTH);

        LoginPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Email");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Password");

        BtnLogin.setBackground(new java.awt.Color(47, 170, 148));
        BtnLogin.setText("Login");
        BtnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LoginPanelLayout = new javax.swing.GroupLayout(LoginPanel);
        LoginPanel.setLayout(LoginPanelLayout);
        LoginPanelLayout.setHorizontalGroup(
            LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnLogin)
                    .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(EmailInput)
                        .addComponent(PasswordInput, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        LoginPanelLayout.setVerticalGroup(
            LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginPanelLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(EmailInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(PasswordInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(BtnLogin)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        Box.add(LoginPanel, java.awt.BorderLayout.CENTER);

        Center.add(Box);

        getContentPane().add(Center);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLoginActionPerformed
        // TODO add your handling code here:
        
        Authentication attempt = signIn(EmailInput.getText(), new String(PasswordInput.getPassword()));
        if (attempt != null) {
//            mainFrame.setAuthentication(attempt);
            authentication.setId(attempt.getId());
            authentication.setName(attempt.getName());
            authentication.setEmail(attempt.getEmail());
            authentication.setPhone(attempt.getPhone());
            authentication.setRole(attempt.getRole());
            authentication.setAuthorization(attempt.getAuthorization());
            System.out.println("LoginAuth:");
            System.out.println(authentication);
            
            mainFrame.setAuthentication(authentication);
            this.setVisible(false);
            mainFrame.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Akun tidak ditemukan!");
        }
    }//GEN-LAST:event_BtnLoginActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Box;
    private javax.swing.JButton BtnLogin;
    private javax.swing.JPanel Center;
    private javax.swing.JTextField EmailInput;
    private javax.swing.JPanel LoginPanel;
    private javax.swing.JPanel Logo;
    private javax.swing.JPasswordField PasswordInput;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
