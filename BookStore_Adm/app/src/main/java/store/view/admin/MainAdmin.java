
package store.view.admin;

import javax.swing.JFrame;
import store.Run;
import store.view.admin.profile.*;
import store.view.admin.revenue.*;
import store.view.admin.user.*;
import javax.swing.JOptionPane;
import store.utils.UserSession;

public class MainAdmin extends javax.swing.JFrame {
          private Profile Profile;
        private RevenuePanel Revenue;
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

                Revenue = new RevenuePanel();
                this.add(Revenue);
                Revenue.setBounds(260, 80, 1250, 650);

                managerUser = new ManagerUser();
                this.add(managerUser);
                managerUser.setBounds(260, 80, 1250, 650);

                Profile.setVisible(true);
                Revenue.setVisible(false);
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
        gradientX1 = new store.view.admin.gradient.gradientX();
        UpdateInfoButton = new javax.swing.JButton();
        UserButton = new javax.swing.JButton();
        RevenueButton = new javax.swing.JButton();
        SignOutButton = new javax.swing.JButton();
        HeaderPanel = new javax.swing.JPanel();
        TitleUser = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MainAdmin");

        Navbar.setBackground(new java.awt.Color(204, 204, 204));

        gradientX1.setColorEnd(new java.awt.Color(153, 0, 153));

        UpdateInfoButton.setText("Update Info");
        UpdateInfoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateInfoButtonActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout gradientX1Layout = new javax.swing.GroupLayout(gradientX1);
        gradientX1.setLayout(gradientX1Layout);
        gradientX1Layout.setHorizontalGroup(
            gradientX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientX1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gradientX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UpdateInfoButton, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                    .addComponent(UserButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RevenueButton, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                    .addComponent(SignOutButton, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE))
                .addContainerGap())
        );
        gradientX1Layout.setVerticalGroup(
            gradientX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientX1Layout.createSequentialGroup()
                .addGap(258, 258, 258)
                .addComponent(UpdateInfoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(UserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(RevenueButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(SignOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout NavbarLayout = new javax.swing.GroupLayout(Navbar);
        Navbar.setLayout(NavbarLayout);
        NavbarLayout.setHorizontalGroup(
            NavbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gradientX1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        NavbarLayout.setVerticalGroup(
            NavbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gradientX1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        HeaderPanel.setBackground(new java.awt.Color(204, 204, 255));
        HeaderPanel.setToolTipText("Header");

        TitleUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TitleUser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout HeaderPanelLayout = new javax.swing.GroupLayout(HeaderPanel);
        HeaderPanel.setLayout(HeaderPanelLayout);
        HeaderPanelLayout.setHorizontalGroup(
            HeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeaderPanelLayout.createSequentialGroup()
                .addContainerGap(984, Short.MAX_VALUE)
                .addComponent(TitleUser, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101))
        );
        HeaderPanelLayout.setVerticalGroup(
            HeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TitleUser, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
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
                        .addGap(472, 629, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

       
        private void hideAllPanels() {
                managerUser.setVisible(false);
                Revenue.setVisible(false);
                Profile.setVisible(false);
        }

        private void switchPanel(String panelName) {
                hideAllPanels();
                switch (panelName) {
                        case "managerUser":
                                managerUser.setVisible(true);
                                break;
                        case "Revenue":
                                Revenue.setVisible(true);
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
    private store.view.admin.gradient.gradientX gradientX1;
    // End of variables declaration//GEN-END:variables
}
