
package store.view.employee.order;

import javax.swing.*;
import java.awt.*;

import store.Model.Order;
import store.Service.OrderService;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class ViewOrder extends javax.swing.JPanel {

    private OrderService orderService;
    private OrderDetailView orderDetailView;
    public ViewOrder() {
        this.orderService = new OrderService();
        initComponents();
        showTable();
    }

    public void showTable() {
        try {
            DefaultTableModel model = (DefaultTableModel) TableOrder.getModel();
            model.setRowCount(0);
            for (Order order : orderService.getAllOrders()) {
                model.addRow(new Object[] {
                        order.getOrderID(),
                        order.getDate(),
                        order.getCustomer(),
                        order.getEmployee(),
                        order.getTotalCost(),
                        order.getDiscount(),
                        order.getStatus() ? "Active" : "Inactive"
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // search order
    public void searchOrder(String orderID) {
        try {
            DefaultTableModel model = (DefaultTableModel) TableOrder.getModel();
            model.setRowCount(0);
            for (Order order : orderService.getAllOrders()) {
                if (String.valueOf(order.getOrderID()).contains(orderID)) {
                    model.addRow(new Object[] {
                            order.getOrderID(),
                            order.getDate(),
                            order.getCustomer(),
                            order.getEmployee(),
                            order.getTotalCost(),
                            order.getDiscount(),
                            order.getStatus() ? "Active" : "Inactive"
                    });
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TableOrder = new javax.swing.JTable();
        ViewButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        RefreshBurron = new javax.swing.JButton();
        InputOrderFiled = new javax.swing.JTextField();
        SearchButton = new javax.swing.JButton();

        TableOrder.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null }
                },
                new String[] {
                        "ID Order", "Date", "Phone Number", "Employee", "Total", "Discount", "Status"
                }) {
            Class[] types = new Class[] {
                    java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class,
                    java.lang.Double.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[] {
                    false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(TableOrder);
        // sorter
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>((DefaultTableModel) TableOrder.getModel());
        TableOrder.setRowSorter(sorter);
        ViewButton.setText("View");
        ViewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewButtonActionPerformed(evt);
            }
        });

        DeleteButton.setText("Delete");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        RefreshBurron.setText("Refresh");
        RefreshBurron.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshBurronActionPerformed(evt);
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
                                .addGap(52, 52, 52)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(ViewButton)
                                                        .addGap(30, 30, 30)
                                                        .addComponent(DeleteButton)
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(RefreshBurron))
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        1133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(InputOrderFiled, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(68, 68, 68)
                                                .addComponent(SearchButton)))
                                .addContainerGap(65, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(RefreshBurron)
                                        .addComponent(DeleteButton)
                                        .addComponent(ViewButton))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(InputOrderFiled, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(SearchButton))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
                                .addGap(99, 99, 99)));
    }// </editor-fold>//GEN-END:initComponents

    private void ViewButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int row = TableOrder.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "You must select an order", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            int orderID = (int) TableOrder.getValueAt(row, 0);
            orderDetailView = new OrderDetailView(orderID);
            orderDetailView.setVisible(true);
        }
    }

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {
        searchOrder(InputOrderFiled.getText());
    }

    private void RefreshBurronActionPerformed(java.awt.event.ActionEvent evt) {
        showTable();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeleteButton;
    private javax.swing.JTextField InputOrderFiled;
    private javax.swing.JButton RefreshBurron;
    private javax.swing.JButton SearchButton;
    private javax.swing.JTable TableOrder;
    private javax.swing.JButton ViewButton;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
