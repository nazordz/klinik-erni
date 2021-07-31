/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven.app.util;

import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.util.Date;
import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author mac
 */
public class DateEditor extends AbstractCellEditor implements TableCellEditor {
    protected JDateChooser dateChooser;
    public DateEditor() {
        dateChooser = new JDateChooser();
    }
    public Object getCellEditorValue() {
        return dateChooser.getDate();
    }
    public Component getTableCellEditorComponent(
        JTable table,
        Object value,
        boolean isSelected,
        int row,
        int column
    ) {
        dateChooser.setDate((Date) value);
        return dateChooser;
    }
}
