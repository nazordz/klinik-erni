/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven.app.view;

import com.mycompany.maven.app.enumeration.CheckupStatus;
import com.mycompany.maven.app.enumeration.Role;
import com.mycompany.maven.app.model.Authentication;
import com.mycompany.maven.app.model.Doctor;
import com.mycompany.maven.app.model.Laboratorium;
import com.mycompany.maven.app.model.LaboratoriumDivision;
import com.mycompany.maven.app.model.Medicine;
import com.mycompany.maven.app.model.PatientCheckup;
import com.mycompany.maven.app.model.PatientCheckupDoctor;
import com.mycompany.maven.app.model.PatientCheckupLab;
import com.mycompany.maven.app.model.PatientCheckupMedicine;
import com.mycompany.maven.app.service.CheckupDoctorServiceImpl;
import com.mycompany.maven.app.service.CheckupLabServiceImpl;
import com.mycompany.maven.app.service.DoctorServiceImpl;
import com.mycompany.maven.app.service.LabDivisionServiceImpl;
import com.mycompany.maven.app.service.LaboratoriumServiceImpl;
import com.mycompany.maven.app.service.MedicineServiceImpl;
import com.mycompany.maven.app.service.PatientCheckupMedicineService;
import com.mycompany.maven.app.service.PatientCheckupServiceImpl;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import com.mycompany.maven.app.util.ComboItem;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.persistence.EntityExistsException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author mac
 */
public class PasienCheckupDetailPanel extends javax.swing.JPanel {
    static final Logger logger = Logger.getLogger(PasienCheckupDetailPanel.class.getName());
    private final PemeriksaanPanel pemeriksaanPanel;
    private final MainFrame mainFrame;
    private PatientCheckup checkup;
    private final PatientCheckupServiceImpl checkupService = new PatientCheckupServiceImpl();
    private final CheckupDoctorServiceImpl checkupDoctorService = new CheckupDoctorServiceImpl();
    private final CheckupLabServiceImpl checkupLabService = new CheckupLabServiceImpl();
    private final LaboratoriumServiceImpl laboratoriumService = new LaboratoriumServiceImpl();
    private final LabDivisionServiceImpl labDivisionService = new LabDivisionServiceImpl();
    private final DoctorServiceImpl doctorService = new DoctorServiceImpl();
    private final MedicineServiceImpl medicineService = new MedicineServiceImpl();
    private final PatientCheckupMedicineService checkupMedicineService = new PatientCheckupMedicineService();
    private final Authentication authentication;
    public final Locale locale = new Locale("id", "ID");
    public final NumberFormat nf; 
    public final DateFormat dateFormat;
    
    private String checkupMedicineId;
    
