
package store.view.employee.order;

import java.awt.Color;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import store.Service.BookService;
import store.Model.Book;
import store.Model.OrderDetail;
import store.Model.Order;
import store.Model.Customer;
import store.Service.OrderService;
import store.Service.CustomerService;
import store.utils.UserSession;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import store.view.employee.ui.swing.ScrollBar;

public class CreateOrder extends javax.swing.JPanel {
    private BookService bookService;
    private OrderService orderService;
    private CustomerService customerService;
    private Customer customer;
    private EditOderDetail editOderDetail;
    private Order newOrder;
    private UserSession userSession;

    public CreateOrder() {
        initComponents();
        this.userSession = UserSession.getInstance();

        this.bookService = new BookService();
        this.orderService = new OrderService();
        this.customerService = new CustomerService();
        this.newOrder = new Order();
        // spTable1
        spTable1.setVerticalScrollBar(new ScrollBar());
        spTable1.getVerticalScrollBar().setBackground(Color.WHITE);
        spTable1.getViewport().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTable1.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        // spTable2
        spTable2.setVerticalScrollBar(new ScrollBar());
        spTable2.getVerticalScrollBar().setBackground(Color.WHITE);
        spTable2.getViewport().setBackground(Color.WHITE);
        JPanel p2 = new JPanel();
        p.setBackground(Color.WHITE);
        spTable2.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p2);
        showTableBook();
        showTableOrderDetail();
    }

    private Double calculateTotal() {
        DefaultTableModel model = (DefaultTableModel) TableOrderDetail.getModel();
        double totalCost = 0;
        for (int i = 0; i < model.getRowCount(); i++) {
            int quantity = Integer.parseInt(model.getValueAt(i, 2).toString()); // Assuming quantity is at
                                                                                // column index 2
            double price = Double.parseDouble(model.getValueAt(i, 3).toString()); // Assuming price is at
                                                                                  // column index 3
            totalCost += (quantity * price);
        }
        return totalCost;

    }

    public void showTableOrderDetail() {
        try {
            DefaultTableModel model = (DefaultTableModel) TableOrderDetail.getModel();
            model.setRowCount(0);

            for (OrderDetail orderDetail : orderService.getListOrderDetailCatche()) {
                model.addRow(new Object[] {
                        orderDetail.getBookID(),
                        orderDetail.getBookTitle(),
                        orderDetail.getQuantity(),
                        orderDetail.getPrice()
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showTableBook() {
        try {
            DefaultTableModel model = (DefaultTableModel) TableBook.getModel();
            model.setRowCount(0);
            for (Book book : bookService.getAllBooks()) {
                model.addRow(new Object[] {
                        book.getBookID(),
                        book.getTitle()
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchBook(String title) {
        try {
            DefaultTableModel model = (DefaultTableModel) TableBook.getModel();
            model.setRowCount(0);
            for (Book book : bookService.getAllBooks()) {
                if (book.getTitle().contains(title)) {
                    model.addRow(new Object[] {
                            book.getBookID(),
                            book.getTitle()
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
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        spTable1 = new javax.swing.JScrollPane();
        TableBook = new javax.swing.JTable();
        InputSearchBook = new javax.swing.JTextField();
        SearchBookButton = new javax.swing.JButton();
        AddBookButton = new javax.swing.JButton();
        PhoneField = new javax.swing.JTextField();
        PhoneLabel = new javax.swing.JLabel();
        SuccesButton = new javax.swing.JButton();
        CancelOrderButton = new javax.swing.JButton();
        ConfirmButton = new javax.swing.JButton();
        FirstNameField = new javax.swing.JTextField();
        PhoneLabel1 = new javax.swing.JLabel();
        LastNameField = new javax.swing.JTextField();
        LastNameLabel = new javax.swing.JLabel();
        TotalField = new javax.swing.JTextField();
        TotalLabel = new javax.swing.JLabel();
        EditBookButton = new javax.swing.JButton();
        RefreshBookButton = new javax.swing.JButton();
        DeleteBookButton = new javax.swing.JButton();
        spTable2 = new javax.swing.JScrollPane();
        TableOrderDetail = new javax.swing.JTable();

        TableBook.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null },
                        { null, null }
                },
                new String[] {
                        "ID Book", "Name Book"
                }) {
            Class[] types = new Class[] {
                    java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[] {
                    false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        spTable1.setViewportView(TableBook);

        SearchBookButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search.png"))); // NOI18N
        SearchBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBookButtonActionPerformed(evt);
            }
        });

        AddBookButton.setText("Add To Card");
        AddBookButton.setToolTipText("");
        AddBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBookButtonActionPerformed(evt);
            }
        });

        PhoneLabel.setText("Username");
        PhoneLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        SuccesButton.setText("Succes");
        SuccesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuccesButtonActionPerformed(evt);
            }
        });

        CancelOrderButton.setText("Cancel");
        CancelOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelOrderButtonActionPerformed(evt);
            }
        });

        ConfirmButton.setText("Confirm");
        ConfirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmButtonActionPerformed(evt);
            }
        });

        PhoneLabel1.setText("First Name");
        PhoneLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        LastNameLabel.setText("Last Name");
        LastNameLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        TotalLabel.setText("Total");
        TotalLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        EditBookButton.setText("Edit");
        EditBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditBookButtonActionPerformed(evt);
            }
        });

        RefreshBookButton.setText("Refresh");
        RefreshBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshBookButtonActionPerformed(evt);
            }
        });

        DeleteBookButton.setText("Delete");
        DeleteBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBookButtonActionPerformed(evt);
            }
        });

        TableOrderDetail.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null, null },
                        { null, null, null, null }
                },
                new String[] {
                        "ID book", "Name Book", "Quantity", "Price"
                }) {
            Class[] types = new Class[] {
                    java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
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
        spTable2.setViewportView(TableOrderDetail);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(InputSearchBook,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 191,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(SearchBookButton))
                                                        .addComponent(spTable1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                0, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(spTable2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                384, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(DeleteBookButton)
                                                                .addGap(9, 9, 9)
                                                                .addComponent(EditBookButton)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)
                                                                .addComponent(RefreshBookButton)))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(CancelOrderButton,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 109,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                        40, Short.MAX_VALUE)
                                                                .addComponent(SuccesButton,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 111,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                                .createSequentialGroup()
                                                                .addComponent(PhoneLabel1,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 107,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(FirstNameField))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                layout.createSequentialGroup()
                                                                        .addGap(0, 0, Short.MAX_VALUE)
                                                                        .addComponent(ConfirmButton))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                                .createSequentialGroup()
                                                                .addComponent(PhoneLabel,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 107,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(PhoneField))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                        false)
                                                                        .addComponent(LastNameLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                107, Short.MAX_VALUE)
                                                                        .addComponent(TotalLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE))
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(LastNameField)
                                                                        .addComponent(TotalField))))
                                                .addGap(10, 10, 10))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(AddBookButton)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        Short.MAX_VALUE)))));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(AddBookButton)
                                                .addGap(18, 18, 18)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE,
                                                                false)
                                                        .addComponent(SearchBookButton,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(InputSearchBook,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 31,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                .createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(DeleteBookButton,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 31,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(EditBookButton,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 31,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(RefreshBookButton,
                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 31,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(PhoneLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 37,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(PhoneField,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 37,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(ConfirmButton)
                                                .addGap(30, 30, 30)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(FirstNameField,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 37,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(PhoneLabel1,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 37,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(LastNameLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 37,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(LastNameField,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 37,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(TotalLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 37,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(TotalField,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 37,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52,
                                                        Short.MAX_VALUE)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(CancelOrderButton,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 39,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(SuccesButton,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 39,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap(45, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                false)
                                                        .addComponent(spTable1,
                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, 379,
                                                                Short.MAX_VALUE)
                                                        .addComponent(spTable2,
                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 0,
                                                                Short.MAX_VALUE))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        Short.MAX_VALUE)))));
    }// </editor-fold>//GEN-END:initComponents

    private void AddBookButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int row = TableBook.getSelectedRow();
        int idBook = (int) TableBook.getValueAt(row, 0);
        OrderDetail orderDetail = new OrderDetail(idBook, 0, 1);
        try {
            orderService.createOrderDetailCatche(orderDetail);
            showTableOrderDetail();

        } catch (SQLException e) {
            if (e.getMessage().contains("Cannot insert duplicate bookID")) {
                JOptionPane.showMessageDialog(this, "Sách đã tồn tại trong đơn hàng.", "Lỗi",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                e.printStackTrace();
            }
        }
    }

    private void SearchBookButtonActionPerformed(java.awt.event.ActionEvent evt) {
        searchBook(InputSearchBook.getText());
    }

    private void DeleteBookButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int row = TableOrderDetail.getSelectedRow();
        int idBook = (int) TableOrderDetail.getValueAt(row, 0);
        try {
            orderService.deleteOrderDetailCatche(idBook);
            showTableOrderDetail();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void RefreshBookButtonActionPerformed(java.awt.event.ActionEvent evt) {
        showTableOrderDetail();

    }

    private void EditBookButtonActionPerformed(java.awt.event.ActionEvent evt) {

        int row = TableOrderDetail.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select an author to edit.", "No Author Selected",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            int idBook = (int) TableOrderDetail.getValueAt(row, 0);
            editOderDetail = new EditOderDetail(idBook);
            editOderDetail.setVisible(true);
        }
    }

    private void ConfirmButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // using get customer by username(phone)

        String phone = PhoneField.getText();
        try {

            customer = customerService.getCustomerByUsername(phone);
            if (customer == null) {
                JOptionPane.showMessageDialog(this, "Không tìm thấy khách hàng", "Lỗi",
                        JOptionPane.ERROR_MESSAGE);

                FirstNameField.setText("");
                LastNameField.setText("");
        
                newOrder.setTotalCost(calculateTotal());
                TotalField.setText(String.valueOf(calculateTotal()));

            } else {
                FirstNameField.setText(customer.getFirstName());
                LastNameField.setText(customer.getLastName());
                System.out.print(calculateTotal());
                Double temp = calculateTotal() * 0.9;
                newOrder.setTotalCost(temp);
                TotalField.setText(String.valueOf(temp));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void CancelOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.print(customer);
    }

    private void SuccesButtonActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            if (customer == null) {
                newOrder.setCustomerID(0); // Correctly setting null now
            } else {
                    newOrder.setCustomerID(customer.getCustomerID());
                         newOrder.setDiscount(10.0);

            }
            newOrder.setEmployeeID(userSession.getUserID());
            newOrder.setStatus(true);
            orderService.createOrder(newOrder); // ActionEvent
            showTableOrderDetail(); // Refresh
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to process the order.", "Database Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBookButton;
    private javax.swing.JButton CancelOrderButton;
    private javax.swing.JButton ConfirmButton;
    private javax.swing.JButton DeleteBookButton;
    private javax.swing.JButton EditBookButton;
    private javax.swing.JTextField FirstNameField;
    private javax.swing.JTextField InputSearchBook;
    private javax.swing.JTextField LastNameField;
    private javax.swing.JLabel LastNameLabel;
    private javax.swing.JTextField PhoneField;
    private javax.swing.JLabel PhoneLabel;
    private javax.swing.JLabel PhoneLabel1;
    private javax.swing.JButton RefreshBookButton;
    private javax.swing.JButton SearchBookButton;
    private javax.swing.JButton SuccesButton;
    private javax.swing.JTable TableBook;
    private javax.swing.JTable TableOrderDetail;
    private javax.swing.JTextField TotalField;
    private javax.swing.JLabel TotalLabel;
    private javax.swing.JScrollPane spTable1;
    private javax.swing.JScrollPane spTable2;
    // End of variables declaration//GEN-END:variables
}
