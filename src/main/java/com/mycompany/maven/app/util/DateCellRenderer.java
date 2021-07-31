/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven.app.util;

import java.awt.Component;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import java.util.Date;
/**
 *
 * @author mac
 */
public class DateCellRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object value, boolean selected, boolean hasFocus, int row, int column) {

        if (value instanceof Date) {
            // You could use SimpleDateFormatter instead
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            value = formatter.format(value);  
//            value = DateFormat.getDateInstance().format(value);
        }

        return super.getTableCellRendererComponent(jtable, value, selected, hasFocus, row, column);
    }
}
