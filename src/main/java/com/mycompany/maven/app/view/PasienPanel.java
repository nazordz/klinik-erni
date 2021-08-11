/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven.app.view;

import com.mycompany.maven.app.controller.ManagePatient;
import com.mycompany.maven.app.model.Patient;
import java.util.Calendar;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.table.TableColumn;
import com.mycompany.maven.app.util.DateCellRenderer;
/**
 *
 * @author mac
 */
public class PasienPanel extends javax.swing.JPanel {
    
    private ManagePatient controller;
    private String editedId = "";
    private MainFrame MainFrame;
    /**
     * Creates new form PasienPanel
     */
    public PasienPanel(MainFrame frame) {
        initComponents();
        this.MainFrame = frame;
        this.controller = new ManagePatient();
        getDataTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Form = new javax.swing.JPanel();
        InputGroup = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        NoPatientField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        NameField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        DateBirthField = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        BloodTypeField = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        ManRadio = new javax.swing.JRadioButton();
        WomenRadio = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        AddressField = new javax.swing.JTextArea();
        ButtonGroup = new javax.swing.JPanel();
        ResetForm = new javax.swing.JButton();
        Refresh = new javax.swing.JButton();
        Checkup = new javax.swing.JButton();
        Remove = new javax.swing.JButton();
        Add = new javax.swing.JButton();
        TableWrapper = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablePasien = new javax.swing.JTable();

        setBackground(new java.awt.Color(223, 230, 233));
        setPreferredSize(new java.awt.Dimension(452, 735));
        setLayout(new java.awt.BorderLayout());

        Form.setPreferredSize(new java.awt.Dimension(355, 233));
        Form.setLayout(new java.awt.BorderLayout());

        InputGroup.setPreferredSize(new java.awt.Dimension(331, 190));

        jLabel1.setText("No. Pasien");

        NoPatientField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoPatientFieldActionPerformed(evt);
            }
        });

        jLabel2.setText("Nama");

        NameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameFieldActionPerformed(evt);
            }
        });

        jLabel3.setText("Tgl Lahir");

        DateBirthField.setDateFormatString("dd-MM-YYYY");

        jLabel4.setText("Gol Darah");

        BloodTypeField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "AB", "O" }));

        jLabel5.setText("Jenis Kel");

        ManRadio.setText("Pria");

        WomenRadio.setText("Wanita");
        WomenRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WomenRadioActionPerformed(evt);
            }
        });

        jLabel6.setText("Alamat");

        AddressField.setColumns(20);
        AddressField.setRows(5);
        jScrollPane2.setViewportView(AddressField);

        javax.swing.GroupLayout InputGroupLayout = new javax.swing.GroupLayout(InputGroup);
        InputGroup.setLayout(InputGroupLayout);
        InputGroupLayout.setHorizontalGroup(
            InputGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InputGroupLayout.createSequentialGroup()
                .addGroup(InputGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(InputGroupLayout.createSequentialGroup()
                        .addGap(321, 321, 321)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(InputGroupLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(InputGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(InputGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NoPatientField)
                            .addComponent(NameField)
                            .addComponent(DateBirthField, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                        .addGap(54, 54, 54)
                        .addGroup(InputGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(InputGroupLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BloodTypeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(InputGroupLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(ManRadio)
                                .addGap(24, 24, 24)
                                .addComponent(WomenRadio))
                            .addGroup(InputGroupLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(32, 32, 32)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        InputGroupLayout.setVerticalGroup(
            InputGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InputGroupLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(InputGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NoPatientField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(BloodTypeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(InputGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(ManRadio)
                    .addComponent(WomenRadio)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(InputGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(InputGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(DateBirthField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        Form.add(InputGroup, java.awt.BorderLayout.PAGE_START);

        ButtonGroup.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        ResetForm.setText("Reset Form");
        ResetForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetFormActionPerformed(evt);
            }
        });
        ButtonGroup.add(ResetForm);

        Refresh.setText("Refresh");
        Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshActionPerformed(evt);
            }
        });
        ButtonGroup.add(Refresh);

        Checkup.setText("Chekup Pasien");
        Checkup.setVisible(false);
        Checkup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckupActionPerformed(evt);
            }
        });
        ButtonGroup.add(Checkup);

        Remove.setText("Hapus pasien");
        Remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RemoveMouseClicked(evt);
            }
        });
        Remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveActionPerformed(evt);
            }
        });
        Remove.setVisible(false);
        ButtonGroup.add(Remove);

        Add.setText("Simpan");
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });
        ButtonGroup.add(Add);

        Form.add(ButtonGroup, java.awt.BorderLayout.CENTER);

        add(Form, java.awt.BorderLayout.PAGE_START);

        TableWrapper.setLayout(new java.awt.BorderLayout(5, 5));

        TablePasien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "No Pasien", "Nama", "Tgl Lahir", "Gol Darah", "Jenis Kel", "Alamat", "dibuat"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
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
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        //TablePasien.setDefaultEditor(LocalDate.class, new DatePickerCellEditor(df));
        //TablePasien.getModel().addTableModelListener(new TableModelListener() {
            //    public void tableChanged(TableModelEvent e) {
                //        int firstRow = e.getFirstRow();
                //        int lastRow = e.getLastRow();
                //        int index = e.getColumn();
                //        switch (e.getType()) {
                    //            case TableModelEvent.INSERT:
                    //                for (int i = firstRow; i <= lastRow; i++) {
                        ////                  System.out.println(i);
                        //                }
                    //                break;
                    //            case TableModelEvent.UPDATE:
                    //                if (firstRow == TableModelEvent.HEADER_ROW) {
                        //                  if (index == TableModelEvent.ALL_COLUMNS) {
                            //                    System.out.println("A column was added");
                            //                  } else {
                            //                    System.out.println(index + "in header changed");
                            //                  }
                        //                } else {
                        //                  for (int i = firstRow; i <= lastRow; i++) {
                            //                    if (index == TableModelEvent.ALL_COLUMNS) {
                                //                      System.out.println("All columns have changed");
                                //                    } else {
                                ////                      System.out.println("Baris-"+ i + " .Kolom-" + index);
                                //                        updateTable(i, index);
                                //                    }
                            //                  }
                        //                }
                    //                break;
                    //            case TableModelEvent.DELETE:
                    //                for (int i = firstRow; i <= lastRow; i++) {
                        //                  System.out.println(i);
                        //                }
                    //                break;
                    //        }
                //    }
            //});
    //
    TableColumn column = TablePasien.getColumnModel().getColumn(3);

    DateCellRenderer renderer = new DateCellRenderer();
    //column.setCellEditor(TablePasien.getDefaultEditor(LocalDate.class));
    //column.setCellRenderer(TablePasien.getDefaultRenderer(Date.class));
    //column.setCellRenderer(renderer);
    //
    //TableColumn bloodColumn = TablePasien.getColumnModel().getColumn(4);
    //JComboBox comboBox = new JComboBox();
    //comboBox.addItem("A");
    //comboBox.addItem("B");
    //comboBox.addItem("AB");
    //comboBox.addItem("O");
    //bloodColumn.setCellEditor(new DefaultCellEditor(comboBox));
    //
    //TableColumn genderColumn = TablePasien.getColumnModel().getColumn(5);
    //
    //JComboBox genderComboBox = new JComboBox();
    //genderComboBox.addItem("Pria");
    //genderComboBox.addItem("Wanita");
    //genderColumn.setCellEditor(new DefaultCellEditor(genderComboBox));

    TablePasien.removeColumn(TablePasien.getColumnModel().getColumn(0));
    TablePasien.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            TablePasienMouseClicked(evt);
        }
    });
    jScrollPane1.setViewportView(TablePasien);

    TableWrapper.add(jScrollPane1, java.awt.BorderLayout.CENTER);

    add(TableWrapper, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    public String getEditedId() {
        return this.editedId;
    }
    
    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        // TODO add your handling code here:
        String patientNumber = NoPatientField.getText();
        String name = NameField.getText();
        Date birthDate = DateBirthField.getDate();
        String bloodType = BloodTypeField.getSelectedItem().toString();
        String gender = "Wanita";
        if (ManRadio.isSelected()) {
            gender = "Pria";
        }
        String address = AddressField.getText();
        Patient patient = new Patient(patientNumber, name, birthDate, bloodType, gender, address);
        if (!editedId.isEmpty()) {
            patient.setId(editedId);
            this.controller.update(patient);
        } else {
            this.controller.insert(patient);
        }
        refreshTable();
        resetForm();
        JOptionPane.showMessageDialog(this, "Berhasil disimpan!");
    }//GEN-LAST:event_AddActionPerformed

    private void RemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RemoveActionPerformed

    private void RemoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemoveMouseClicked
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
            int selectedRow = TablePasien.getSelectedRow();
            DefaultTableModel pasienModel = (DefaultTableModel) TablePasien.getModel();            
            controller.delete((String) pasienModel.getValueAt(selectedRow, 0));
            pasienModel.removeRow(selectedRow);
            JOptionPane.showMessageDialog(this, "Data telah dihapus.");
        }           
    }//GEN-LAST:event_RemoveMouseClicked

    private void RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshActionPerformed
        // TODO add your handling code here:
        refreshTable();
    }//GEN-LAST:event_RefreshActionPerformed
    public void resetForm() {
        this.Remove.setVisible(false);
        this.Checkup.setVisible(false);
        this.editedId = "";
        this.NoPatientField.setText("");
        this.NameField.setText("");
        this.DateBirthField.setCalendar(null);
        this.BloodTypeField.setSelectedItem("A");
        ManRadio.setSelected(false);
        WomenRadio.setSelected(false);
        this.AddressField.setText("");
    }
    public static Calendar toCalendar(Date date){ 
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
     }
    private void TablePasienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablePasienMouseClicked
        // TODO add your handling code here:
        this.editedId = TablePasien.getModel().getValueAt(TablePasien.getSelectedRow(), 0).toString();
        this.NoPatientField.setText(TablePasien.getModel().getValueAt(TablePasien.getSelectedRow(), 1).toString());
        this.NameField.setText(TablePasien.getModel().getValueAt(TablePasien.getSelectedRow(), 2).toString());
        this.DateBirthField.setCalendar(toCalendar((Date) TablePasien.getModel().getValueAt(TablePasien.getSelectedRow(), 3)));
        this.BloodTypeField.setSelectedItem(TablePasien.getModel().getValueAt(TablePasien.getSelectedRow(), 4));
        
        String gender = (String) TablePasien.getModel().getValueAt(TablePasien.getSelectedRow(), 5).toString();
        if (gender.equals("Pria")) {
            ManRadio.setSelected(true);
        } else {
            WomenRadio.setSelected(true);
        }
        this.AddressField.setText(TablePasien.getModel().getValueAt(TablePasien.getSelectedRow(), 6).toString());
        this.Remove.setVisible(true);
        this.Checkup.setVisible(true);
    }//GEN-LAST:event_TablePasienMouseClicked

    private void NoPatientFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoPatientFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NoPatientFieldActionPerformed

    private void NameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameFieldActionPerformed

    private void WomenRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WomenRadioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_WomenRadioActionPerformed

    private void ResetFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetFormActionPerformed
        // TODO add your handling code here:
        resetForm();
    }//GEN-LAST:event_ResetFormActionPerformed

    private void CheckupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckupActionPerformed
        // TODO add your handling code here:
        MainFrame.navigate("pasienCheckup");
    }//GEN-LAST:event_CheckupActionPerformed
    
    public void updateTable(int row, int column) {
        DefaultTableModel tm = (DefaultTableModel) TablePasien.getModel();
        String id = (String) tm.getValueAt(row, 0);  
        String patientNumber = (String) tm.getValueAt(row, 1);
        String name = (String) tm.getValueAt(row, 2);
        Date birthDate = (Date) tm.getValueAt(row, 3);
        
        System.out.println(tm.getValueAt(row, 3).getClass().getSimpleName() + ": " + tm.getValueAt(row, 3));
        
//        if (tm.getValueAt(row, 3).getClass().getSimpleName() == "String") {
//            System.out.println("birth date: " + tm.getValueAt(row, 3));
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy");
//            birthDate = LocalDate.parse((String) tm.getValueAt(row, 3), formatter);
//        } else {
//            System.out.println("date: " + tm.getValueAt(row, 3));
//            birthDate = (LocalDate) tm.getValueAt(row, 3);
//        }
//        ZoneId systemTimeZone = ZoneId.systemDefault();
//        ZonedDateTime zonedDateTime = birthDate.atStartOfDay(systemTimeZone);
//        Date utilDate = Date.from(zonedDateTime.toInstant());
        
        String bloodType = (String) tm.getValueAt(row, 4);
        String gender = (String) tm.getValueAt(row, 5);
        String address = (String) tm.getValueAt(row, 6);
        Patient updated = new Patient(patientNumber, name, birthDate, bloodType, gender, address);
        updated.setId(id);
        this.controller.update(updated);
    }
    
    public void getDataTable() {
        DefaultTableModel tm = (DefaultTableModel) TablePasien.getModel();
        tm.setRowCount(0);
        try {
//            ManagePatient mp = new ManagePatient();
//            DateFormat df = new SimpleDateFormat("MMM dd, yyyy");
            for (Iterator iterator = this.controller.getAllPatients().iterator(); iterator.hasNext();) {
                Patient next = (Patient) iterator.next();
                Object o[] = {
                    next.getId(),
                    next.getPatientNumber(),
                    next.getName(),
//                    df.format(next.getBirthDate()),
                    next.getBirthDate(),
                    next.getBloodType(),
                    next.getGender(),
                    next.getAddress(),
                    next.getCreatedAt()
                };
                tm.addRow(o);
            }    
        } catch (Exception e) {
            System.err.println("gakbener");
            System.err.print(e);
        }   
    }
    
    public void refreshTable() {
        DefaultTableModel tm = (DefaultTableModel) TablePasien.getModel();
        getDataTable();
        tm.fireTableDataChanged();
        TablePasien.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JTextArea AddressField;
    private javax.swing.JComboBox<String> BloodTypeField;
    private javax.swing.JPanel ButtonGroup;
    private javax.swing.JButton Checkup;
    private com.toedter.calendar.JDateChooser DateBirthField;
    private javax.swing.JPanel Form;
    private javax.swing.JPanel InputGroup;
    private javax.swing.JRadioButton ManRadio;
    private javax.swing.JTextField NameField;
    private javax.swing.JTextField NoPatientField;
    private javax.swing.JButton Refresh;
    private javax.swing.JButton Remove;
    private javax.swing.JButton ResetForm;
    private javax.swing.JTable TablePasien;
    private javax.swing.JPanel TableWrapper;
    private javax.swing.JRadioButton WomenRadio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
