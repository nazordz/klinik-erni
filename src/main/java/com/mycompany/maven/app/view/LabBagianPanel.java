/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven.app.view;

import com.mycompany.maven.app.model.LaboratoriumDivision;
import com.mycompany.maven.app.service.LabDivisionServiceImpl;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author mac
 */
public class LabBagianPanel extends javax.swing.JPanel {
    private final MainFrame mainFrame;
    private final LabDivisionServiceImpl labDivisionServiceImpl;
    private String selectedId;
    /**
     * Creates new form LaboratoriumDivisionPanel
     */
    public LabBagianPanel(MainFrame mainFrame, LabDivisionServiceImpl labDivisionServiceImpl) {
        this.mainFrame = mainFrame;
        this.labDivisionServiceImpl = labDivisionServiceImpl;
        initComponents();
        this.getDataTable();
        this.TableSpecializes.removeColumn(TableSpecializes.getColumnModel().getColumn(0));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        SpecializeInput = new javax.swing.JTextField();
        CostInput = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        SaveButton = new javax.swing.JButton();
        RemoveButton = new javax.swing.JToggleButton();
        RefreshButton = new javax.swing.JButton();
        ResetButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableSpecializes = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 5));

        jLabel3.setText("Laboratorium");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel3);

        jLabel4.setText("/");
        jPanel5.add(jLabel4);

        jLabel5.setText("Spesialis");
        jPanel5.add(jLabel5);

        jPanel3.add(jPanel5, java.awt.BorderLayout.WEST);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel6, java.awt.BorderLayout.EAST);

        jPanel2.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jLabel1.setText("Bagian");

        jLabel2.setText("Biaya");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CostInput, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SpecializeInput, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(334, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(SpecializeInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(CostInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 5, 10));

        SaveButton.setText("Simpan");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });
        jPanel7.add(SaveButton);

        RemoveButton.setText("Hapus");
        RemoveButton.setVisible(false);
        RemoveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveButtonActionPerformed(evt);
            }
        });
        jPanel7.add(RemoveButton);

        RefreshButton.setText("Refresh");
        RefreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshButtonActionPerformed(evt);
            }
        });
        jPanel7.add(RefreshButton);

        ResetButton.setText("Reset");
        ResetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetButtonActionPerformed(evt);
            }
        });
        jPanel7.add(ResetButton);

        jPanel2.add(jPanel7, java.awt.BorderLayout.PAGE_END);

        add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel1.setLayout(new java.awt.BorderLayout());

        TableSpecializes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id", "Nama", "Biaya", "dibuat"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        // TableSpecializes.removeColumn(TableSpecializes.getColumnModel().getColumn(0));
        TableSpecializes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableSpecializesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableSpecializes);
        if (TableSpecializes.getColumnModel().getColumnCount() > 0) {
            TableSpecializes.getColumnModel().getColumn(0).setResizable(false);
            TableSpecializes.getColumnModel().getColumn(1).setResizable(false);
            TableSpecializes.getColumnModel().getColumn(2).setResizable(false);
            TableSpecializes.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        this.mainFrame.navigate("laboratorium");
    }//GEN-LAST:event_jLabel3MouseClicked

    private void getDataTable() {
        DefaultTableModel tm = (DefaultTableModel) TableSpecializes.getModel();
        tm.setRowCount(0);
        try {
            List<LaboratoriumDivision> lists = this.labDivisionServiceImpl.findAll();
            for (LaboratoriumDivision spe : lists) {
                Object[] newRow = {
                    spe.getId(),
                    spe.getName(),
                    spe.getCost(),
                    spe.getCreatedAt()
                };
                tm.addRow(newRow);
            }
            tm.fireTableDataChanged();
            TableSpecializes.repaint();
        } catch (HibernateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private void refreshTable() {
        getDataTable();
    }
    
    private void resetForm() {
        SpecializeInput.setText("");
        CostInput.setText("");
        this.selectedId = null;
        refreshTable();
    }
    
    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        // TODO add your handling code here:
        LaboratoriumDivision form = new LaboratoriumDivision();
        form.setName(SpecializeInput.getText());
        form.setCost(Double.parseDouble(CostInput.getText()));
        boolean isSaved = false;
        if (selectedId != null) {
            form.setId(selectedId);
            isSaved = labDivisionServiceImpl.update(form);
        } else {
            isSaved = labDivisionServiceImpl.insert(form);
        }
        if (isSaved) {
            refreshTable();
            resetForm();
            JOptionPane.showMessageDialog(this, "Berhasil disimpan!");
        } else {
            JOptionPane.showMessageDialog(this, "Gagal disimpan!");
        }
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void RemoveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveButtonActionPerformed
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
            labDivisionServiceImpl.delete(selectedId);
            resetForm();
            refreshTable();
            JOptionPane.showMessageDialog(this, "Berhasil dihapus!");
        }
    }//GEN-LAST:event_RemoveButtonActionPerformed

    private void RefreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshButtonActionPerformed
        // TODO add your handling code here:
        refreshTable();
    }//GEN-LAST:event_RefreshButtonActionPerformed

    private void ResetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetButtonActionPerformed
        // TODO add your handling code here:
        resetForm();
        this.RemoveButton.setVisible(false);
    }//GEN-LAST:event_ResetButtonActionPerformed

    private void TableSpecializesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableSpecializesMouseClicked
        // TODO add your handling code here:
        int row = TableSpecializes.getSelectedRow();
        this.selectedId = TableSpecializes.getModel().getValueAt(row, 0).toString();
        SpecializeInput.setText(TableSpecializes.getModel().getValueAt(row, 1).toString());
        CostInput.setText(TableSpecializes.getModel().getValueAt(row, 2).toString());
        this.RemoveButton.setVisible(true);
    }//GEN-LAST:event_TableSpecializesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CostInput;
    private javax.swing.JButton RefreshButton;
    private javax.swing.JToggleButton RemoveButton;
    private javax.swing.JButton ResetButton;
    private javax.swing.JButton SaveButton;
    private javax.swing.JTextField SpecializeInput;
    private javax.swing.JTable TableSpecializes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
