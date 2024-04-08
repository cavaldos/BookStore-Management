/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package store.view.employee.author;

import store.Service.BookService;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import store.Model.Author;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import store.Model.Book;
import store.Service.BookService;

/**
 *
 * @author bourbon
 */
public class TableAuthor extends javax.swing.JPanel {

    private BookService bookService;

    public TableAuthor() {
        bookService = new BookService();
        initComponents();
        loadAuthorsIntoTable();
    }

    private void loadAuthorsIntoTable() {
        try {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            for (Author author : bookService.getAllAuthors()) {
                model.addRow(new Object[] { author.getAuthorID(), author.getAuthorName(),
                        author.getStatus() ? "Active" : "Inactive"
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void searchAuthor() {
        try {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            for (Author author : bookService.getAllAuthors()) {
                if (author.getAuthorName().contains(InputSearch.getText())) {
                    model.addRow(new Object[] { author.getAuthorID(), author.getAuthorName(),
                            author.getStatus() ? "Active" : "Inactive"
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
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        AddButon = new javax.swing.JButton();
        InputSearch = new javax.swing.JTextField();
        SearchButton = new javax.swing.JButton();
        EditButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        RefreshButton = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null },
                        { null, null, null },
                        { null, null, null },
                        { null, null, null }
                },
                new String[] {
                        "Author ID", "Author Name", "Status"
                }) {
            Class[] types = new Class[] {
                    java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        AddButon.setText("Add Author");
        AddButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButonActionPerformed(evt);
            }
        });

        SearchButton.setText("Search");
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });

        EditButton.setText("Edit");

        DeleteButton.setText("Delete");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
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
                        .addGroup(layout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 595,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(InputSearch,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 240,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(AddButon)
                                                                .addGap(24, 24, 24)
                                                                .addComponent(DeleteButton)))
                                                .addGap(44, 44, 44)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(SearchButton)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(EditButton)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)
                                                                .addComponent(RefreshButton)
                                                                .addGap(32, 32, 32)))))
                                .addContainerGap(85, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(37, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(AddButon)
                                        .addComponent(DeleteButton)
                                        .addComponent(EditButton)
                                        .addComponent(RefreshButton))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(InputSearch, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(SearchButton))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 369,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)));
    }// </editor-fold>//GEN-END:initComponents

    private void RefreshButtonActionPerformed(java.awt.event.ActionEvent evt) {
        loadAuthorsIntoTable();
    }

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {
        searchAuthor();
    }

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_DeleteButtonActionPerformed
        int selectedRow = jTable1.getSelectedRow(); // Get the currently selected row in the table
        if (selectedRow >= 0) { // Ensure that a row is selected
            int authorID = (int) jTable1.getValueAt(selectedRow, 0); // Retrieve the author's ID from the first column

            // Show a confirmation dialog to make sure the user wants to delete the selected
            // author
            int confirm = JOptionPane.showConfirmDialog(this,
                    "Are you sure you want to delete this author?", "Confirm Deletion",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (confirm == JOptionPane.YES_OPTION) { // Check if the user clicked "Yes"
                try {
                    bookService.deleteAuthor(authorID); // Attempt to delete the author using the BookService
                    JOptionPane.showMessageDialog(this, "Author has been deleted successfully.",
                            "Deletion Successful", JOptionPane.INFORMATION_MESSAGE);
                    loadAuthorsIntoTable(); // Reload the authors into the table to reflect the changes
                } catch (SQLException e) { // Handle any SQL exceptions
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error occurred while deleting the author: " + e.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            // If no row is selected, inform the user to select a row
            JOptionPane.showMessageDialog(this, "Please select an author to delete.", "No Author Selected",
                    JOptionPane.WARNING_MESSAGE);
        }
    }// GEN-LAST:event_DeleteButtonActionPerformed

    private void AddButonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_AddButonActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_AddButonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButon;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton EditButton;
    private javax.swing.JTextField InputSearch;
    private javax.swing.JButton RefreshButton;
    private javax.swing.JButton SearchButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
