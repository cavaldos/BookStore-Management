
package store.view.employee.order;

import store.Service.OrderService;
import javax.swing.table.DefaultTableModel;

import store.Model.OrderDetail;

import java.sql.SQLException;
import java.util.List;

public class OrderDetailView extends javax.swing.JFrame {
    private OrderService orderService;
    private int idOrder;

    public OrderDetailView(int idOrder) {
        initComponents();
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.idOrder = idOrder;
        this.orderService = new OrderService();
        showTable();
    }

    public void showTable() {
        try {
            DefaultTableModel model = (DefaultTableModel) OrderDetailViewTable.getModel();
            model.setRowCount(0);
            for (OrderDetail orderDetail : orderService.selectOrderDetailbyID(idOrder)) {
                model.addRow(new Object[] { orderDetail.getOrderDetailID(), orderDetail.getBookTitle(),
                        orderDetail.getPrice(), orderDetail.getQuantity() });
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        OkButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        OrderDetailViewTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        OkButton.setText("OK");
        OkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OkButtonActionPerformed(evt);
            }
        });

        OrderDetailViewTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null }
                },
                new String[] {
                        "ID Order Detail", "Book Title", "Price", "Quantity"
                }) {
            Class[] types = new Class[] {
                    java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean[] {
                    false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(OrderDetailViewTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());

        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(468, Short.MAX_VALUE)
                                .addComponent(OkButton)
                                .addGap(69, 69, 69))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(139, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)
                                .addComponent(OkButton)
                                .addGap(82, 82, 82)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OkButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_OkButtonActionPerformed
        OrderDetailView.this.dispose();
    }// GEN-LAST:event_OkButtonActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton OkButton;
    private javax.swing.JTable OrderDetailViewTable;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
