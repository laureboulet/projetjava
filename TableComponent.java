/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author laure et clemence
 */
public class TableComponent extends DefaultTableCellRenderer{
    /**
     * constructeur
     * @param table
     * @param value
     * @param isSelected
     * @param hasFocus
     * @param row
     * @param column
     * @return 
     */
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
    //Si la valeur de la cellule est un JButton, on transtype cette valeur
    if (value instanceof JButton)
      return (JButton) value;
    else if(value instanceof JComboBox)
        return (JComboBox) value;
    else
      return this;
    }
}
