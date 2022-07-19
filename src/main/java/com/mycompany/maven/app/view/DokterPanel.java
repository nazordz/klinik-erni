/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven.app.view;

import com.mycompany.maven.app.enumeration.GenderType;
import com.mycompany.maven.app.enumeration.SpecializationType;
import com.mycompany.maven.app.koneksi;
import com.mycompany.maven.app.model.Doctor;
import com.mycompany.maven.app.service.DoctorServiceImpl;
import com.mycompany.maven.app.util.UpdatableBCrypt;
import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.hibernate.HibernateException;
    
/**
 *
 * @author mac
 */
public class DokterPanel extends javax.swing.JPanel {
    private String editedId = "";
    private final DoctorServiceImpl doctorService;
    private static final UpdatableBCrypt bcrypt = new UpdatableBCrypt(12);

    /**
     * Creates new form DokterPanel
     */
    public DokterPanel() {
        initComponents();
        this.doctorService = new DoctorServiceImpl();
        getDataTable();
        PasswordTitle.setVisible(false);
        PasswordInput.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Body = new javax.swing.JPanel();
        Forms = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        StrField = new javax.swing.JTextField();
        NameField = new javax.swing.JTextField();
        BirthDatePicker = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        GenderSelect = new javax.swing.JComboBox<>();
        SpecializationSelect = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        AddressField = new javax.swing.JTextPane();
        PasswordCheck = new javax.swing.JCheckBox();
        PasswordInput = new javax.swing.JPasswordField();
        PasswordTitle = new javax.swing.JLabel();
        Buttons = new javax.swing.JPanel();
        Print = new javax.swing.JButton();
        ResetButton = new javax.swing.JButton();
        RefreshButton = new javax.swing.JButton();
        RemoveButton = new javax.swing.JToggleButton();
        SaveButton = new javax.swing.JButton();
        TableContainer = new javax.swing.JPanel();
        TableScroll = new javax.swing.JScrollPane();
        TableDoctor = new javax.swing.JTable();

        setLayout(new java.awt.GridLayout(2, 0));

        Body.setLayout(new java.awt.BorderLayout());

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("No Str");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Nama ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Tanggal Lahir");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Alamat");

        NameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameFieldActionPerformed(evt);
            }
        });

        BirthDatePicker.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                BirthDatePickerPropertyChange(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Jenis Kelamin");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Spesialis");

        GenderSelect.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        GenderSelect.setModel(new javax.swing.DefaultComboBoxModel<>(GenderType.values()));

        SpecializationSelect.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        SpecializationSelect.setModel(new javax.swing.DefaultComboBoxModel<>(SpecializationType.values()));

        jScrollPane1.setViewportView(AddressField);

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

        javax.swing.GroupLayout FormsLayout = new javax.swing.GroupLayout(Forms);
        Forms.setLayout(FormsLayout);
        FormsLayout.setHorizontalGroup(
            FormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FormsLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(FormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(FormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(StrField)
                    .addComponent(NameField)
                    .addComponent(BirthDatePicker, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(53, 53, 53)
                .addGroup(FormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FormsLayout.createSequentialGroup()
                        .addGroup(FormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(FormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SpecializationSelect, 0, 89, Short.MAX_VALUE)
                            .addComponent(GenderSelect, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(PasswordCheck)
                    .addGroup(FormsLayout.createSequentialGroup()
                        .addComponent(PasswordTitle)
                        .addGap(34, 34, 34)
                        .addComponent(PasswordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        FormsLayout.setVerticalGroup(
            FormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FormsLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(FormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(SpecializationSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(FormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(StrField, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(FormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FormsLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(FormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(GenderSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(NameField, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(FormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FormsLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(FormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(BirthDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(FormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(FormsLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)))
                    .addGroup(FormsLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(PasswordCheck)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(FormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PasswordTitle)
                            .addComponent(PasswordInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        Body.add(Forms, java.awt.BorderLayout.CENTER);

        Buttons.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        Print.setText("Cetak");
        Print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintActionPerformed(evt);
            }
        });
        Buttons.add(Print);

        ResetButton.setText("Reset");
        ResetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetButtonActionPerformed(evt);
            }
        });
        Buttons.add(ResetButton);

        RefreshButton.setText("Refresh");
        RefreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshButtonActionPerformed(evt);
            }
        });
        Buttons.add(RefreshButton);

        RemoveButton.setText("Hapus");
        RemoveButton.setVisible(false);
        RemoveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveButtonActionPerformed(evt);
            }
        });
        Buttons.add(RemoveButton);

        SaveButton.setText("Simpan");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });
        Buttons.add(SaveButton);

        Body.add(Buttons, java.awt.BorderLayout.SOUTH);

        add(Body);

        TableContainer.setLayout(new java.awt.BorderLayout());

        TableDoctor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "STR", "Nama", "Tgl Lahir", "Spesialis", "Jen Kel", "Alamat", "dibuat"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableDoctor.removeColumn(TableDoctor.getColumnModel().getColumn(0));
        TableDoctor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableDoctorMouseClicked(evt);
            }
        });
        TableScroll.setViewportView(TableDoctor);

        TableContainer.add(TableScroll, java.awt.BorderLayout.CENTER);

        add(TableContainer);
    }// </editor-fold>//GEN-END:initComponents

    public void getDataTable() {
        DefaultTableModel tm = (DefaultTableModel) TableDoctor.getModel();
        tm.setRowCount(0);
        try {
            for (Doctor next : this.doctorService.findAll()) {
                Object[] newRow = {
                    next.getId(),
                    next.getStrNumber(),
                    next.getName(),
                    next.getBirthDate(),
                    next.getSpecialization(),
                    next.getGender(),
                    next.getAddress(),
                    next.getCreatedAt()
                };
                tm.addRow(newRow);
            }
        } catch (HibernateException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    private void NameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameFieldActionPerformed

    private void BirthDatePickerPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_BirthDatePickerPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_BirthDatePickerPropertyChange

    public void refreshTable() {
        DefaultTableModel tm = (DefaultTableModel) TableDoctor.getModel();
        getDataTable();
        tm.fireTableDataChanged();
        TableDoctor.repaint();
    }
    
    private void RefreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshButtonActionPerformed
        // TODO add your handling code here:
        refreshTable();
    }//GEN-LAST:event_RefreshButtonActionPerformed

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        // TODO add your handling code here:
        Doctor dokter = new Doctor();
        dokter.setStrNumber(StrField.getText());
        dokter.setName(NameField.getText());
        dokter.setBirthDate(BirthDatePicker.getDate());
        dokter.setAddress(AddressField.getText());
        GenderType selectedType = (GenderType) GenderSelect.getSelectedItem();
        dokter.setGender(selectedType);
        SpecializationType spesType = (SpecializationType) SpecializationSelect.getSelectedItem();
        dokter.setSpecialization(spesType);
        if (PasswordCheck.isSelected()) {
            dokter.setPassword(bcrypt.hash(PasswordInput.getPassword().toString()));
        }
        if (editedId.isEmpty()) {
            doctorService.insert(dokter);    
        } else {
            dokter.setId(editedId);
            doctorService.update(dokter);
        }
        
        refreshTable();
        resetForm();
        JOptionPane.showMessageDialog(this, "Berhasil disimpan!");
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void resetForm() {
        StrField.setText("");
        NameField.setText("");
        BirthDatePicker.setCalendar(null);
        AddressField.setText("");
        GenderSelect.setSelectedIndex(0);
        SpecializationSelect.setSelectedIndex(0);
        this.editedId = "";
        this.RemoveButton.setVisible(false);
    }
    
    private void ResetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetButtonActionPerformed
        // TODO add your handling code here:
        resetForm();
    }//GEN-LAST:event_ResetButtonActionPerformed
    public static java.util.Calendar toCalendar(java.util.Date date){ 
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }
    private void TableDoctorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableDoctorMouseClicked
        // TODO add your handling code here:
        int row = TableDoctor.getSelectedRow();
        this.editedId = TableDoctor.getModel().getValueAt(row, 0).toString();
        StrField.setText(TableDoctor.getModel().getValueAt(row, 1).toString());
        NameField.setText(TableDoctor.getModel().getValueAt(row, 2).toString());
        BirthDatePicker.setDate((java.util.Date) TableDoctor.getModel().getValueAt(row, 3));
        SpecializationSelect.getModel().setSelectedItem((SpecializationType) TableDoctor.getModel().getValueAt(row, 4));
        GenderSelect.getModel().setSelectedItem(TableDoctor.getModel().getValueAt(row, 5));
        AddressField.setText(TableDoctor.getModel().getValueAt(row, 6).toString());
        this.RemoveButton.setVisible(true);
    }//GEN-LAST:event_TableDoctorMouseClicked

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
            doctorService.delete(editedId);
            resetForm();
            refreshTable();
            JOptionPane.showMessageDialog(this, "Berhasil dihapus!");
        }
    }//GEN-LAST:event_RemoveButtonActionPerformed

    private void PrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintActionPerformed
        // TODO add your handling code here:
        String filename = System.getProperty("user.dir") + File.separator + 
                "src" + File.separator + "main" + File.separator + "java" +
                File.separator + "com" + File.separator + "mycompany" + File.separator +
                "maven" + File.separator + "app" + File.separator + "report" + File.separator +
                "report-doctors.jrxml";
        Map<String, Object> kode = new HashMap<String, Object>();
        File report = new File(filename);
        try {
            koneksi conn = new koneksi();
            JasperDesign jasDes = JRXmlLoader.load(report);
            JasperReport jasRep = JasperCompileManager.compileReport(jasDes);
            JasperPrint jasPri = JasperFillManager.fillReport(jasRep, kode, conn.connect());
            JasperViewer.viewReport(jasPri, false);

        } catch (Exception e) {
            System.out.println("err: " + e.getMessage());
        }
    }//GEN-LAST:event_PrintActionPerformed

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

    private void PasswordCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordCheckActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordCheckActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane AddressField;
    private com.toedter.calendar.JDateChooser BirthDatePicker;
    private javax.swing.JPanel Body;
    private javax.swing.JPanel Buttons;
    private javax.swing.JPanel Forms;
    private javax.swing.JComboBox<GenderType> GenderSelect;
    private javax.swing.JTextField NameField;
    private javax.swing.JCheckBox PasswordCheck;
    private javax.swing.JPasswordField PasswordInput;
    private javax.swing.JLabel PasswordTitle;
    private javax.swing.JButton Print;
    private javax.swing.JButton RefreshButton;
    private javax.swing.JToggleButton RemoveButton;
    private javax.swing.JButton ResetButton;
    private javax.swing.JButton SaveButton;
    private javax.swing.JComboBox<SpecializationType> SpecializationSelect;
    private javax.swing.JTextField StrField;
    private javax.swing.JPanel TableContainer;
    private javax.swing.JTable TableDoctor;
    private javax.swing.JScrollPane TableScroll;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
