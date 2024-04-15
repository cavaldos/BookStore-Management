
package store.view.employee.sheet;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import store.Model.Book;
import store.Service.BookService;
import store.Service.EmployeeService;

public class ImportSheet extends javax.swing.JPanel {
    private BookService bookService;
    private EmployeeService employeeService;

    public ImportSheet() {
        initComponents();
        bookService = new BookService();
        employeeService = new EmployeeService();
        loadtableImportedBooks();

    }

    public void loadtableImportedBooks() {
        try {
            List<Book> books = employeeService.getAllBookImporting();
            DefaultTableModel model = (DefaultTableModel) TableImportBook.getModel();
            model.setRowCount(0);
            for (Book book : books) {
                model.addRow(new Object[] { book.getBookID(), book.getTitle(), book.getAuthor(), book.getPublisher(),
                        book.getCategory(), book.getVolume(), book.getPrice(), book.getStatus() });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImportSheetButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableImportBook = new javax.swing.JTable();
        RefreshButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        AddSheetButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));

        ImportSheetButton.setText("Import Sheet");
        ImportSheetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImportSheetButtonActionPerformed(evt);
            }
        });

        TableImportBook.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Book ID", "Title ", "Author", "Publisher", "Category", "Quantity", "Price", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TableImportBook);

        RefreshButton.setText("Refresh");
        RefreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshButtonActionPerformed(evt);
            }
        });

        DeleteButton.setText("Delete");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        AddSheetButton.setText("Add Sheet");
        AddSheetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddSheetButtonActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sheet Importing");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1042, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(128, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ImportSheetButton)
                        .addGap(26, 26, 26)
                        .addComponent(DeleteButton)
                        .addGap(36, 36, 36)
                        .addComponent(RefreshButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AddSheetButton)
                        .addGap(245, 245, 245))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ImportSheetButton)
                    .addComponent(RefreshButton)
                    .addComponent(DeleteButton)
                    .addComponent(AddSheetButton))
                .addGap(44, 44, 44)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void RefreshButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_RefreshButtonActionPerformed
        loadtableImportedBooks();
    }// GEN-LAST:event_RefreshButtonActionPerformed

    private void AddSheetButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_AddSheetButtonActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_AddSheetButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_DeleteButtonActionPerformed
        try {
            employeeService.deleteSheetImporting();
            loadtableImportedBooks();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }// GEN-LAST:event_DeleteButtonActionPerformed

    private void importBooksFromCSV(java.io.File selectedFile) throws SQLException {

        try (BufferedReader br = new BufferedReader(new FileReader(selectedFile))) {
            String line;
            br.readLine(); // Skip the header if present
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",", -1);
                if (values.length != 6) {
                    JOptionPane.showMessageDialog(this, "Each line must have exactly 6 values separated by commas.",
                            "Format Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                double price = Double.parseDouble(values[1].trim());

                // Create a new Book object with the extracted data
                Book newBook = new Book(
                        values[0].trim(),
                        values[3].trim(),
                        values[5].trim(),
                        price,
                        values[4].trim(),
                        true, // Assuming status is true for all new books
                        Integer.parseInt(values[2].trim()));

                System.out.println(newBook);
                // Insert the new book into the database using bookService
                employeeService.importBookSheet(newBook);
            }
            JOptionPane.showMessageDialog(this, "Books imported successfully!", "Success",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading the CSV file: " + e.getMessage(), "File Reading Error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please check the price and volume columns for correct numeric format.",
                    "Number Format Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void ImportSheetButtonActionPerformed(java.awt.event.ActionEvent evt) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select CSV File");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV Files", "csv");
        fileChooser.setFileFilter(filter);

        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            java.io.File selectedFile = fileChooser.getSelectedFile();
            try {
                importBooksFromCSV(selectedFile);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddSheetButton;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton ImportSheetButton;
    private javax.swing.JButton RefreshButton;
    private javax.swing.JTable TableImportBook;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
