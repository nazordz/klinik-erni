package com.mycompany.maven.app.view;

import com.mycompany.maven.app.model.Doctor;
import com.mycompany.maven.app.model.Medicine;
import com.mycompany.maven.app.model.Patient;
import com.mycompany.maven.app.model.PatientCheckup;
import com.mycompany.maven.app.model.PatientCheckupMedicine;
import com.mycompany.maven.app.service.DoctorServiceImpl;
import com.mycompany.maven.app.service.MedicineServiceImpl;
import com.mycompany.maven.app.service.PatientCheckupMedicineService;
import com.mycompany.maven.app.service.PatientCheckupServiceImpl;
import com.mycompany.maven.app.service.PatientServiceImpl;
import com.mycompany.maven.app.util.ComboItem;
import com.mycompany.maven.app.util.ListItem;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mac
 */
public class PemeriksaanPanel extends javax.swing.JPanel {

    private final PatientCheckupServiceImpl patientCheckupService;
    private final PatientServiceImpl patientService;
    private final DoctorServiceImpl doctorService;
    private final MedicineServiceImpl medicineService;
    private final PatientCheckupMedicineService patientCheckupMedicineService;
    private String selectedId;
    
    /**
     * Creates new form PemeriksaanPanel
     */
    public PemeriksaanPanel() {
        initComponents();
        this.patientCheckupService = new PatientCheckupServiceImpl();
        this.patientService = new PatientServiceImpl();
        this.doctorService = new DoctorServiceImpl();
        this.medicineService = new MedicineServiceImpl();
        this.patientCheckupMedicineService = new PatientCheckupMedicineService();
        getDataTable();
        getSelectItems();
        TablePatientCheckup.removeColumn(TablePatientCheckup.getColumnModel().getColumn(0));
    }
    
    public void getSelectItems() {
        SelectPatient.removeAllItems();
        SelectDoctor.removeAllItems();
        DefaultListModel<ListItem> medicineModel = new DefaultListModel<>();
        SelectMedicine.setModel(medicineModel);
        for (Patient p: patientService.findAll()) {
            SelectPatient.addItem(new ComboItem(p.getName(), p.getId()));
        }
        for (Doctor d: doctorService.findAll()) {
            SelectDoctor.addItem(new ComboItem(d.getName(), d.getId()));
        }
        Integer i = 0;
        for (Medicine m: medicineService.findAll()) {
            medicineModel.add(i, new ListItem(m.getName(), m.getId()));
            i++;
        }
    }
    
    public void getDataTable() {
        DefaultTableModel tm = (DefaultTableModel) TablePatientCheckup.getModel();
        tm.setRowCount(0);
        List<PatientCheckup> patients = patientCheckupService.findAll();
        for (PatientCheckup patient : patients) {
            List<String> nameOfMedicines = patient.getPatientCheckupMedicines().stream().map((x) -> {
                return x.getMedicine().getName();
            }).collect(Collectors.toList());
            Object[] newRow = {
                patient.getId(),
                patient.getCreatedAt(),
                patient.getPatient().getName(),
                patient.getDoctor().getName(),
                patient.getPainComplaint(),
                patient.getDiagnose(),
                String.format("%.2f", patient.getCost()),
                String.join(", ", nameOfMedicines),
            };
            tm.addRow(newRow);
        }
    }
    
    public void resetForm() {
        SelectDoctor.setSelectedIndex(0);
        SelectMedicine.setSelectedIndex(0);
        SelectPatient.setSelectedIndex(0);
        PainComplaintInput.setText(null);
        DiagnoseInput.setText(null);
        PriceInput.setText(null);
        SelectMedicine.clearSelection();
        this.selectedId = null;
        getSelectItems();
        getDataTable();
    }
    
    public void store() {
        ComboItem patientItem = (ComboItem) SelectPatient.getSelectedItem();
        ComboItem doctorItem = (ComboItem) SelectDoctor.getSelectedItem();
        
        PatientCheckup pc = new PatientCheckup();
        pc.setPatientId(patientItem.getValue());
        pc.setPainComplaint(PainComplaintInput.getText());
        pc.setDoctorId(doctorItem.getValue());
        pc.setDiagnose(DiagnoseInput.getText());
        pc.setCost(Double.parseDouble(PriceInput.getText()));
        List<ListItem> items = SelectMedicine.getSelectedValuesList();
        this.selectedId = patientCheckupService.insertGetId(pc);
        
        items.stream().forEach((ListItem item) -> {
            PatientCheckupMedicine md = new PatientCheckupMedicine();
            md.setMedicineId(item.getValue());
            md.setPatientCheckupId(selectedId);
            patientCheckupMedicineService.insert(md);
        });
        
        resetForm();
    }
    
