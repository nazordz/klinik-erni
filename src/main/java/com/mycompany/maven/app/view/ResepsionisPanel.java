/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven.app.view;

import com.mycompany.maven.app.model.Receptionist;
import com.mycompany.maven.app.service.ReceptionistServiceImpl;
import com.mycompany.maven.app.util.UpdatableBCrypt;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mac
 */
public class ResepsionisPanel extends javax.swing.JPanel {

    private final ReceptionistServiceImpl recepcionistService;
    private static final UpdatableBCrypt bcrypt = new UpdatableBCrypt(12);
    private String selectedId;
    /**
     * Creates new form ResepsionisPanel
     */
    public ResepsionisPanel() {
        initComponents();
        this.recepcionistService = new ReceptionistServiceImpl();
        getTableData();
        PasswordTitle.setVisible(false);
        PasswordInput.setVisible(false);
    }
    
    public void getTableData() {
        DefaultTableModel tm = (DefaultTableModel) TableRecepsionist.getModel();
        tm.setRowCount(0);
        List<Receptionist> receptionist = recepcionistService.findAll();
        for (Receptionist rcp : receptionist) {
            Object[] row = {
                rcp.getId(),
                rcp.getName(),
                rcp.getEmail(),
                rcp.getPhone()
            };
            tm.addRow(row);
        }
    }
    
    public void resetForm() {
        NameInput.setText(null);
        EmailInput.setText(null);
        PhoneInput.setText(null);
        AddressInput.setText(null);
        PasswordCheck.setSelected(false);
        PasswordInput.setText(null);
        this.selectedId = null;
    }

    public void store() {
        Receptionist recep = new Receptionist();
        recep.setName(NameInput.getText());
        recep.setEmail(EmailInput.getText());
        recep.setPhone(PhoneInput.getText());
        recep.setAddress(AddressInput.getText());
        if (PasswordCheck.isSelected()) {
            recep.setPassword(bcrypt.hash(new String(PasswordInput.getPassword())));
        }
        if (selectedId != null) {
            recep.setId(selectedId);
            recepcionistService.update(recep);
        }else {
            recepcionistService.insert(recep);
        }
    }
    
    public void delete() {
        recepcionistService.delete(selectedId);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        BtnSave = new javax.swing.JButton();
        BtnReset = new javax.swing.JButton();
        BtnDelete = new javax.swing.JButton();
        NameInput = new javax.swing.JTextField();
        EmailInput = new javax.swing.JTextField();
        PhoneInput = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        AddressInput = new javax.swing.JTextArea();
        PasswordCheck = new javax.swing.JCheckBox();
        PasswordTitle = new javax.swing.JLabel();
        PasswordInput = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableRecepsionist = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        jLabel1.setText("Nama");

        jLabel2.setText("Email");

        jLabel3.setText("No. Telepon");

        jLabel4.setText("Alamat");

        BtnSave.setText("Simpan");
        BtnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSaveActionPerformed(evt);
            }
        });

        BtnReset.setText("Reset");
        BtnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnResetActionPerformed(evt);
            }
        });

        BtnDelete.setText("Hapus");
        BtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDeleteActionPerformed(evt);
            }
        });

        AddressInput.setColumns(10);
        AddressInput.setRows(3);
        jScrollPane1.setViewportView(AddressInput);

        PasswordCheck.setText("Masukan Password ?");
        PasswordCheck.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                PasswordCheckItemStateChanged(evt);
            }
        });
        PasswordCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordCheckActionPerformed(evt);
            }
        });

        PasswordTitle.setText("Password");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnSave)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(EmailInput)
                    .addComponent(NameInput)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BtnReset)
                        .addGap(18, 18, 18)
                        .addComponent(BtnDelete))
                    .addComponent(PhoneInput, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PasswordCheck)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(PasswordTitle)
                        .addGap(18, 18, 18)
                        .addComponent(PasswordInput)))
                .addGap(16, 16, 16))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(NameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(EmailInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(PhoneInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PasswordCheck)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PasswordTitle)
                            .addComponent(PasswordInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnSave)
                            .addComponent(BtnReset)
                            .addComponent(BtnDelete))))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        add(jPanel1, java.awt.BorderLayout.NORTH);

        jPanel2.setLayout(new java.awt.BorderLayout());

        TableRecepsionist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id", "Nama", "Email", "No. Telepon"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableRecepsionist.removeColumn(TableRecepsionist.getColumnModel().getColumn(0));
        TableRecepsionist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableRecepsionistMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TableRecepsionist);

        jPanel2.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void BtnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnResetActionPerformed
        // TODO add your handling code here:
        resetForm();
        getTableData();
    }//GEN-LAST:event_BtnResetActionPerformed

    private void PasswordCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordCheckActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordCheckActionPerformed

    private void PasswordCheckItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_PasswordCheckItemStateChanged
        // TODO add your handling code here:
        PasswordInput.setText(null);
        if (evt.getStateChange() == 1) {
            PasswordTitle.setVisible(true);
            PasswordInput.setVisible(true);
        } else {
            PasswordInput.setVisible(false);
            PasswordTitle.setVisible(false);
        }
    }//GEN-LAST:event_PasswordCheckItemStateChanged

    private void TableRecepsionistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableRecepsionistMouseClicked
        // TODO add your handling code here:
        this.selectedId = TableRecepsionist.getModel().getValueAt(TableRecepsionist.getSelectedRow(), 0).toString();
        Receptionist recep = recepcionistService.findById(selectedId);
        NameInput.setText(recep.getName());
        EmailInput.setText(recep.getEmail());
        PhoneInput.setText(recep.getPhone());
        AddressInput.setText(recep.getAddress());
    }//GEN-LAST:event_TableRecepsionistMouseClicked

    private void BtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSaveActionPerformed
        // TODO add your handling code here:
        store();
        resetForm();
        getTableData();
    }//GEN-LAST:event_BtnSaveActionPerformed

    private void BtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeleteActionPerformed
        // TODO add your handling code here:
         int confirm = JOptionPane.showOptionDialog(
                this,
                "Anda Yakin?",
                "Hapus",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, 
                null,
                null,
                null
        );
        if (confirm == JOptionPane.YES_OPTION) {
            delete();
            resetForm();
            getTableData();
            JOptionPane.showMessageDialog(this, "Data telah dihapus.");
        }
    }//GEN-LAST:event_BtnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea AddressInput;
    private javax.swing.JButton BtnDelete;
    private javax.swing.JButton BtnReset;
    private javax.swing.JButton BtnSave;
    private javax.swing.JTextField EmailInput;
    private javax.swing.JTextField NameInput;
    private javax.swing.JCheckBox PasswordCheck;
    private javax.swing.JPasswordField PasswordInput;
    private javax.swing.JLabel PasswordTitle;
    private javax.swing.JTextField PhoneInput;
    private javax.swing.JTable TableRecepsionist;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
