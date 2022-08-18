package com.mycompany.maven.app.view;

import com.mycompany.maven.app.enumeration.CheckupStatus;
import com.mycompany.maven.app.enumeration.Role;
import com.mycompany.maven.app.model.Doctor;
import com.mycompany.maven.app.model.Laboratorium;
import com.mycompany.maven.app.model.Patient;
import com.mycompany.maven.app.model.PatientCheckup;
import com.mycompany.maven.app.model.SpecializeDoctor;
import com.mycompany.maven.app.service.DoctorServiceImpl;
import com.mycompany.maven.app.service.LaboratoriumServiceImpl;
import com.mycompany.maven.app.service.MedicineServiceImpl;
import com.mycompany.maven.app.service.PatientCheckupMedicineService;
import com.mycompany.maven.app.service.PatientCheckupServiceImpl;
import com.mycompany.maven.app.service.PatientServiceImpl;
import com.mycompany.maven.app.service.SpecializeDoctorServiceImpl;
import com.mycompany.maven.app.util.ComboItem;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import lombok.Getter;
import lombok.Setter;

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
    private final SpecializeDoctorServiceImpl specializeDoctorServiceImpl = new SpecializeDoctorServiceImpl();
    private final LaboratoriumServiceImpl labService = new LaboratoriumServiceImpl();
    private final MainFrame mainFrame;
    @Setter @Getter
    protected String selectedId;
    
    /**
     * Creates new form PemeriksaanPanel
     */
    public PemeriksaanPanel(
        MainFrame mainFrame,
        PatientCheckupServiceImpl patientCheckupService,
        PatientServiceImpl patientService,
        DoctorServiceImpl doctorService,
        MedicineServiceImpl medicineService,
        PatientCheckupMedicineService patientCheckupMedicineService
    ) {
        initComponents();
        this.patientCheckupService = patientCheckupService;
        this.patientService = patientService;
        this.doctorService = doctorService;
        this.medicineService = medicineService;
        this.patientCheckupMedicineService = patientCheckupMedicineService;
        this.mainFrame = mainFrame;
        TablePatientCheckup.removeColumn(TablePatientCheckup.getColumnModel().getColumn(0));
        BtnDetail.setVisible(false);
        BtnDelete.setVisible(false);
        getDataTable();
        getSelectItems();
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent evt) {
                System.out.println("pemeriksaan shown");
                getDataTable();
                getSelectItems();
            }
        });
       
    }
    
    public void getSelectItems() {
        SelectPatient.removeAllItems();
        SelectSpecialization.removeAllItems();
        for (Patient p: patientService.findAll()) {
            SelectPatient.addItem(new ComboItem(p.getName(), p.getId()));
        }
        for (SpecializeDoctor sd : specializeDoctorServiceImpl.findAll()) {
            SelectSpecialization.addItem(new ComboItem(sd.getName(), sd.getId()));
        }
    }
    
    public void getDataTable() {
        DefaultTableModel tm = (DefaultTableModel) TablePatientCheckup.getModel();
        tm.setRowCount(0);
        List<PatientCheckup> checkups = null;
        if (mainFrame.getAuthentication().getRole() == Role.ROLE_DOCTOR) {
            Doctor loggedDoctor = doctorService.findById(mainFrame.getAuthentication().getId());
            checkups = patientCheckupService.findBySpecializeDoctorId(loggedDoctor.getSpecializeDoctorId());
        } else if(mainFrame.getAuthentication().getRole() == Role.ROLE_LAB) {
            Laboratorium lab = labService.findById(mainFrame.getAuthentication().getId());
            checkups = patientCheckupService.findByLaboratoriumDivisionId(lab.getDivisionId());
        } else if(mainFrame.getAuthentication().getRole() == Role.ROLE_PHARMACIST) {
            checkups = patientCheckupService.findByCheckupStatus(CheckupStatus.LAB_CHECK);
        } else {
            checkups = patientCheckupService.findAll();
        }
        
        if (checkups != null) {
            for (PatientCheckup checkup : checkups) {
                Object[] row = {
                    checkup.getId(),
                    checkup.getSpecializeDoctor().getName(),
                    checkup.getCheckupNumber(),
                    checkup.getPatient().getPatientNumber(),
                    checkup.getPatient().getName(),
                    checkup.getCheckupDate()
                };
                tm.addRow(row);
            }
        }
        
    }
    
    public void resetForm() {
        SelectPatient.setSelectedIndex(0);
        CheckupDatePicker.setDate(null);
        SelectSpecialization.setSelectedIndex(0);
        
        BtnDetail.setVisible(false);
        this.selectedId = null;
        getSelectItems();
        getDataTable();
    }
    
    public void store() {
        ComboItem patientItem = (ComboItem) SelectPatient.getSelectedItem();
        ComboItem specializeItem = (ComboItem) SelectSpecialization.getSelectedItem();
   
        PatientCheckup pc = new PatientCheckup();
        pc.setPatientId(patientItem.getValue());
        pc.setSpecializeDoctorId(specializeItem.getValue());
        pc.setCheckupStatus(CheckupStatus.OPEN);
        pc.setCheckupDate(CheckupDatePicker.getDate());
        
        this.selectedId = patientCheckupService.insertGetId(pc);
        
        resetForm();
    }
    
    public void update() {
        ComboItem patientItem = (ComboItem) SelectPatient.getSelectedItem();
        ComboItem specializeItem = (ComboItem) SelectSpecialization.getSelectedItem();

        PatientCheckup pc = new PatientCheckup();
        pc.setId(selectedId);
        pc.setPatientId(patientItem.getValue());
        pc.setSpecializeDoctorId(specializeItem.getValue());

        patientCheckupService.update(pc);
        
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
        BtnSave = new javax.swing.JButton();
        BtnDelete = new javax.swing.JButton();
        BtnReset = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        CheckupDatePicker = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        SelectSpecialization = new javax.swing.JComboBox<>();
        BtnDetail = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablePatientCheckup = new javax.swing.JTable();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 18, 12));

        jLabel1.setText("Pemeriksaan");
        jPanel2.add(jLabel1);

        add(jPanel2, java.awt.BorderLayout.NORTH);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel3.setText("Pasien");

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

        jLabel8.setText("Tanggal Pemeriksaan");

        jLabel9.setText("Spesialisasi");

        BtnDetail.setText("Rincian");
        BtnDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDetailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(BtnSave)
                        .addGap(18, 18, 18)
                        .addComponent(BtnDelete)
                        .addGap(18, 18, 18)
                        .addComponent(BtnReset)
                        .addGap(18, 18, 18)
                        .addComponent(BtnDetail))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SelectPatient, 0, 147, Short.MAX_VALUE)
                            .addComponent(CheckupDatePicker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SelectSpecialization, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(224, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(SelectPatient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(CheckupDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(SelectSpecialization, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnSave)
                    .addComponent(BtnDelete)
                    .addComponent(BtnReset)
                    .addComponent(BtnDetail))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5, java.awt.BorderLayout.PAGE_START);

        TablePatientCheckup.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "id", "Dokter Spesialis", "No Pemeriksaan", "No Pasien", "Pasien", "Waktu Pemeriksaan"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
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

    
    private void TablePatientCheckupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablePatientCheckupMouseClicked
        // TODO add your handling code here:
        Object id = TablePatientCheckup.getModel().getValueAt(TablePatientCheckup.getSelectedRow(), 0);
        setSelectedId(id.toString());
        PatientCheckup pc = patientCheckupService.findById(this.selectedId);
        BtnDetail.setVisible(true);
        BtnDelete.setVisible(true);

        SelectPatient.getModel().setSelectedItem(new ComboItem(pc.getPatient().getName(), pc.getPatientId()));
        CheckupDatePicker.setDate(pc.getCheckupDate());
        SelectSpecialization.getModel().setSelectedItem(
            new ComboItem(pc.getSpecializeDoctor().getName(), pc.getSpecializeDoctorId())
        );
    }//GEN-LAST:event_TablePatientCheckupMouseClicked

    private void BtnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnResetActionPerformed
        // TODO add your handling code here:
        resetForm();
        getDataTable();
    }//GEN-LAST:event_BtnResetActionPerformed

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

    private void BtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSaveActionPerformed
        // TODO add your handling code here:
        if (selectedId == null) {
            store();
        } else {
            update();
        }
    }//GEN-LAST:event_BtnSaveActionPerformed

    private void BtnDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDetailActionPerformed
        // TODO add your handling code here:
        mainFrame.navigate("pemeriksaanDetail");
    }//GEN-LAST:event_BtnDetailActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:

    }//GEN-LAST:event_formComponentShown


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnDelete;
    private javax.swing.JButton BtnDetail;
    private javax.swing.JButton BtnReset;
    private javax.swing.JButton BtnSave;
    private com.toedter.calendar.JDateChooser CheckupDatePicker;
    private javax.swing.JComboBox<ComboItem> SelectPatient;
    private javax.swing.JComboBox<ComboItem> SelectSpecialization;
    private javax.swing.JTable TablePatientCheckup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
