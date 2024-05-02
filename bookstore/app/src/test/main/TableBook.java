
package store.view.employee;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import java.sql.SQLException;
import java.util.List;
import store.Model.Book;
import store.Service.BookService;

/**
 *
 * @author bourbon
 */
public class TableBook extends javax.swing.JPanel {
        private BookService bookService;
        private AddBookFrame addBookFrame;

        public TableBook() {
                bookService = new BookService();
                addBookFrame = new AddBookFrame();

                initComponents();

                loadBooksIntoTable();
        }

        private void loadBooksIntoTable() {
                try {
                        List<Book> books = bookService.getAllBooks();
                        DefaultTableModel model = (DefaultTableModel) BookTable.getModel();
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

        private void searchBooks(String searchText) {
                try {
                        List<Book> books = bookService.getAllBooks(); // Lấy tất cả sách
                        DefaultTableModel model = (DefaultTableModel) BookTable.getModel();
                        model.setRowCount(0); // Xóa dữ liệu bảng hiện có

                        // Chuẩn bị regex pattern: Thêm ".*" trước và sau từ khóa để tìm kiếm ký tự bất
                        // kỳ
                        String pattern = ".*" + searchText.toLowerCase() + ".*";

                        // Lọc và thêm dữ liệu sách phù hợp với từ khóa tìm kiếm vào bảng
                        for (Book book : books) {
                                // Sử dụng pattern.matches để kiểm tra
                                if (book.getTitle().toLowerCase().matches(pattern)
                                                || book.getAuthor().toLowerCase().matches(pattern)
                                                || book.getPublisher().toLowerCase().matches(pattern)
                                                || book.getCategory().toLowerCase().matches(pattern)) {

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
                        }
                } catch (SQLException e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(this, "Error retrieving books from database.", "Error",
                                        JOptionPane.ERROR_MESSAGE);
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

                jScrollPane1 = new javax.swing.JScrollPane();
                BookTable = new javax.swing.JTable();
                AddButton = new javax.swing.JButton();
                RefreshButton = new javax.swing.JButton();
                DeleteButton = new javax.swing.JButton();
                EditButton = new javax.swing.JButton();
                InputSearch = new javax.swing.JTextField();
                SearchButton = new javax.swing.JButton();

                BookTable.setModel(new javax.swing.table.DefaultTableModel(
                                new Object[][] {
                                                { null, null, null, null, null, null, null, null },
                                                { null, null, null, null, null, null, null, null },
                                                { null, null, null, null, null, null, null, null },
                                                { null, null, null, null, null, null, null, null }
                                },
                                new String[] {
                                                "Book ID", "Title", "Author", "Publisher", "Price", "Category",
                                                "Status", "Volume"
                                }) {
                        Class[] types = new Class[] {
                                        java.lang.Integer.class, java.lang.String.class, java.lang.String.class,
                                        java.lang.String.class,
                                        java.lang.Double.class, java.lang.String.class, java.lang.String.class,
                                        java.lang.String.class
                        };

                        public Class getColumnClass(int columnIndex) {
                                return types[columnIndex];
                        }
                });
                BookTable.setToolTipText("");
                jScrollPane1.setViewportView(BookTable);

                AddButton.setText("Add Book");
                AddButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                AddButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                AddButtonActionPerformed(evt);
                        }
                });

                RefreshButton.setText("Refresh");
                RefreshButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                RefreshButtonActionPerformed(evt);
                        }
                });

                DeleteButton.setText("Delete book");
                DeleteButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                DeleteButtonActionPerformed(evt);
                        }
                });

                EditButton.setText("Edit book");
                EditButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                EditButtonActionPerformed(evt);
                        }
                });

                InputSearch.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                InputSearchActionPerformed(evt);
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
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 900,
                                                                Short.MAX_VALUE)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGap(15, 15, 15)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(AddButton)
                                                                                                .addGap(47, 47, 47)
                                                                                                .addComponent(DeleteButton))
                                                                                .addComponent(InputSearch,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                258,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(25, 25, 25)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                false)
                                                                                .addComponent(EditButton,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(SearchButton,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(RefreshButton)
                                                                .addGap(82, 82, 82)));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                                .createSequentialGroup()
                                                                .addGap(0, 59, Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(AddButton)
                                                                                .addComponent(DeleteButton)
                                                                                .addComponent(EditButton)
                                                                                .addComponent(RefreshButton))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(InputSearch,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(SearchButton))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jScrollPane1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                565,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)));
        }// </editor-fold>//GEN-END:initComponents

        private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_DeleteButtonActionPerformed
                // TODO add your handling code here:
                int selectedRow = BookTable.getSelectedRow();
                if (selectedRow >= 0) {
                        // Hiển thị hộp thoại xác nhận
                        int confirm = JOptionPane.showConfirmDialog(this,
                                        "Are you sure you want to delete this book?", "Confirm Delete",
                                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                        // Kiểm tra xem người dùng có chọn "Yes" không
                        if (confirm == JOptionPane.YES_OPTION) {
                                Object bookId = BookTable.getValueAt(selectedRow, 0);
                                int bookID = Integer.parseInt(bookId.toString());

                                try {
                                        bookService.deleteBook(bookID);
                                        // Cập nhật model của bảng sau khi xóa
                                        ((DefaultTableModel) BookTable.getModel()).removeRow(selectedRow);

                                        // Hiển thị thông báo
                                        JOptionPane.showMessageDialog(this, "The book has been deleted.",
                                                        "Book Deleted",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                } catch (SQLException e) {
                                        e.printStackTrace();
                                        // Hiển thị thông báo lỗi
                                        JOptionPane.showMessageDialog(this,
                                                        "Error occurred while deleting the book: " + e.getMessage(),
                                                        "Error",
                                                        JOptionPane.ERROR_MESSAGE);
                                }
                        }
                } else {
                        // Không có hàng nào được chọn
                        JOptionPane.showMessageDialog(this, "Please select a book to delete.", "No Book Selected",
                                        JOptionPane.WARNING_MESSAGE);
                }
        }// GEN-LAST:event_DeleteButtonActionPerformed

        private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_SearchButtonActionPerformed
                // TODO add your handling code here:
                String searchText = InputSearch.getText();
                searchBooks(searchText);
        }// GEN-LAST:event_SearchButtonActionPerformed

        private void RefreshButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_RefreshButtonActionPerformed
                // TODO add your handling code here:
        }// GEN-LAST:event_RefreshButtonActionPerformed

        private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {
                // TODO add your handling code here:
                addBookFrame.setVisible(true);

        }

        private void EditButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_EditButtonActionPerformed
                // TODO add your handling code here:
        }

        private void InputSearchActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_InputSearchActionPerformed
                // TODO add your handling code here:
        }// GEN-LAST:event_InputSearchActionPerformed

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton AddButton;
        private javax.swing.JTable BookTable;
        private javax.swing.JButton DeleteButton;
        private javax.swing.JButton EditButton;
        private javax.swing.JTextField InputSearch;
        private javax.swing.JButton RefreshButton;
        private javax.swing.JButton SearchButton;
        private javax.swing.JScrollPane jScrollPane1;
        // End of variables declaration//GEN-END:variables
}
TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>((DefaultTableModel) BookTable.getModel());
        BookTable.setRowSorter(sorter);