    public void update() {
        ComboItem patientItem = (ComboItem) SelectPatient.getSelectedItem();
        ComboItem doctorItem = (ComboItem) SelectDoctor.getSelectedItem();
        
        PatientCheckup pc = new PatientCheckup();
        pc.setId(selectedId);
        pc.setPatientId(patientItem.getValue());
        pc.setPainComplaint(PainComplaintInput.getText());
        pc.setDoctorId(doctorItem.getValue());
        pc.setDiagnose(DiagnoseInput.getText());
        pc.setCost(Double.parseDouble(PriceInput.getText()));
        List<ListItem> items = SelectMedicine.getSelectedValuesList();
        
        patientCheckupService.update(pc);
        
        patientCheckupMedicineService.deleteByPatientCheckupId(selectedId);
        
        items.stream().forEach((ListItem item) -> {
            PatientCheckupMedicine md = new PatientCheckupMedicine();
            md.setMedicineId(item.getValue());
            md.setPatientCheckupId(selectedId);
            patientCheckupMedicineService.insert(md);
        });
        
        resetForm();
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
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        SelectPatient = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        PainComplaintInput = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        SelectDoctor = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        DiagnoseInput = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        PriceInput = new javax.swing.JTextField();
        BtnSave = new javax.swing.JButton();
        BtnDelete = new javax.swing.JButton();
        BtnReset = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        SelectMedicine = new javax.swing.JList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablePatientCheckup = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 18, 12));

        jLabel1.setText("Hasil Pemeriksaan");
        jPanel2.add(jLabel1);

        add(jPanel2, java.awt.BorderLayout.NORTH);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel3.setText("Pasien");

        jLabel4.setText("Keluhan Sakit");

        PainComplaintInput.setColumns(10);
        PainComplaintInput.setRows(2);
        PainComplaintInput.setTabSize(3);
        jScrollPane2.setViewportView(PainComplaintInput);

        jLabel5.setText("Pemeriksa");

        jLabel6.setText("Diagnosa");

        DiagnoseInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DiagnoseInputActionPerformed(evt);
            }
        });

        jLabel2.setText("Obat");

        jLabel7.setText("Biaya");

        BtnSave.setText("Simpan");
        BtnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSaveActionPerformed(evt);
            }
        });

        BtnDelete.setText("Hapus");
        BtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDeleteActionPerformed(evt);
            }
        });

        BtnReset.setText("Reset");
        BtnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnResetActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(SelectMedicine);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2)
                            .addComponent(SelectPatient, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SelectDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(BtnSave)
                        .addGap(26, 26, 26)
                        .addComponent(BtnDelete)
                        .addGap(18, 18, 18)
                        .addComponent(BtnReset)))
                .addGap(46, 46, 46)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PriceInput)
                            .addComponent(DiagnoseInput))
                        .addGap(22, 22, 22))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                        .addGap(90, 90, 90))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(SelectPatient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SelectDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnSave)
                            .addComponent(BtnDelete)
                            .addComponent(BtnReset)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(24, 24, 24)
                                .addComponent(jLabel4))
                            .addComponent(jLabel6)
                            .addComponent(DiagnoseInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(PriceInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabel2))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5, java.awt.BorderLayout.PAGE_START);

        TablePatientCheckup.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "Waktu Pemeriksaan", "Pasien", "Pemeriksa", "Keluhan Sakit", "Diagnosa", "Biaya", "Obat"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablePatientCheckup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablePatientCheckupMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablePatientCheckup);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void DiagnoseInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DiagnoseInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DiagnoseInputActionPerformed

    private void BtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSaveActionPerformed
        // TODO add your handling code here:
        if (selectedId == null) {
            store();
        } else {
            update();
        }
    }//GEN-LAST:event_BtnSaveActionPerformed

    
    private void BtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeleteActionPerformed
        // TODO add your handling code here:
        if (!selectedId.isEmpty()) {
            int ok = JOptionPane.showConfirmDialog(null, "Data Akan dihapus ?","Konfirmasi Dialog", JOptionPane.YES_NO_OPTION);
            if (ok == 0) {
                patientCheckupService.delete(selectedId);
                resetForm();
                getDataTable();
                JOptionPane.showMessageDialog(null, "data berhasil dihapus");
            }    
        }
    }//GEN-LAST:event_BtnDeleteActionPerformed

    private void BtnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnResetActionPerformed
        // TODO add your handling code here:
        resetForm();
    }//GEN-LAST:event_BtnResetActionPerformed

    private void TablePatientCheckupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablePatientCheckupMouseClicked
        // TODO add your handling code here:
        Object id = TablePatientCheckup.getModel().getValueAt(TablePatientCheckup.getSelectedRow(), 0);
        this.selectedId = id.toString();
        PatientCheckup pc = patientCheckupService.findById(this.selectedId);
        SelectPatient.getModel().setSelectedItem(new ComboItem(pc.getPatient().getName(), pc.getPatientId()));
        PainComplaintInput.setText(pc.getPainComplaint());
        SelectDoctor.getModel().setSelectedItem(new ComboItem(pc.getDoctor().getName(), pc.getDoctorId()));
        DiagnoseInput.setText(pc.getDiagnose());
        PriceInput.setText(String.format("%.2f", pc.getCost()));
        
        pc.getPatientCheckupMedicines().forEach(med -> {
            SelectMedicine.setSelectedValue(new ListItem(med.getMedicine().getName(), med.getMedicineId()), true);
        });
    }//GEN-LAST:event_TablePatientCheckupMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnDelete;
    private javax.swing.JButton BtnReset;
    private javax.swing.JButton BtnSave;
    private javax.swing.JTextField DiagnoseInput;
    private javax.swing.JTextArea PainComplaintInput;
    private javax.swing.JTextField PriceInput;
    private javax.swing.JComboBox<ComboItem> SelectDoctor;
    private javax.swing.JList<ListItem> SelectMedicine;
    private javax.swing.JComboBox<ComboItem> SelectPatient;
    private javax.swing.JTable TablePatientCheckup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
