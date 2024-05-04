
package store.view.employee.customer;

import store.Service.CustomerService;
import store.Model.Customer;

/**
 *
 * @author bourbon
 */
public class EditCustomer extends javax.swing.JFrame {

    private CustomerService customerService;
    private int customerID;

    public EditCustomer(int customerID) {
        initComponents();
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.customerService = new CustomerService();
        this.customerID = customerID;
        loadCustomerDetails();

    }

    public void loadCustomerDetails() {
        try {
            store.Model.Customer customer = customerService.selectCustomer(customerID);
            if (customer != null) {
                IDField.setText(String.valueOf(customer.getCustomerID()));
                UserNameField.setText(customer.getUserName());
                FirstNameField.setText(customer.getFirstName());
                LastNameField.setText(customer.getLastName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        IDField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        UserNameField = new javax.swing.JTextField();
        username = new javax.swing.JLabel();
        FirstNameField = new javax.swing.JTextField();
        firstname = new javax.swing.JLabel();
        LastNameField = new javax.swing.JTextField();
        lastname = new javax.swing.JLabel();
        CancelButton = new javax.swing.JButton();
        OKButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        IDField.setEditable(false);

        jLabel1.setText("ID Customer");
        jLabel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        username.setText("User Name");
        username.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        firstname.setText("First Name");
        firstname.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        lastname.setText("Last Name");
        lastname.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

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
                                .addGap(104, 104, 104)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(lastname, javax.swing.GroupLayout.PREFERRED_SIZE, 79,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(36, 36, 36)
                                                .addComponent(LastNameField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        197, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(firstname, javax.swing.GroupLayout.PREFERRED_SIZE, 79,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(36, 36, 36)
                                                .addComponent(FirstNameField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        197, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(36, 36, 36)
                                                        .addComponent(UserNameField,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 197,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(36, 36, 36)
                                                        .addComponent(IDField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                197, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(120, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CancelButton)
                                .addGap(27, 27, 27)
                                .addComponent(OKButton)
                                .addGap(116, 116, 116)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(119, 119, 119)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(IDField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(UserNameField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(username))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(FirstNameField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(firstname))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(LastNameField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lastname))
                                .addGap(131, 131, 131)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(CancelButton)
                                        .addComponent(OKButton))
                                .addContainerGap(160, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OKButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_OKButtonActionPerformed
        try {
            Customer customer = new Customer(Integer.parseInt(IDField.getText()), UserNameField.getText(),
                    FirstNameField.getText(), LastNameField.getText());
            customerService.updateCustomer(customer);

            this.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }// GEN-LAST:event_OKButtonActionPerformed

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_CancelButtonActionPerformed

        this.dispose();
    }// GEN-LAST:event_CancelButtonActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelButton;
    private javax.swing.JTextField FirstNameField;
    private javax.swing.JTextField IDField;
    private javax.swing.JTextField LastNameField;
    private javax.swing.JButton OKButton;
    private javax.swing.JTextField UserNameField;
    private javax.swing.JLabel firstname;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lastname;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables
}
