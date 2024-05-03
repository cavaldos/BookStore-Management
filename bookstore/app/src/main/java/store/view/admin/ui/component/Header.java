package store.view.admin.ui.component;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import store.Run;
import javax.swing.JOptionPane;
import store.view.admin.profile.Profile;

public class Header extends javax.swing.JPanel {

        private Run run;

        public Header() {
                initComponents();
                setOpaque(false);
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

                jPanel1 = new javax.swing.JPanel();
                LogoutButton = new store.view.admin.ui.swing.buttonBasic();
                ViewProfileButton = new store.view.admin.ui.swing.buttonBasic();

                setBackground(new java.awt.Color(0, 204, 204));

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGap(0, 0, Short.MAX_VALUE));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGap(0, 51, Short.MAX_VALUE));

                LogoutButton.setBackground(new java.awt.Color(0, 204, 204));
                LogoutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logout.png"))); // NOI18N
                LogoutButton.setText("Logout");
                LogoutButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                LogoutButtonActionPerformed(evt);
                        }
                });

                ViewProfileButton.setBackground(new java.awt.Color(0, 204, 204));
                ViewProfileButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/profile.png"))); // NOI18N
                ViewProfileButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                ViewProfileButtonActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                                .createSequentialGroup()
                                                                .addContainerGap(407, Short.MAX_VALUE)
                                                                .addComponent(ViewProfileButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(LogoutButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap()));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                                .createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(ViewProfileButton,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(LogoutButton,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                37,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jPanel1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)));
        }// </editor-fold>//GEN-END:initComponents

        private void ViewProfileButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_ViewProfileButtonActionPerformed
                Profile profile = new Profile();
                JFrame frame = new JFrame("User Profile");


                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.getContentPane().add(profile);
                frame.pack();
                frame.setVisible(true);
        }// GEN-LAST:event_ViewProfileButtonActionPerformed

        /**
         * @param evt
         */
        private void LogoutButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_buttonBasic1ActionPerformed
                int confirmed = JOptionPane.showConfirmDialog(this,
                                "Bạn có chắc chắn muốn đăng xuất không?", "Xác nhận đăng xuất",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE);

                // Kiểm tra xem người dùng có chọn "Yes" không
                if (confirmed == JOptionPane.YES_OPTION) {
                        this.run.getInstance().logout(); // Thực hiện đăng xuất nếu người dùng xác nhận
                }
        }// GEN-LAST:event_buttonBasic1ActionPerformed

        @Override
        protected void paintComponent(Graphics grphcs) {
                Graphics2D g2 = (Graphics2D) grphcs;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
                g2.fillRect(0, 0, 25, getHeight());
                g2.fillRect(getWidth() - 25, getHeight() - 25, getWidth(), getHeight());
                super.paintComponent(grphcs);
        }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private store.view.admin.ui.swing.buttonBasic LogoutButton;
        private store.view.admin.ui.swing.buttonBasic ViewProfileButton;
        private javax.swing.JPanel jPanel1;
        // End of variables declaration//GEN-END:variables
}
