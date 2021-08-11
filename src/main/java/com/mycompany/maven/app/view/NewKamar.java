/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven.app.view;
import com.mycompany.maven.app.koneksi;
import java.sql.*;
import java.text.Format;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
/*import java.util.HashMap;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;*/
/**
 *
 * @author Asus
 */
public class NewKamar extends javax.swing.JFrame {

    private Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;
    public String tgl_inap;
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    
    protected void aktif() {
        cIdPasien.setEnabled(true);
        cNoKamar.setEnabled(true);
        cTipeKamar.setEnabled(true);
        dTglInap.setEnabled(true);
        tHargaKamar.setEnabled(true);
        cIdPasien.requestFocus();
    }
    
    protected void kosong() {
        cIdPasien.setSelectedIndex(0);
        cNoKamar.setSelectedIndex(0);
        cTipeKamar.setSelectedIndex(0);
        dTglInap.setDate(null);
        tHargaKamar.setText("");
        tCari.setText("");
    }
    
    protected void dataTable() {
        Object[] Baris = {"Id Pasien","Nomer Kamar","Tipe Kamar","Tanggal Inap","Harga Kamar"};
        tabmode = new DefaultTableModel(null, Baris);
        tabelKamar.setModel(tabmode);
        String sql = "select * from new_kamar";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                String a = hasil.getString("id_pasien");
                String b = hasil.getString("no_kamar");
                String c = hasil.getString("tipe_kamar");
                String d = hasil.getString("tgl_inap");
                String e = hasil.getString("harga_kamar");
                
                String[] data = {a,b,c,d,e};
                tabmode.addRow (data);
            }
        } catch (Exception e) {
            
        }
    }
    /**
     * Creates new form NewKamar
     */
    public NewKamar() {
        initComponents();
        dataTable();
        kosong();
        aktif();
        dTglInap.setDateFormatString("yyyy-MM-dd");
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cIdPasien = new javax.swing.JComboBox<>();
        cNoKamar = new javax.swing.JComboBox<>();
        cTipeKamar = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        dTglInap = new com.toedter.calendar.JDateChooser();
        tHargaKamar = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelKamar = new javax.swing.JTable();
        bSave = new javax.swing.JButton();
        bEdit = new javax.swing.JButton();
        bDelete = new javax.swing.JButton();
        bClear = new javax.swing.JButton();
        bPrint = new javax.swing.JButton();
        bExit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tCari = new javax.swing.JTextField();
        bCari = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Data Kamar");

        jLabel4.setText("Id Pasien");

        jLabel5.setText("Nomer Kamar");

        jLabel6.setText("Tipe Kamar");

        cIdPasien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "001", "002", "003", "004", "005" }));

        cNoKamar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01A", "01B", "02A", "02B", "03A" }));

        cTipeKamar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "IGD", "UGD", "VVIP", "VIP" }));

        jLabel7.setText("Tanggal Menginap");

        jLabel8.setText("Harga Kamar");

        dTglInap.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dTglInapPropertyChange(evt);
            }
        });

        jLabel9.setText("Rp.");

        tabelKamar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Pasien", "Nomer Kamar", "Tipe Kamar", "Tanggal Menginap", "Harga Kamar"
            }
        ));
        tabelKamar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelKamarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelKamar);

        bSave.setText("Save");
        bSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSaveActionPerformed(evt);
            }
        });

        bEdit.setText("Edit");
        bEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEditActionPerformed(evt);
            }
        });

        bDelete.setText("Delete");
        bDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDeleteActionPerformed(evt);
            }
        });

        bClear.setText("Clear");
        bClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bClearActionPerformed(evt);
            }
        });

        bPrint.setText("Print");
        bPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPrintActionPerformed(evt);
            }
        });

        bExit.setText("Exit");
        bExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExitActionPerformed(evt);
            }
        });

        jLabel2.setText("Kata Kunci Pencarian");

        bCari.setText("Cari");
        bCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCariActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 649, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel1)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(bSave)
                                                .addComponent(jLabel7))
                                            .addComponent(jLabel4))
                                        .addGap(27, 27, 27)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(tHargaKamar)
                                                    .addComponent(cTipeKamar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(cNoKamar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                            .addComponent(dTglInap, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                                                            .addComponent(cIdPasien, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGap(0, 0, Short.MAX_VALUE))))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(bEdit)
                                                .addGap(18, 18, 18)
                                                .addComponent(bDelete)
                                                .addGap(18, 18, 18)
                                                .addComponent(bClear))))
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addComponent(bPrint))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(tCari, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(bCari))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(bExit)))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cIdPasien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cNoKamar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cTipeKamar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bSave)
                            .addComponent(bEdit)
                            .addComponent(bDelete)
                            .addComponent(bClear)
                            .addComponent(bPrint)
                            .addComponent(bExit))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bCari))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(dTglInap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tHargaKamar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSaveActionPerformed
        // TODO add your handling code here:
        String sql = "insert into rooms values (?,?,?,?,?)";
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, cIdPasien.getSelectedItem().toString());
            stat.setString(2, cNoKamar.getSelectedItem().toString());
            stat.setString(3, cTipeKamar.getSelectedItem().toString());
            
            stat.setString(4, tgl_inap);
            stat.setString(5, tHargaKamar.getText());
            
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
            kosong();
            cIdPasien.requestFocus();
            dataTable();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan"+e);
        }
    }//GEN-LAST:event_bSaveActionPerformed

    private void dTglInapPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dTglInapPropertyChange
        // TODO add your handling code here:
        if (dTglInap.getDate() != null) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            tgl_inap = format.format(dTglInap.getDate());
        }
    }//GEN-LAST:event_dTglInapPropertyChange

    private void bClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bClearActionPerformed
        // TODO add your handling code here:
        kosong();
        dataTable();
    }//GEN-LAST:event_bClearActionPerformed

    private void bPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPrintActionPerformed
        // TODO add your handling code here:
        try {
	String namaFile = "src/Laporan/laporanKamar.jasper";
	Connection conn = new koneksi().connect();
	HashMap parameter = new HashMap();
	File report_file  = new File (namaFile);
	JasperReport jasperReport = (JasperReport) JRLoader.loadObject(report_file.getPath());
	JasperPrint jasperPrint = JasperFillManager.fillReport (jasperReport, parameter, conn);
        JasperViewer.viewReport(jasperPrint, false);
        JasperViewer.setDefaultLookAndFeelDecorated(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }       
    }//GEN-LAST:event_bPrintActionPerformed

    private void bExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExitActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(null, "Yakin Keluar aplikasi???",
        "Yakin", JOptionPane.YES_NO_OPTION) ==JOptionPane.YES_OPTION)
        this.dispose();
    }//GEN-LAST:event_bExitActionPerformed

    private void bEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "update new_kamar set no_kamar=?,tipe_kamar=?,tgl_inap=?,harga_kamar=? where id_pasien=?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, cNoKamar.getSelectedItem().toString());
            stat.setString(2, cTipeKamar.getSelectedItem().toString());
            stat.setString(3, tgl_inap);
            
            stat.setString(4, tHargaKamar.getText());
            stat.setString(5, cIdPasien.getSelectedItem().toString());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
            kosong();
            cIdPasien.requestFocus();
            dataTable();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Diubah"+e);
        }
    }//GEN-LAST:event_bEditActionPerformed

    private void bDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeleteActionPerformed
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog(null, "hapus","Konfirmasi Dialog", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            String sql = "delete from new_kamar where id_pasien =?";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.setString(1, cIdPasien.getSelectedItem().toString());
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "data berhasil dihapus");
                kosong();
                cIdPasien.requestFocus();
                dataTable();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Data gagal dihapus"+e);
            }
        }
    }//GEN-LAST:event_bDeleteActionPerformed

    private void bCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCariActionPerformed
        // TODO add your handling code here:
        Object[] Baris = {"Id Pasien","Nomer Kamar","Tipe Kamar","Tanggal Inap","Harga Kamar"};
        tabmode = new DefaultTableModel(null,  Baris);
        tabelKamar.setModel(tabmode);
        String sql = "select * from new_kamar where id_pasien like '%"+tCari.getText()+"%'";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()) {
                String a = hasil.getString("id_pasien");
                String b = hasil.getString("no_kamar");
                String c = hasil.getString("tipe_kamar");
                String d = hasil.getString("tgl_inap");
                String e = hasil.getString("harga_kamar");
                
                String[] data = {a,b,c,d,e};
                tabmode.addRow(data);
            }
        } catch (Exception e) {
            
        }
    }//GEN-LAST:event_bCariActionPerformed

    private void tabelKamarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelKamarMouseClicked
        // TODO add your handling code here:
        int bar = tabelKamar.getSelectedRow();
        String a = tabmode.getValueAt(bar, 0).toString();
        String b = tabmode.getValueAt(bar, 1).toString();
        String c = tabmode.getValueAt(bar, 2).toString();
        String d = tabmode.getValueAt(bar, 3).toString();
        String e = tabmode.getValueAt(bar, 4).toString();
       
        cIdPasien.setSelectedItem(a);
        cNoKamar.setSelectedItem(b);
        cTipeKamar.setSelectedItem(c);
        dTglInap.setDateFormatString("MMM dd, yyyy");
        tHargaKamar.setText(e);
    }//GEN-LAST:event_tabelKamarMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewKamar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewKamar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewKamar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewKamar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewKamar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCari;
    private javax.swing.JButton bClear;
    private javax.swing.JButton bDelete;
    private javax.swing.JButton bEdit;
    private javax.swing.JButton bExit;
    private javax.swing.JButton bPrint;
    private javax.swing.JButton bSave;
    private javax.swing.JComboBox<String> cIdPasien;
    private javax.swing.JComboBox<String> cNoKamar;
    private javax.swing.JComboBox<String> cTipeKamar;
    private com.toedter.calendar.JDateChooser dTglInap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tCari;
    private javax.swing.JTextField tHargaKamar;
    private javax.swing.JTable tabelKamar;
    // End of variables declaration//GEN-END:variables
}
