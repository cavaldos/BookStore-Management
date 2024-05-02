package store.view.employee.ui.component;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.List;
import store.Model.Book;
import store.Service.BookService;

public class TableBooks extends javax.swing.JPanel {
        private BookService bookService;
        private DefaultTableModel model;

        public TableBooks() {
                bookService = new BookService();
                initComponents();
                loadBooksIntoTable(); // Gọi sau khi đã khởi tạo components
        }

        private void loadBooksIntoTable() {
                try {
                        List<Book> books = bookService.getAllBooks();
                        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                        model.setRowCount(0); // Xóa dữ liệu bảng hiện có
                        for (Book book : books) {
                                model.addRow(new Object[] {
                                                book.getBookID(),
                                                book.getTitle(),
                                                book.getAuthor(),
                                                book.getPublisher(),
                                                book.getPrice(),
                                                book.getCategory(),
                                                book.getStatus() ? "Active" : "Inactive",
                                                book.getVolume()
                                });
                        }
                } catch (SQLException e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(this, "Error retrieving books from database.", "Error",
                                        JOptionPane.ERROR_MESSAGE);
                }
        }

        @SuppressWarnings("unchecked")
        private void initComponents() {
                jScrollPane1 = new javax.swing.JScrollPane();
                jTable1 = new javax.swing.JTable();

                jTable1.setModel(new javax.swing.table.DefaultTableModel(
                                new Object[][] {
                                                { null, null, null, null },
                                                { null, null, null, null },
                                                { null, null, null, null },
                                                { null, null, null, null }
                                },
                                new String[] {
                                                "Book ID", "Title", "Author", "Publisher", "Price", "Category",
                                                "Status", "Volume"
                                }));
                jScrollPane1.setViewportView(jTable1);

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jScrollPane1,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                776, Short.MAX_VALUE)
                                                                .addContainerGap()));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jScrollPane1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                275,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(14, Short.MAX_VALUE)));
        }

        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JTable jTable1;
}
