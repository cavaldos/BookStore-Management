package com.raven.form;


import javax.swing.table.TableRowSorter;
import javax.swing.RowFilter;
import com.raven.swing.ScrollBar;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.TableModel;
import javax.swing.table.DefaultTableModel;
import com.raven.event.TableActionCellRender;
import com.raven.event.TableActionCellEditor;
import com.raven.event.TableActionEvent;
import com.raven.dialog.DialogEdit;
import com.raven.dialog.Add;
import javax.swing.JFrame;
import com.raven.data.DatabaseConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class Form_accountAdmin extends javax.swing.JPanel {

    public Form_accountAdmin() {
        initComponents();
        
         searchText1.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
        @Override
        public void insertUpdate(javax.swing.event.DocumentEvent e) {
            filterTable();
        }

        @Override
        public void removeUpdate(javax.swing.event.DocumentEvent e) {
            filterTable();
        }

        @Override
        public void changedUpdate(javax.swing.event.DocumentEvent e) {
            filterTable();
        }
    });
         TableActionEvent event = new TableActionEvent() {
             
            @Override
            public void onEdit(int row) { 
                TableModel model = table.getModel();
    
    // Lấy dữ liệu từ hàng được chọn với kiểm tra null
    String id = model.getValueAt(row, 0) != null ? model.getValueAt(row, 0).toString() : "";
    String userName = model.getValueAt(row, 1) != null ? model.getValueAt(row, 1).toString() : "";
    String password = model.getValueAt(row, 2) != null ? model.getValueAt(row, 2).toString() : "";
    String status = model.getValueAt(row, 3) != null ? model.getValueAt(row, 3).toString() : "";
    String role = model.getValueAt(row, 4) != null ? model.getValueAt(row, 4).toString() : "";
    String firstName = model.getValueAt(row, 5) != null ? model.getValueAt(row, 5).toString() : "";
    String lastName = model.getValueAt(row, 6) != null ? model.getValueAt(row, 6).toString() : "";

    // Khởi tạo và hiển thị EditDialog
    DialogEdit editDialog = new DialogEdit(); // Sửa 'null' thành tham chiếu JFrame nếu cần
    editDialog.setInitialData(id, userName, password, status, role, firstName, lastName);
    editDialog.setVisible(true);

    editDialog.getSaveButton().addActionListener(e -> {
        // Cập nhật dữ liệu vào bảng sử dụng các phương thức getter
        table.getModel().setValueAt(editDialog.getUserNameFieldText(), row, 1);
        table.getModel().setValueAt(editDialog.getPasswordFieldText(), row, 2);
        table.getModel().setValueAt(editDialog.getStatusFieldText(), row, 3);
        table.getModel().setValueAt(editDialog.getRoleFieldText(), row, 4);
        table.getModel().setValueAt(editDialog.getFirstNameFieldText(), row, 5);
        table.getModel().setValueAt(editDialog.getLastNameFieldText(), row, 6);

        // Đóng dialog
        editDialog.dispose();
    });
            }
      
            @Override
            public void onDelete(int row) {
                if (table.isEditing()) {
                    table.getCellEditor().stopCellEditing();
                }
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.removeRow(row);
            }
            
            public void onEnable(int row){
                  TableModel model = table.getModel();
                  
                String currentState = model.getValueAt(row, 7).toString();
                String newState = "Enabled".equals(currentState) ? "Disabled" : "Enabled";
                 model.setValueAt(newState, row, 7);
            }

        
            
            
        };
       table.getColumnModel().getColumn(7).setCellRenderer(new TableActionCellRender());
       table.getColumnModel().getColumn(7).setCellEditor(new TableActionCellEditor(event));
       
         spTable.setVerticalScrollBar(new ScrollBar());
        spTable.getVerticalScrollBar().setBackground(Color.WHITE);
        spTable.getViewport().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        setAllAccount();
    
 
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JLayeredPane();
        panelBorder1 = new com.raven.swing.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        spTable = new javax.swing.JScrollPane();
        table = new com.raven.swing.Table();
        searchText1 = new com.raven.swing.SearchText();
        jLabel5 = new javax.swing.JLabel();
        Add = new javax.swing.JButton();

        panel.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(127, 127, 127));
        jLabel1.setText("Admin account");

        spTable.setBorder(null);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "UserName", "password", "Status", "Role", "Firstname", "Lastname", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        spTable.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(1).setResizable(false);
            table.getColumnModel().getColumn(2).setResizable(false);
            table.getColumnModel().getColumn(3).setResizable(false);
            table.getColumnModel().getColumn(4).setResizable(false);
            table.getColumnModel().getColumn(5).setResizable(false);
            table.getColumnModel().getColumn(6).setResizable(false);
        }

        searchText1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchText1ActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/search.png"))); // NOI18N

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                        .addComponent(spTable)
                        .addContainerGap())
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchText1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(searchText1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spTable, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
                .addContainerGap())
        );

        Add.setText("Add");
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(395, 395, 395)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(Add)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
      Add frameText = new Add();
        frameText.setVisible(true);
        frameText.pack();
        frameText.setLocationRelativeTo(null);
        frameText.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_AddActionPerformed

    private void searchText1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchText1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchText1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLayeredPane panel;
    private com.raven.swing.PanelBorder panelBorder1;
    private com.raven.swing.SearchText searchText1;
    private javax.swing.JScrollPane spTable;
    private static com.raven.swing.Table table;
    // End of variables declaration//GEN-END:variables

    public static void AddRowToJTable(Object[] dataRow) {
             DefaultTableModel model = (DefaultTableModel) table.getModel();
    model.insertRow(0, dataRow);
    }
    private void filterTable() {
    String searchText = searchText1.getText().trim();
    DefaultTableModel model = (DefaultTableModel) table.getModel();
    
    // Tạo RowFilter từ từ khóa tìm kiếm
    RowFilter<Object, Object> rowFilter = RowFilter.regexFilter("(?i)" + searchText);
    
    // Tạo TableRowSorter từ RowFilter
    TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
    sorter.setRowFilter(rowFilter);
    
    // Áp dụng TableRowSorter vào bảng
    table.setRowSorter(sorter);
}
        private void setAllAccount() {
    String query = "SELECT * FROM account";
    try (PreparedStatement pst = DatabaseConnection.getInstance().getConnection().prepareStatement(query);
         ResultSet rs = pst.executeQuery()) {
        
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        while (rs.next()) {
            // Thêm dữ liệu vào model của bảng
            model.addRow(new Object[]{
                rs.getString("userID"),
                rs.getString("username"),
                  rs.getString("password"),
                rs.getString("status"),
                rs.getString("role"),
                rs.getString("firstname"),
                rs.getString("lastname")
            });
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

}
