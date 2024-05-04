
package store.view.auth;

import store.utils.UserSession;
import javax.swing.JOptionPane;
import store.view.admin.MainAdmin;
import store.view.employee.MainEmployee;
import store.view.MainUI;
import store.Run;

import store.view.admin.user.AddUser;

public class SignIn extends javax.swing.JPanel {
    private Run run;
    private AddUser addUser;

    public SignIn() {
        initComponents();
        this.addUser = new AddUser();
        run = Run.getInstance();
        this.setVisible(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SigninButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        SignLabel = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        PassLabel = new javax.swing.JLabel();
        PasswordField = new javax.swing.JPasswordField();
        jComboBox1 = new javax.swing.JComboBox<String>();
        cheatbutton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        SigninButton.setText("SIGN IN");
        SigninButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SigninButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Username");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        SignLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SignLabel.setText("SIGN IN");

        PassLabel.setText("Password");
        PassLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<String>(new String[] { "admin", "employee" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        cheatbutton.setForeground(new java.awt.Color(255, 255, 255));
        cheatbutton.setText("                       ");
        cheatbutton.setBorder(null);
        cheatbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cheatbuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(cheatbutton)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(166, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(SignLabel, javax.swing.GroupLayout.Alignment.TRAILING,
                                                javax.swing.GroupLayout.PREFERRED_SIZE, 422,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                .createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jComboBox1,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(PassLabel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(SigninButton,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 116,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                        false)
                                                                .addComponent(PasswordField)
                                                                .addComponent(username,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 198,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(65, 65, 65)))
                                .addGap(146, 146, 146)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(SignLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 103,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(username)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(PasswordField)
                                        .addComponent(PassLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(SigninButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130,
                                        Short.MAX_VALUE)
                                .addComponent(cheatbutton)
                                .addGap(15, 15, 15)));
    }// </editor-fold>//GEN-END:initComponents

    private void cheatbuttonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cheatbuttonActionPerformed

        this.addUser.setVisible(true);

    }// GEN-LAST:event_cheatbuttonActionPerformed

    private void SigninButtonActionPerformed(java.awt.event.ActionEvent evt) {
        UserSession userSession = UserSession.getInstance();
        try {
            if (userSession.authenticateUser(username.getText(), PasswordField.getText(),
                    jComboBox1.getSelectedItem().toString())) {
                this.run.run();
            } else {

                JOptionPane.showMessageDialog(this,
                        "Đăng nhập thất bại. Vui lòng kiểm tra lại thông tin tài khoản và mật khẩu.",
                        "Lỗi Đăng Nhập",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Hiển thị JOptionPane thông báo lỗi ngoại lệ
            JOptionPane.showMessageDialog(this,
                    "Có lỗi xảy ra trong quá trình đăng nhập: " + e.getMessage(),
                    "Lỗi Đăng Nhập", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jComboBox1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PassLabel;
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JLabel SignLabel;
    private javax.swing.JButton SigninButton;
    private javax.swing.JButton cheatbutton;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
