package com.raven.event;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author RAVEN
 */
public class TableActionCellRender extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean isSeleted, boolean bln1, int row, int column) {
        PanelAction action = new PanelAction();
        
            action.setBackground(Color.WHITE);
       
        return action;
    }
    public Component getTableCellRendererDisableComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
         Component rendererComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        boolean isDisabled = "Disable".equals(value);

        if (isDisabled) {
            rendererComponent.setForeground(Color.GRAY);
            rendererComponent.setBackground(Color.LIGHT_GRAY);
        } else {
            rendererComponent.setForeground(table.getForeground());
            rendererComponent.setBackground(table.getBackground());
        }

        return rendererComponent;
    }
}
