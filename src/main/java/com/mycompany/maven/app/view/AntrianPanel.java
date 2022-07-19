/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven.app.view;

import com.mycompany.maven.app.util.AsyncUtil;
import java.awt.Color;

/**
 *
 * @author mac
 */
public class AntrianPanel extends javax.swing.JPanel {

    private Integer loket1;
    private Integer loket2;
    /**
     * Creates new form AntrianPanel
     */
    public AntrianPanel() {
        this.loket1 = 0;
        this.loket2 = 0;
        initComponents();
    }
    
    private void nextTurn(String loket) {
        if (loket.equals("loket1")) {
            this.loket1 = this.loket1 + 1;
            Loket1Queue.setText("A "+this.loket1);
        } else if(loket.equals("loket2")) {
            this.loket2 = this.loket2 + 1;
            Loket2Queue.setText("B "+this.loket2);
        }
    }
    
    private void resetQueue(String loket) {
        if (loket.equals("loket1")) {
            this.loket1 = 0;
            Loket1Queue.setText("A 0");
        } else if (loket.equals("loket2")) {
            this.loket2 = 0;
            Loket2Queue.setText("B 0");
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        Loket1Panel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        Loket1Queue = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        BtnNextLoket1 = new javax.swing.JButton();
        BtnRecallLoket1 = new javax.swing.JButton();
        BtnResetLoket1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        Loket2Queue = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        BtnNextLoket2 = new javax.swing.JButton();
        BtnRecallLoket2 = new javax.swing.JButton();
        BtnResetLoket2 = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        titleLabel.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(99, 110, 114));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        titleLabel.setText("Antrian");
        titleLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 20, 0, 0));
        titleLabel.setPreferredSize(new java.awt.Dimension(34, 40));
        add(titleLabel, java.awt.BorderLayout.NORTH);

        Loket1Panel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 5));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(300, 240));
        jPanel1.setRequestFocusEnabled(false);
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel5.setBackground(new java.awt.Color(52, 73, 94));
        jPanel5.setPreferredSize(new java.awt.Dimension(200, 50));
        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 12));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Loket 1");
        jPanel5.add(jLabel1);

        jPanel1.add(jPanel5, java.awt.BorderLayout.NORTH);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 20));

        Loket1Queue.setBackground(new java.awt.Color(52, 73, 94));
        Loket1Queue.setFont(new java.awt.Font("Ubuntu", 1, 48)); // NOI18N
        Loket1Queue.setText("A 0");
        jPanel3.add(Loket1Queue);

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanel4.setBackground(new java.awt.Color(52, 73, 94));
        jPanel4.setPreferredSize(new java.awt.Dimension(200, 70));
        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 6));

        BtnNextLoket1.setText("Selanjutnya");
        BtnNextLoket1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNextLoket1ActionPerformed(evt);
            }
        });
        jPanel4.add(BtnNextLoket1);

        BtnRecallLoket1.setText("Panggil Ulang");
        BtnRecallLoket1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRecallLoket1ActionPerformed(evt);
            }
        });
        jPanel4.add(BtnRecallLoket1);

        BtnResetLoket1.setText("Reset");
        BtnResetLoket1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnResetLoket1ActionPerformed(evt);
            }
        });
        jPanel4.add(BtnResetLoket1);

        jPanel1.add(jPanel4, java.awt.BorderLayout.SOUTH);

        Loket1Panel.add(jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(300, 240));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel6.setBackground(new java.awt.Color(52, 73, 94));
        jPanel6.setPreferredSize(new java.awt.Dimension(200, 50));
        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 12));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Loket 2");
        jPanel6.add(jLabel3);

        jPanel2.add(jPanel6, java.awt.BorderLayout.NORTH);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 20));

        Loket2Queue.setBackground(new java.awt.Color(52, 73, 94));
        Loket2Queue.setFont(new java.awt.Font("Ubuntu", 1, 48)); // NOI18N
        Loket2Queue.setText("B 0");
        jPanel7.add(Loket2Queue);

        jPanel2.add(jPanel7, java.awt.BorderLayout.CENTER);

        jPanel8.setBackground(new java.awt.Color(52, 73, 94));
        jPanel8.setPreferredSize(new java.awt.Dimension(200, 70));
        jPanel8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 6));

        BtnNextLoket2.setText("Selanjutnya");
        BtnNextLoket2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNextLoket2ActionPerformed(evt);
            }
        });
        jPanel8.add(BtnNextLoket2);

        BtnRecallLoket2.setText("Panggil Ulang");
        BtnRecallLoket2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRecallLoket2ActionPerformed(evt);
            }
        });
        jPanel8.add(BtnRecallLoket2);

        BtnResetLoket2.setText("Reset");
        BtnResetLoket2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnResetLoket2ActionPerformed(evt);
            }
        });
        jPanel8.add(BtnResetLoket2);

        jPanel2.add(jPanel8, java.awt.BorderLayout.SOUTH);

        Loket1Panel.add(jPanel2);

        add(Loket1Panel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void BtnNextLoket1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNextLoket1ActionPerformed
        // TODO add your handling code here:
        nextTurn("loket1");
    }//GEN-LAST:event_BtnNextLoket1ActionPerformed

    private void BtnNextLoket2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNextLoket2ActionPerformed
        // TODO add your handling code here:
        nextTurn("loket2");
    }//GEN-LAST:event_BtnNextLoket2ActionPerformed

    private void BtnResetLoket1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnResetLoket1ActionPerformed
        // TODO add your handling code here:
        resetQueue("loket1");
    }//GEN-LAST:event_BtnResetLoket1ActionPerformed

    private void BtnResetLoket2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnResetLoket2ActionPerformed
        // TODO add your handling code here:
        resetQueue("loket2");
    }//GEN-LAST:event_BtnResetLoket2ActionPerformed

    private void BtnRecallLoket1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRecallLoket1ActionPerformed
        // TODO add your handling code here:
        Color defaultColor = Loket1Queue.getBackground();
        Loket1Queue.setForeground(Color.RED);
        AsyncUtil.setTimeout(() -> {
            Loket1Queue.setForeground(defaultColor);
        }, 1000);
    }//GEN-LAST:event_BtnRecallLoket1ActionPerformed

    private void BtnRecallLoket2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRecallLoket2ActionPerformed
        // TODO add your handling code here:
        Color defaultColor = Loket2Queue.getBackground();
        Loket2Queue.setForeground(Color.RED);
        AsyncUtil.setTimeout(() -> {
            Loket2Queue.setForeground(defaultColor);
        }, 1000);
    }//GEN-LAST:event_BtnRecallLoket2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnNextLoket1;
    private javax.swing.JButton BtnNextLoket2;
    private javax.swing.JButton BtnRecallLoket1;
    private javax.swing.JButton BtnRecallLoket2;
    private javax.swing.JButton BtnResetLoket1;
    private javax.swing.JButton BtnResetLoket2;
    private javax.swing.JPanel Loket1Panel;
    private javax.swing.JLabel Loket1Queue;
    private javax.swing.JLabel Loket2Queue;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}