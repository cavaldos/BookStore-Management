
package store.view.admin;

import store.Run;
import store.view.admin.profile.*;
import store.view.admin.revenue.*;
import store.view.admin.user.*;
import javax.swing.JOptionPane;
import store.utils.UserSession;

public class MainAdmin extends javax.swing.JFrame {
        private Profile Profile;
        private ManagerUser managerUser;
        private Run run;
        private UserSession userSession;

        public MainAdmin() {
                initComponents();
                this.setLocationRelativeTo(null);
                this.run = Run.getInstance();
                this.userSession = UserSession.getInstance();

                setTitleUser();

                Profile = new Profile();
                this.add(Profile);
                Profile.setBounds(260, 80, 1250, 650);

                managerUser = new ManagerUser();
                this.add(managerUser);
                managerUser.setBounds(260, 80, 1250, 650);

                Profile.setVisible(true);
                managerUser.setVisible(false);

        }

        public void setTitleUser() {
                TitleUser.setText("Hello, " + userSession.getUsername());
        }

        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Navbar = new javax.swing.JPanel();
        UserButton = new javax.swing.JButton();
        RevenueButton = new javax.swing.JButton();
        SignOutButton = new javax.swing.JButton();
        UpdateInfoButton = new javax.swing.JButton();
        HeaderPanel = new javax.swing.JPanel();
        TitleUser = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MainAdmin");

        Navbar.setBackground(new java.awt.Color(204, 204, 204));

        UserButton.setText("User Management");
        UserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserButtonActionPerformed(evt);
            }
        });

        RevenueButton.setText("Revenue");
        RevenueButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RevenueButtonActionPerformed(evt);
            }
        });

        SignOutButton.setText("Sign Out");
        SignOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignOutButtonActionPerformed(evt);
            }
        });

        UpdateInfoButton.setText("Update Info");
        UpdateInfoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateInfoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout NavbarLayout = new javax.swing.GroupLayout(Navbar);
        Navbar.setLayout(NavbarLayout);
        NavbarLayout.setHorizontalGroup(
            NavbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NavbarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(NavbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UserButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RevenueButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                    .addComponent(SignOutButton, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(NavbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(NavbarLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(UpdateInfoButton, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        NavbarLayout.setVerticalGroup(
            NavbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NavbarLayout.createSequentialGroup()
                .addGap(247, 247, 247)
                .addComponent(UserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RevenueButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SignOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(347, Short.MAX_VALUE))
            .addGroup(NavbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(NavbarLayout.createSequentialGroup()
                    .addGap(195, 195, 195)
                    .addComponent(UpdateInfoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(498, Short.MAX_VALUE)))
        );

        HeaderPanel.setBackground(new java.awt.Color(153, 153, 153));
        HeaderPanel.setToolTipText("Header");

        TitleUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TitleUser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout HeaderPanelLayout = new javax.swing.GroupLayout(HeaderPanel);
        HeaderPanel.setLayout(HeaderPanelLayout);
        HeaderPanelLayout.setHorizontalGroup(
            HeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeaderPanelLayout.createSequentialGroup()
                .addContainerGap(1039, Short.MAX_VALUE)
                .addComponent(TitleUser, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        HeaderPanelLayout.setVerticalGroup(
            HeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TitleUser, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Navbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HeaderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Navbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(HeaderPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

        private void hideAllPanels() {
                managerUser.setVisible(false);
                Profile.setVisible(false);
        }

        private void switchPanel(String panelName) {
                hideAllPanels();
                switch (panelName) {
                        case "managerUser":
                                managerUser.setVisible(true);
                                break;
                        case "Revenue":
                             
                                break;
                        case "Profile":
                                Profile.setVisible(true);
                                break;
                        default:
                                break;
                }
        }

        private void UpdateInfoButtonActionPerformed(java.awt.event.ActionEvent evt) {
                switchPanel("Profile");
        }

        private void UserButtonActionPerformed(java.awt.event.ActionEvent evt) {
                switchPanel("managerUser");
        }

        private void RevenueButtonActionPerformed(java.awt.event.ActionEvent evt) {
                switchPanel("Revenue");
        }

        private void SignOutButtonActionPerformed(java.awt.event.ActionEvent evt) {
                // Hiển thị hộp thoại xác nhận đăng xuất
                int confirmed = JOptionPane.showConfirmDialog(this,
                                "Bạn có chắc chắn muốn đăng xuất không?", "Xác nhận đăng xuất",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE);

                // Kiểm tra xem người dùng có chọn "Yes" không
                if (confirmed == JOptionPane.YES_OPTION) {
                        this.run.getInstance().logout(); // Thực hiện đăng xuất nếu người dùng xác nhận
                }

        }

        /**
         * @param args the command line arguments
         */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel HeaderPanel;
    private javax.swing.JPanel Navbar;
    private javax.swing.JButton RevenueButton;
    private javax.swing.JButton SignOutButton;
    private javax.swing.JLabel TitleUser;
    private javax.swing.JButton UpdateInfoButton;
    private javax.swing.JButton UserButton;
    // End of variables declaration//GEN-END:variables
}
