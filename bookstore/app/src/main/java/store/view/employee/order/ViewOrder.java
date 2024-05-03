
package store.view.employee.order;

import javax.swing.*;

import store.Model.Order;
import store.Service.OrderService;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import store.view.employee.ui.swing.ScrollBar;

public class ViewOrder extends javax.swing.JPanel {

    private OrderService orderService;

    private OrderDetailView orderDetailView;
    private JDateChooser dateChooser;

    public ViewOrder() {
        this.orderService = new OrderService();
        initComponents();
        spTable.setVerticalScrollBar(new ScrollBar());
        spTable.getVerticalScrollBar().setBackground(Color.WHITE);
        spTable.getViewport().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        showTable();
        this.dateChooser = new JDateChooser();
        this.dateChooser.setBounds(700, 40, 200, 30);
        add(this.dateChooser);
    }

    public void searchOrderByDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(date); // Format ngày đã chọn

        try {
            DefaultTableModel model = (DefaultTableModel) TableOrder.getModel();
            model.setRowCount(0);
            for (Order order : orderService.getAllOrders()) {
                String orderDate = dateFormat.format(order.getDate());
                if (orderDate.equals(formattedDate)) {
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
            JOptionPane.showMessageDialog(this, "Error in searching orders by date.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
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
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        spTable = new javax.swing.JScrollPane();
        TableOrder = new javax.swing.JTable();
        ViewButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        RefreshBurron = new javax.swing.JButton();
        InputOrderFiled = new javax.swing.JTextField();
        SearchButton = new javax.swing.JButton();
        SearchDateButton = new javax.swing.JButton();

        TableOrder.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null }
                },
                new String[] {
                        "ID Order", "Date", "Username", "Employee", "Total", "Discount", "Status"
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
        spTable.setViewportView(TableOrder);

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

        SearchDateButton.setText("Search Date");
        SearchDateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchDateButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout
                                                        .createSequentialGroup()
                                                        .addComponent(ViewButton)
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(SearchDateButton)
                                                        .addGap(30, 30, 30)
                                                        .addComponent(RefreshBurron)
                                                        .addGap(11, 11, 11))
                                                .addComponent(spTable, javax.swing.GroupLayout.Alignment.LEADING,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 924,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(DeleteButton)
                                                        .addComponent(InputOrderFiled,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 247,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(SearchButton)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(RefreshBurron)
                                        .addComponent(DeleteButton)
                                        .addComponent(ViewButton)
                                        .addComponent(SearchDateButton))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(InputOrderFiled, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(SearchButton))
                                .addGap(18, 18, 18)
                                .addComponent(spTable, javax.swing.GroupLayout.DEFAULT_SIZE, 652, Short.MAX_VALUE)
                                .addContainerGap()));
    }// </editor-fold>//GEN-END:initComponents

    private void SearchDateButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_SearchDateButtonActionPerformed
        Date selectedDate = dateChooser.getDate();
        if (selectedDate != null) {
            searchOrderByDate(selectedDate);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a date first.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }// GEN-LAST:event_SearchDateButtonActionPerformed

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
        int row = TableOrder.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "You must select an order", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            // Hiển thị hộp thoại xác nhận
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this order?",
                    "Confirm Deletion", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (confirm == JOptionPane.YES_OPTION) {
                int orderID = (int) TableOrder.getValueAt(row, 0);
                try {
                    orderService.deleteOrder(orderID);
                    showTable(); // Cập nhật lại bảng hiển thị sau khi xóa
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error deleting the order.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
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
    private javax.swing.JButton SearchDateButton;
    private javax.swing.JTable TableOrder;
    private javax.swing.JButton ViewButton;
    private javax.swing.JScrollPane spTable;
    // End of variables declaration//GEN-END:variables
}
