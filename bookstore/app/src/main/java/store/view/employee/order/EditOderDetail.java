
package store.view.employee.order;

import store.Model.OrderDetail;
import store.Service.OrderService;
import javax.swing.JOptionPane;

public class EditOderDetail extends javax.swing.JFrame {

    private OrderService orderService;
    private int bookID;

    public EditOderDetail(int bookID) {
        
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.orderService = new OrderService();
        this.bookID = bookID; // Set the bookId before loading details
        loadOrderDetail();
    }

    private void loadOrderDetail() {
        try {
            OrderDetail orderDetail = orderService.getOrderDetailCatcheByID(bookID);
            if (orderDetail != null) {
                IDField.setText(String.valueOf(orderDetail.getBookID()));
                QuantityField.setText(String.valueOf(orderDetail.getQuantity()));
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

        IDLabel = new javax.swing.JLabel();
        IDField = new javax.swing.JTextField();
        QuantityField = new javax.swing.JTextField();
        QuantityLabel = new javax.swing.JLabel();
        CancelButton = new javax.swing.JButton();
        OKButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        IDLabel.setText("ID");
        IDLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        IDField.setEditable(false);

        QuantityLabel.setText("Quantity");
        QuantityLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        CancelButton.setText("Cancel");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        OKButton.setText("OK");
        OKButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(IDLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(QuantityLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 32, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(IDField, javax.swing.GroupLayout.DEFAULT_SIZE, 78,
                                                Short.MAX_VALUE)
                                        .addComponent(QuantityField))
                                .addGap(159, 159, 159))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CancelButton)
                                .addGap(36, 36, 36)
                                .addComponent(OKButton)
                                .addGap(34, 34, 34)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(108, 108, 108)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(IDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(IDField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(QuantityField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(QuantityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 227,
                                        Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(OKButton)
                                        .addComponent(CancelButton))
                                .addGap(56, 56, 56)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OKButtonActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            // Đọc giá trị từ trường nhập và chuyển đổi thành số nguyên
            int quantity = Integer.parseInt(QuantityField.getText());

            // Kiểm tra nếu quantity lớn hơn 0
            if (quantity > 0) {
                // Tạo một đối tượng OrderDetail mới và cập nhật
                OrderDetail orderDetail = new OrderDetail(bookID, quantity);
                orderService.editOrderDetailCatche(orderDetail);
                this.dispose(); // Đóng cửa sổ nếu không có lỗi
            } else {
                // Hiển thị thông báo lỗi nếu quantity không hợp lệ (nhỏ hơn hoặc bằng 0)
                JOptionPane.showMessageDialog(this, "Quantity must be greater than 0.", "Invalid Input",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            // Bắt và xử lý ngoại lệ nếu không phải là số nguyên
            JOptionPane.showMessageDialog(this, "Please enter a valid integer for quantity.", "Invalid Input",
                    JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_CancelButtonActionPerformed
        this.dispose();
    }// GEN-LAST:event_CancelButtonActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelButton;
    private javax.swing.JTextField IDField;
    private javax.swing.JLabel IDLabel;
    private javax.swing.JButton OKButton;
    private javax.swing.JTextField QuantityField;
    private javax.swing.JLabel QuantityLabel;
    // End of variables declaration//GEN-END:variables
}
