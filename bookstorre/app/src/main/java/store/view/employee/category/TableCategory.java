/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package store.view.employee.category;

import store.Model.Category;
import store.Service.BookService;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JOptionPane;
import java.sql.SQLException;

/**
 *
 * @author bourbon
 */
public class TableCategory extends javax.swing.JPanel {
    private BookService bookService;

    /**
     * Creates new form TableCategory
     */
    public TableCategory() {
        bookService = new BookService();
        initComponents();
        loadCategoryIntoTable();
    }

    private void loadCategoryIntoTable() {
        try {
            DefaultTableModel model = (DefaultTableModel) TableCategory.getModel();
            model.setRowCount(0);
            bookService.getAllCategories().forEach((category) -> {
                model.addRow(new Object[] {
                        category.getCategoryID(),
                        category.getCategoryName(),
                        category.getStatus() ? "Active" : "Inactive"
                });
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void searchCategory() {
        String searchText = InputSearch.getText(); // Directly use the text for case-sensitive search
        DefaultTableModel model = (DefaultTableModel) TableCategory.getModel();
        model.setRowCount(0); // Clear the table first

        try {
            for (Category category : bookService.getAllCategories()) {
                if (category.getCategoryName().toLowerCase().contains(searchText.toLowerCase())) { // Case-insensitive
                                                                                                   // check
                    model.addRow(new Object[] {
                            category.getCategoryID(),
                            category.getCategoryName(),
                            category.getStatus() ? "Active" : "Inactive"
                    });
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TableCategory = new javax.swing.JTable();
        SearchButton = new javax.swing.JButton();
        AddButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        InputSearch = new javax.swing.JTextField();
        EditButton = new javax.swing.JButton();
        RefreshButton = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1250, 750));

        TableCategory.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null },
                        { null, null, null },
                        { null, null, null },
                        { null, null, null }
                },
                new String[] {
                        "Category ID", "Name", "Status"
                }) {
            Class[] types = new Class[] {
                    java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        jScrollPane1.setViewportView(TableCategory);
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(
                (DefaultTableModel) TableCategory.getModel());
        TableCategory.setRowSorter(sorter);

        SearchButton.setText("Search");
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });

        AddButton.setText("Add");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        DeleteButton.setText("Delete ");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        InputSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputSearchActionPerformed(evt);
            }
        });

        EditButton.setText("Edit");
        EditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditButtonActionPerformed(evt);
            }
        });

        RefreshButton.setText("Refresh");
        RefreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(326, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 614,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                false)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout
                                                                .createSequentialGroup()
                                                                .addComponent(InputSearch,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 227,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)
                                                                .addComponent(SearchButton))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                layout.createSequentialGroup()
                                                                        .addComponent(AddButton)
                                                                        .addGap(32, 32, 32)
                                                                        .addComponent(EditButton)
                                                                        .addGap(115, 115, 115)
                                                                        .addComponent(DeleteButton)))
                                                .addGap(139, 139, 139)
                                                .addComponent(RefreshButton)))
                                .addGap(310, 310, 310)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(AddButton)
                                        .addComponent(DeleteButton)
                                        .addComponent(EditButton)
                                        .addComponent(RefreshButton))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(SearchButton)
                                        .addComponent(InputSearch, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(188, Short.MAX_VALUE)));
    }// </editor-fold>//GEN-END:initComponents

    private void RefreshButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_RefreshButtonActionPerformed
        loadCategoryIntoTable();
    }

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void InputSearchActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void EditButtonActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("Search");
        searchCategory();
    }

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = TableCategory.getSelectedRow();
        if (selectedRow >= 0) {
            int categoryID = (int) TableCategory.getValueAt(selectedRow, 0);

            int confirm = JOptionPane.showConfirmDialog(this,
                    "Are you sure you want to delete this author?", "Confirm Deletion",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    bookService.deleteCategory(categoryID);
                    JOptionPane.showMessageDialog(this, "Author has been deleted successfully.",
                            "Deletion Successful", JOptionPane.INFORMATION_MESSAGE);
                    loadCategoryIntoTable();
                } catch (SQLException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error occurred while deleting the author: " + e.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {

            JOptionPane.showMessageDialog(this, "Please select an author to delete.", "No Author Selected",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton EditButton;
    private javax.swing.JTextField InputSearch;
    private javax.swing.JButton RefreshButton;
    private javax.swing.JButton SearchButton;
    private javax.swing.JTable TableCategory;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