    /**
     * Creates new form PasienCheckup
     */
    public PasienCheckupDetailPanel(
            MainFrame frame,
            PemeriksaanPanel pp,
            Authentication authentication
    ) {
        initComponents();
        this.nf = NumberFormat.getInstance(locale);
        this.dateFormat = DateFormat.getTimeInstance(DateFormat.DEFAULT, locale);
        this.mainFrame = frame;
        this.pemeriksaanPanel = pp;
        this.authentication = authentication;
        
        MedicineDialog.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent evt) {
                getMedicines();
                getSelectedMedicines();
            }
        });
        
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentHidden(ComponentEvent evt) {
                CheckupDocterArea.setEditable(false);
                CheckupLabArea.setEditable(false);
                BtnAddMedicine.setVisible(false);
                SelectLabDivision.setEditable(false);
                SelectLabDivision.removeAllItems();

            }
            @Override
            public void componentShown(ComponentEvent evt) {
                getCheckupDetail();
                getLabDivisions();
                if (authentication.getRole() == Role.ROLE_DOCTOR) {
                    getDoctors();
                    CheckupDocterArea.setEditable(true);
                    SelectLabDivision.setEditable(true);
                }
                
                if (authentication.getRole() == Role.ROLE_LAB) {
                    CheckupLabArea.setEditable(true);
                }
                
                if (authentication.getRole() == Role.ROLE_PHARMACIST) {
                    BtnAddMedicine.setVisible(true);
                }
                
                if (authentication.getRole() == Role.ROLE_ADMIN) {
                    SaveButton.setEnabled(false);
                    getDoctors();
                    getLabDivisions();
                    CheckupDocterArea.setEditable(true);
                    CheckupLabArea.setEditable(true);
                    BtnAddMedicine.setVisible(true);
                }
                
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MedicineDialog = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        SelectMedicine = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        QtyInput = new javax.swing.JTextField();
        BtnAddMedicine = new javax.swing.JButton();
        BtnDeleteMedicine = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        MedicineTable = new javax.swing.JTable();
        Header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        NoPatientLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Body = new javax.swing.JPanel();
        Form = new javax.swing.JPanel();
        Group = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        DoctorLabel = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        PatientLabel = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        BornLabel = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        BloodLabel = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        GenderLabel = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        CheckupDocterArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        AddressArea = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        SpecializationLabel = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        LabNameLabel = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        CheckupLabArea = new javax.swing.JTextArea();
        jLabel24 = new javax.swing.JLabel();
        ApotekerLabel = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        BtnListMedicine = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        CostLabel = new javax.swing.JLabel();
        SelectLabDivision = new javax.swing.JComboBox<>();
        BtnCalcCost = new javax.swing.JButton();
        Action = new javax.swing.JPanel();
        ResetForm = new javax.swing.JButton();
        SaveButton = new javax.swing.JButton();

        MedicineDialog.setSize(new java.awt.Dimension(600, 300));
        MedicineDialog.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                MedicineDialogComponentShown(evt);
            }
        });

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING));

        jLabel26.setText("Obat:");
        jPanel1.add(jLabel26);

        SelectMedicine.setPreferredSize(new java.awt.Dimension(120, 23));
        SelectMedicine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectMedicineActionPerformed(evt);
            }
        });
        jPanel1.add(SelectMedicine);

        jLabel3.setText("Qty: ");
        jPanel1.add(jLabel3);

        QtyInput.setPreferredSize(new java.awt.Dimension(120, 23));
        jPanel1.add(QtyInput);

        BtnAddMedicine.setText("Tambah");
        BtnAddMedicine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAddMedicineActionPerformed(evt);
            }
        });
        jPanel1.add(BtnAddMedicine);

        BtnDeleteMedicine.setText("Hapus");
        BtnDeleteMedicine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDeleteMedicineActionPerformed(evt);
            }
        });
        jPanel1.add(BtnDeleteMedicine);
        BtnAddMedicine.setVisible(false);

        MedicineDialog.getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        MedicineTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id", "Nama Obat", "Qty", "Harga Satuan"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        MedicineTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MedicineTableMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(MedicineTable);
        MedicineTable.removeColumn(MedicineTable.getColumnModel().getColumn(0));

        MedicineDialog.getContentPane().add(jScrollPane5, java.awt.BorderLayout.CENTER);

        setLayout(new java.awt.BorderLayout());

        Header.setPreferredSize(new java.awt.Dimension(602, 60));
        Header.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel1.setText("Pemeriksaan");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        Header.add(jLabel1);

        jLabel2.setText("/");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        Header.add(jLabel2);

        NoPatientLabel.setText("noPasien");
        NoPatientLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NoPatientLabelMouseClicked(evt);
            }
        });
        Header.add(NoPatientLabel);

        jLabel7.setText("/");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        Header.add(jLabel7);

        jLabel4.setText("Riwayat");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        Header.add(jLabel4);

        add(Header, java.awt.BorderLayout.NORTH);

        Body.setLayout(new java.awt.BorderLayout());

        Form.setLayout(new java.awt.BorderLayout());

        jLabel5.setText("<html>\nHasil<br />Pemeriksaan<br />Dokter\n</html>");

        jLabel6.setText("Dokter");

        DoctorLabel.setText("-");

        jLabel8.setText("Pasien");

        PatientLabel.setText("-");

        jLabel10.setText("Tgl Lahir");

        BornLabel.setText("-");

        jLabel12.setText("Gol Darah");

        BloodLabel.setText("-");

        jLabel14.setText("JenKel");

        GenderLabel.setText("-");

        jLabel16.setText("Alamat");

        CheckupDocterArea.setEditable(false);
        CheckupDocterArea.setColumns(20);
        CheckupDocterArea.setRows(5);
        jScrollPane1.setViewportView(CheckupDocterArea);

        AddressArea.setEditable(false);
        AddressArea.setColumns(20);
        AddressArea.setRows(5);
        jScrollPane2.setViewportView(AddressArea);

        jLabel17.setText("Spesialisasi");

        SpecializationLabel.setText("-");

        jLabel19.setText("Bagian Lab");

        jLabel21.setText("Pemeriksa");

        LabNameLabel.setText("-");

        jLabel23.setText("<html> Hasil<br />Pemeriksaan<br />Lab </html>");

        CheckupLabArea.setEditable(false);
        CheckupLabArea.setColumns(20);
        CheckupLabArea.setRows(5);
        jScrollPane3.setViewportView(CheckupLabArea);

        jLabel24.setText("Obat");

        ApotekerLabel.setText("-");

        jLabel30.setText("<html>\nPemberi<br />Obat\n</html>");

        BtnListMedicine.setText("Daftar Obat");
        BtnListMedicine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnListMedicineActionPerformed(evt);
            }
        });

        jLabel27.setText("Total Biaya");

        CostLabel.setText("-");

        BtnCalcCost.setText("Hitung Biaya");
        BtnCalcCost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCalcCostActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout GroupLayout = new javax.swing.GroupLayout(Group);
        Group.setLayout(GroupLayout);
        GroupLayout.setHorizontalGroup(
            GroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(GroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(GroupLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(SpecializationLabel))
                    .addGroup(GroupLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(GroupLayout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(DoctorLabel))
                    .addGroup(GroupLayout.createSequentialGroup()
                        .addGroup(GroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12)
                            .addComponent(jLabel8)
                            .addComponent(jLabel14))
                        .addGap(31, 31, 31)
                        .addGroup(GroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PatientLabel)
                            .addComponent(BornLabel)
                            .addComponent(BloodLabel)
                            .addComponent(GenderLabel)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(53, 53, 53)
                .addGroup(GroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(GroupLayout.createSequentialGroup()
                            .addComponent(jLabel19)
                            .addGap(23, 23, 23)
                            .addGroup(GroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(LabNameLabel)
                                .addComponent(SelectLabDivision, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jLabel21)
                        .addGroup(GroupLayout.createSequentialGroup()
                            .addGroup(GroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(GroupLayout.createSequentialGroup()
                                    .addGroup(GroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel27))
                                    .addGap(10, 10, 10))
                                .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(GroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(GroupLayout.createSequentialGroup()
                                    .addGap(14, 14, 14)
                                    .addGroup(GroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(ApotekerLabel)
                                        .addComponent(CostLabel)
                                        .addComponent(BtnCalcCost)))
                                .addGroup(GroupLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(GroupLayout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addGap(60, 60, 60)
                        .addComponent(BtnListMedicine)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        GroupLayout.setVerticalGroup(
            GroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GroupLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(GroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.createSequentialGroup()
                        .addGroup(GroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(GroupLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14))
                            .addGroup(GroupLayout.createSequentialGroup()
                                .addComponent(PatientLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BornLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BloodLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(GenderLabel)))
                        .addGap(18, 18, 18)
                        .addGroup(GroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(GroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SpecializationLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel17)))
                    .addGroup(GroupLayout.createSequentialGroup()
                        .addGroup(GroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(SelectLabDivision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(GroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabNameLabel)
                            .addComponent(jLabel21))
                        .addGroup(GroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(GroupLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(GroupLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(GroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ApotekerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(GroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(BtnListMedicine))))
                .addGroup(GroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(GroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DoctorLabel)
                            .addComponent(jLabel6)))
                    .addGroup(GroupLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(GroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(CostLabel))))
                .addGroup(GroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(GroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(GroupLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(BtnCalcCost)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Form.add(Group, java.awt.BorderLayout.CENTER);

        Action.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 5, 10));

        ResetForm.setText("Batal");
        ResetForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetFormActionPerformed(evt);
            }
        });
        Action.add(ResetForm);

        SaveButton.setText("Simpan");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });
        Action.add(SaveButton);

        Form.add(Action, java.awt.BorderLayout.SOUTH);

        Body.add(Form, java.awt.BorderLayout.PAGE_START);

        add(Body, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    public void getMedicines() {
        SelectMedicine.removeAllItems();
        List<Medicine> medicines = medicineService.findAll();
        for (Medicine medicine : medicines) {
            SelectMedicine.addItem(
                    new ComboItem(medicine.getName(), medicine.getId())
            );
        }
    }
    
    public void getSelectedMedicines() {
        List<PatientCheckupMedicine> meds = checkupMedicineService.findByPatientCheckupId(pemeriksaanPanel.getSelectedId());
        DefaultTableModel tb = (DefaultTableModel) MedicineTable.getModel();
        tb.setRowCount(0);
        for (PatientCheckupMedicine med : meds) {
            Object[] row = {
                med.getId(),
                med.getMedicine().getName(),
                med.getQuantity(),
                med.getMedicine().getPrice()
            };
            tb.addRow(row);
        }
    }
    
    public void getCheckupDetail() {
        this.checkup = checkupService.findById(pemeriksaanPanel.getSelectedId());
        NoPatientLabel.setText(checkup.getCheckupNumber().toString());
        PatientLabel.setText(checkup.getPatient().getName());
        BornLabel.setText(dateFormat.format(checkup.getPatient().getBirthDate()));
        BloodLabel.setText(checkup.getPatient().getBloodType());
        GenderLabel.setText(checkup.getPatient().getGender());
        AddressArea.setText(checkup.getPatient().getAddress());
        
        if (checkup.getPatientCheckupDoctor() != null) {
            SpecializationLabel.setText(checkup.getPatientCheckupDoctor().getDoctor().getSpecialize().getName());
            DoctorLabel.setText(checkup.getPatientCheckupDoctor().getDoctor().getName());
            CheckupDocterArea.setText(checkup.getPatientCheckupDoctor().getNote());
        }
        
        if (checkup.getPatientCheckupLab() != null) {    
            LabNameLabel.setText(checkup.getPatientCheckupLab().getLaboratorium().getName());
            CheckupLabArea.setText(checkup.getPatientCheckupLab().getResultLabCheckup());
        }
        if (checkup.getLaboratoriumDivision() != null) {
            SelectLabDivision.getModel().setSelectedItem(
               new ComboItem(
                   checkup.getLaboratoriumDivision().getName(),
                   checkup.getLaboratoriumDivision().getId()
               )
           );   
        }
        if (checkup.getPatientCheckupLab() == null && mainFrame.getAuthentication().getRole() == Role.ROLE_LAB) {
            LabNameLabel.setText(mainFrame.getAuthentication().getName());
        }
         
        if (checkup.getPharmacist() != null) {
            ApotekerLabel.setText(checkup.getPharmacist().getName());
        } 
        if (mainFrame.getAuthentication().getRole() == Role.ROLE_PHARMACIST && checkup.getPharmacist() == null) {
            ApotekerLabel.setText(mainFrame.getAuthentication().getName());
        }
        
        CostLabel.setText("Rp" + nf.format(checkup.getCost()));
    }
    
    public void getDoctors() {
        if (checkup.getPatientCheckupDoctor() == null) {
            Doctor doctor = doctorService.findById(authentication.getId());
            SpecializationLabel.setText(doctor.getSpecialize().getName());
            DoctorLabel.setText(doctor.getName());
        }
        
    }
    
    public void getLabDivisions() {
        List<LaboratoriumDivision> divisions = labDivisionService.findAll();
        for (LaboratoriumDivision division : divisions) {
            SelectLabDivision.addItem(
                new ComboItem(
                    division.getName(),
                    division.getId()
                )
            );
        }
        
        if (checkup.getPatientCheckupLab() == null) {
            if (authentication.getRole() == Role.ROLE_LAB) {
                Laboratorium lab = laboratoriumService.findById(authentication.getId());
                LabNameLabel.setText(authentication.getName());
                SelectLabDivision.getModel().setSelectedItem(
                    new ComboItem(
                        lab.getDivision().getName(),
                        lab.getDivision().getId()
                    )
                );    
            }
        }
    }
    
    public void resetForm() {
        QtyInput.setText(null);
        BtnDeleteMedicine.setVisible(false);
        this.checkupMedicineId = null;
    }
    
    public Double getTotalCost() {
        try {
            PatientCheckup pc = checkupService.findById(pemeriksaanPanel.getSelectedId());
            Double doctorCost = pc.getSpecializeDoctor()
                            .getCheckupFee();
            Double labCost = pc.getLaboratoriumDivision()
                                .getCost();
            Double medCost = pc.getPatientCheckupMedicines().stream()
                            .map(pcm -> pcm.getMedicine().getPrice() * pcm.getQuantity() )
                            .collect(Collectors.summingDouble(Double::doubleValue));
            
            return doctorCost + labCost + medCost;
        } catch(NullPointerException e ) {}
        catch (Exception e) {
            System.out.println("error calculate cost: " + e.getMessage());
        }
        return 0.00;
    }
    
    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        // TODO add your handling code here:
        try {
            if (authentication.getRole() == Role.ROLE_DOCTOR) {
                PatientCheckupDoctor patientCheckupDoctor = new PatientCheckupDoctor();
                patientCheckupDoctor.setNote(CheckupDocterArea.getText());
                patientCheckupDoctor.setDoctorId(authentication.getId());
                patientCheckupDoctor.setPatientCheckupId(pemeriksaanPanel.getSelectedId());
                if (checkup.getPatientCheckupDoctor() != null) {
                    checkupDoctorService.delete(checkup.getPatientCheckupDoctor().getId());
                }
                checkup.setCheckupStatus(CheckupStatus.DOCTOR_CHECK);
                checkup.setPatientCheckupDoctor(patientCheckupDoctor);
                ComboItem selectedDiv = (ComboItem) SelectLabDivision.getSelectedItem();
                checkup.setLaboratoriumDivisionId(selectedDiv.getValue());
            }

            if (authentication.getRole() == Role.ROLE_LAB) {
                PatientCheckupLab checkupLab = new PatientCheckupLab();
                checkupLab.setPatientCheckupId(checkup.getId());
                checkupLab.setLaboratoriumId(authentication.getId());
                checkupLab.setResultLabCheckup(CheckupLabArea.getText());
                checkup.setCheckupStatus(CheckupStatus.LAB_CHECK);
                if (checkup.getPatientCheckupLab() != null) {
                    checkupLab.setId(checkup.getPatientCheckupLab().getId());
                    checkupLabService.update(checkupLab);
                } else {
                    checkupLabService.insert(checkupLab);
                }
            }
            
            if (authentication.getRole() == Role.ROLE_PHARMACIST) {
                checkup.setPharmacistId(authentication.getId());
                checkup.setCheckupStatus(CheckupStatus.GET_MEDICINE);
                checkup.setCost(getTotalCost());
            }
            checkupService.directUpdate(checkup);
        } catch (Exception e) {
            System.out.print("Error: " + e.getMessage());
            
            e.printStackTrace();
        }
        
        resetForm();
        JOptionPane.showMessageDialog(this, "Berhasil disimpan!");
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        mainFrame.navigate("hasilPemeriksaan");
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseClicked

    private void ResetFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetFormActionPerformed
        // TODO add your handling code here:
        resetForm();
        mainFrame.navigate("hasilPemeriksaan");
    }//GEN-LAST:event_ResetFormActionPerformed

    private void BtnListMedicineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnListMedicineActionPerformed
        // TODO add your handling code here:
        MedicineDialog.setVisible(true);
    }//GEN-LAST:event_BtnListMedicineActionPerformed

    private void SelectMedicineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectMedicineActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_SelectMedicineActionPerformed

    private void NoPatientLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NoPatientLabelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_NoPatientLabelMouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel7MouseClicked

    private void MedicineDialogComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_MedicineDialogComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_MedicineDialogComponentShown

    private void BtnAddMedicineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAddMedicineActionPerformed
        // TODO add your handling code here:
        PatientCheckupMedicine checkupMed = new PatientCheckupMedicine();
        ComboItem medicine = (ComboItem) SelectMedicine.getSelectedItem();
        checkupMed.setMedicineId(medicine.getValue());
        checkupMed.setQuantity(Integer.parseInt(QtyInput.getText()));
        checkupMed.setPatientCheckupId(pemeriksaanPanel.getSelectedId());
        if (checkupMedicineId != null) {
            checkupMed.setId(checkupMedicineId);
            checkupMedicineService.update(checkupMed);
        } else {
            checkupMedicineService.insert(checkupMed);
        }
        resetForm();
        getSelectedMedicines();
        JOptionPane.showMessageDialog(null, "Obat berhasil ditambahkan");
    }//GEN-LAST:event_BtnAddMedicineActionPerformed

    private void BtnDeleteMedicineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeleteMedicineActionPerformed
        // TODO add your handling code here:
        String id = (String) MedicineTable.getModel().getValueAt(MedicineTable.getSelectedRow(), 0);
        int ok = JOptionPane.showConfirmDialog(null, "Data Akan dihapus ?","Konfirmasi Dialog", JOptionPane.YES_NO_OPTION);
            if (ok == 0) {
                checkupMedicineService.delete(id);
                resetForm();
                getSelectedMedicines();
                JOptionPane.showMessageDialog(null, "data berhasil dihapus");
            }
    }//GEN-LAST:event_BtnDeleteMedicineActionPerformed

    private void MedicineTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MedicineTableMouseClicked
        // TODO add your handling code here:
        BtnDeleteMedicine.setVisible(true);
        String checkupMedId = (String) MedicineTable.getModel().getValueAt(MedicineTable.getSelectedRow(), 0);
        PatientCheckupMedicine checkupMed = checkupMedicineService.findById(checkupMedId);
        QtyInput.setText(checkupMed.getQuantity().toString());
        SelectMedicine.getModel().setSelectedItem(
            new ComboItem(checkupMed.getMedicine().getName(), checkupMed.getMedicine().getId())
        );
        this.checkupMedicineId = checkupMedId;
    }//GEN-LAST:event_MedicineTableMouseClicked

    private void BtnCalcCostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCalcCostActionPerformed
        // TODO add your handling code here:
        CostLabel.setText("Rp" + nf.format(getTotalCost()));
    }//GEN-LAST:event_BtnCalcCostActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Action;
    private javax.swing.JTextArea AddressArea;
    private javax.swing.JLabel ApotekerLabel;
    private javax.swing.JLabel BloodLabel;
    private javax.swing.JPanel Body;
    private javax.swing.JLabel BornLabel;
    private javax.swing.JButton BtnAddMedicine;
    private javax.swing.JButton BtnCalcCost;
    private javax.swing.JButton BtnDeleteMedicine;
    private javax.swing.JButton BtnListMedicine;
    private javax.swing.JTextArea CheckupDocterArea;
    private javax.swing.JTextArea CheckupLabArea;
    private javax.swing.JLabel CostLabel;
    private javax.swing.JLabel DoctorLabel;
    private javax.swing.JPanel Form;
    private javax.swing.JLabel GenderLabel;
    private javax.swing.JPanel Group;
    private javax.swing.JPanel Header;
    private javax.swing.JLabel LabNameLabel;
    private javax.swing.JDialog MedicineDialog;
    private javax.swing.JTable MedicineTable;
    private javax.swing.JLabel NoPatientLabel;
    private javax.swing.JLabel PatientLabel;
    private javax.swing.JTextField QtyInput;
    private javax.swing.JButton ResetForm;
    private javax.swing.JButton SaveButton;
    private javax.swing.JComboBox<ComboItem> SelectLabDivision;
    private javax.swing.JComboBox<ComboItem> SelectMedicine;
    private javax.swing.JLabel SpecializationLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    // End of variables declaration//GEN-END:variables
}
