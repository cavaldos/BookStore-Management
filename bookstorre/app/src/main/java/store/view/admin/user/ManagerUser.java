
package store.view.admin.user;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.util.List;
import java.io.IOException;

import store.Model.User;
import store.Service.UserService;

public class ManagerUser extends javax.swing.JPanel {
    private UserService userService;
    private AddUser addUser;
    private EditUser editUser;

    public ManagerUser() {
        initComponents();
        userService = new UserService();

        addUser = new AddUser();
        loadUser();
    }

    private void loadUser() {
        try {
            List<User> users = userService.getAllUsers();
            DefaultTableModel model = (DefaultTableModel) UserTable.getModel();
            model.setRowCount(0);
            for (User user : users) {
                model.addRow(new Object[] { user.getUserID(), user.getUserName(), user.getFirstName(),
                        user.getLastName(), user.getPassword(), user.getStatus() ? "Active" : "Inactive",
                        user.getRole() });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void SearchUser(String input) {
        try {
            List<User> users = userService.getAllUsers();
            DefaultTableModel model = (DefaultTableModel) UserTable.getModel();
            model.setRowCount(0);
            for (User user : users) {
                if (user.getUserName().contains(input) || user.getFirstName().contains(input)
                        || user.getLastName().contains(input) || user.getRole().contains(input)) {
                    model.addRow(new Object[] { user.getUserID(), user.getUserName(), user.getFirstName(),
                            user.getLastName(), user.getPassword(), user.getStatus() ? "Active" : "Inactive",
                            user.getRole() });
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
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        EditButton = new javax.swing.JButton();
        AddButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        SearchButton = new javax.swing.JButton();
        Input = new javax.swing.JTextField();
        RefreshButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        UserTable = new javax.swing.JTable();

        setBackground(new java.awt.Color(204, 204, 204));

        EditButton.setText("Edit");
        EditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditButtonActionPerformed(evt);
            }
        });

        AddButton.setText("Add");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        DeleteButton.setText("Delete");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        SearchButton.setText("Search");
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });

        RefreshButton.setText("Refresh");
        RefreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshButtonActionPerformed(evt);
            }
        });

        UserTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null }
                },
                new String[] {
                        "userID", "user name", "first name", "last name", "password", "status", "role"
                }) {
            Class[] types = new Class[] {
                    java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class,
                    java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        jScrollPane1.setViewportView(UserTable);

        // sort
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(
                (DefaultTableModel) UserTable.getModel());
        UserTable.setRowSorter(sorter);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
                .createSequentialGroup().addGap(222, 222, 222)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup().addComponent(AddButton).addGap(29, 29, 29)
                                .addComponent(EditButton))
                        .addComponent(Input, javax.swing.GroupLayout.PREFERRED_SIZE, 290,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(SearchButton)
                                .addGroup(layout.createSequentialGroup().addComponent(DeleteButton)
                                        .addGap(230, 230, 230).addComponent(RefreshButton)))
                .addContainerGap(332, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                        layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1062,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                layout.createSequentialGroup().addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(AddButton).addComponent(EditButton).addComponent(DeleteButton)
                                .addComponent(RefreshButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(SearchButton).addComponent(Input, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35).addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(69, Short.MAX_VALUE)));
    }// </editor-fold>//GEN-END:initComponents

    private void EditButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int row = UserTable.getSelectedRow();
        if (row >= 0) {
            int id = (int) UserTable.getValueAt(row, 0);
            try {

                editUser = new EditUser(id);
                editUser.setVisible(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error editing user: " + e.getMessage(), "Error",
                        JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "You must select a user", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {
        addUser.setVisible(true);
    }

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int row = UserTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "You must select a user", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            int id = (int) UserTable.getValueAt(row, 0);
            int confirm = JOptionPane.showConfirmDialog(this,
                    "Are you sure you want to delete this user?", "Confirm Deletion", JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    userService.deleteUser(id);
                    loadUser();
                    JOptionPane.showMessageDialog(this, "User deleted successfully", "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Error deleting user: " + e.getMessage(), "Error",
                            JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }
            }
        }
    }

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_SearchButtonActionPerformed
        String input = Input.getText();
        SearchUser(input);
    }// GEN-LAST:event_SearchButtonActionPerformed

    private void RefreshButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_RefreshButtonActionPerformed
        loadUser();
    }// GEN-LAST:event_RefreshButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton EditButton;
    private javax.swing.JTextField Input;
    private javax.swing.JButton RefreshButton;
    private javax.swing.JButton SearchButton;
    private javax.swing.JTable UserTable;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
