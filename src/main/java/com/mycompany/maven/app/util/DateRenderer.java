/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven.app.util;

import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author mac
 */
public class DateRenderer extends JDateChooser implements TableCellRenderer {
    public Component getTableCellRendererComponent(
        JTable table,
        Object value,
        boolean isSelected,
        boolean hasFocus,
        int row,
        int column
    ) {
        setDate((Date) value);
        return this;
    }
}
