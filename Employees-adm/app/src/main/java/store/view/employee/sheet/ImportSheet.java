
package store.view.employee.sheet;

import java.awt.Color;
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
import store.utils.UserSession;
import store.view.employee.ui.swing.ScrollBar;

public class ImportSheet extends javax.swing.JPanel {
    private BookService bookService;
    private EmployeeService employeeService;
    private UserSession userSession;

    public ImportSheet() {
        initComponents();
        spTable.setVerticalScrollBar(new ScrollBar());
        spTable.getVerticalScrollBar().setBackground(Color.WHITE);
        spTable.getViewport().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        this.userSession = UserSession.getInstance();

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
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImportSheetButton = new javax.swing.JButton();
        spTable = new javax.swing.JScrollPane();
        TableImportBook = new javax.swing.JTable();
        RefreshButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        AddSheetButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

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
        spTable.setViewportView(TableImportBook);

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
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(RefreshButton))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(ImportSheetButton)
                            .addGap(18, 18, 18)
                            .addComponent(DeleteButton)
                            .addGap(18, 18, 18)
                            .addComponent(AddSheetButton))
                        .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, 926, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ImportSheetButton)
                    .addComponent(DeleteButton)
                    .addComponent(AddSheetButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RefreshButton)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(spTable, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void RefreshButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_RefreshButtonActionPerformed
        loadtableImportedBooks();
    }// GEN-LAST:event_RefreshButtonActionPerformed

    private void AddSheetButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_AddSheetButtonActionPerformed
        employeeService.createSheet(userSession.getUserID());
        loadtableImportedBooks();
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
                loadtableImportedBooks();
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
            loadtableImportedBooks();
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
    private javax.swing.JScrollPane spTable;
    // End of variables declaration//GEN-END:variables
}
