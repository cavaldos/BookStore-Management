package store.view.employee.sheet;

import java.awt.Color;
import store.Model.Sheet;
import store.Service.EmployeeService;
import store.view.employee.sheet.ViewSheetDetail;

import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import store.view.employee.ui.swing.ScrollBar;

public class ViewSheet extends javax.swing.JPanel {

    private EmployeeService employeeService;
    private ViewSheetDetail viewSheetDetail;

    public ViewSheet() {
        initComponents();
        spTable.setVerticalScrollBar(new ScrollBar());
        spTable.getVerticalScrollBar().setBackground(Color.WHITE);
        spTable.getViewport().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        employeeService = new EmployeeService();
        showSheet();
    }

    public void showSheet() {
        try {
            List<Sheet> sheets = employeeService.getAllSheet();
            DefaultTableModel model = (DefaultTableModel) TableSheet.getModel();
            model.setRowCount(0);
            for (Sheet sheet : sheets) {
                model.addRow(new Object[] { sheet.getSheetID(), sheet.getEmployeeName(),
                        sheet.getDate(),
                        sheet.getTotalCost() });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchSheet(String input) {
        try {
            List<Sheet> sheets = employeeService.getAllSheet();
            DefaultTableModel model = (DefaultTableModel) TableSheet.getModel();
            model.setRowCount(0);
            for (Sheet sheet : sheets) {
                model.addRow(new Object[] { sheet.getSheetID(), sheet.getEmployeeName(),
                        sheet.getDate(),
                        sheet.getTotalCost() });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        spTable = new javax.swing.JScrollPane();
        TableSheet = new javax.swing.JTable();
        ViewButton = new javax.swing.JButton();
        RefeshButton = new javax.swing.JButton();
        inputField = new javax.swing.JTextField();
        SearchButton = new javax.swing.JButton();

        TableSheet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "sheetID", "employee", "Date", "Total Cost"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        spTable.setViewportView(TableSheet);

        ViewButton.setText("View Detail");
        ViewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewButtonActionPerformed(evt);
            }
        });

        RefeshButton.setText("Refresh");
        RefeshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefeshButtonActionPerformed(evt);
            }
        });

        SearchButton.setText("Search");
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(inputField, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(SearchButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ViewButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(RefeshButton))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, 924, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ViewButton)
                    .addComponent(RefeshButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchButton))
                .addGap(18, 18, 18)
                .addComponent(spTable, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ViewButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_ViewButtonActionPerformed
        int row = TableSheet.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(ViewButton, "Please select a sheet");
        } else {
            int sheetID = (int) TableSheet.getValueAt(row, 0);
            viewSheetDetail = new ViewSheetDetail(sheetID);
            viewSheetDetail.setVisible(true);
        }
    }// GEN-LAST:event_ViewButtonActionPerformed

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_SearchButtonActionPerformed

        String input = inputField.getText();
        searchSheet(input);
    }// GEN-LAST:event_SearchButtonActionPerformed

    private void RefeshButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_RefeshButtonActionPerformed
        showSheet();
    }// GEN-LAST:event_RefeshButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton RefeshButton;
    private javax.swing.JButton SearchButton;
    private javax.swing.JTable TableSheet;
    private javax.swing.JButton ViewButton;
    private javax.swing.JTextField inputField;
    private javax.swing.JScrollPane spTable;
    // End of variables declaration//GEN-END:variables
}