
package store.view.employee;

import store.view.employee.book.TableBook;
import store.view.employee.author.TableAuthor;
import store.view.employee.category.TableCategory;
import store.view.employee.publisher.TablePublisher;

public class MainEmployee extends javax.swing.JFrame {

    private TablePublisher tablePublisherPanel; // Biến cho TablePublisher
    private TableCategory tableCategoryPanel; // Biến cho TableCategory
    private TableAuthor tableAuthorPanel; // Biến cho TableAuthor
    private TableBook tableBookPanel; // Biến cho TableBook

    public MainEmployee() {
        initComponents();
        this.setLocationRelativeTo(null);

        tableBookPanel = new TableBook();
        this.add(tableBookPanel);
        tableBookPanel.setBounds(260, 80, 1250, 750);

        tableAuthorPanel = new TableAuthor();
        this.add(tableAuthorPanel);
        tableAuthorPanel.setBounds(260, 80, 1250, 750);

        tableCategoryPanel = new TableCategory();
        this.add(tableCategoryPanel);
        tableCategoryPanel.setBounds(260, 80, 1250, 750);

        tablePublisherPanel = new TablePublisher();
        this.add(tablePublisherPanel);
        tablePublisherPanel.setBounds(260, 80, 1250, 750);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Navbar = new javax.swing.JPanel();
        AuthorButton = new javax.swing.JButton();
        PublisherButton = new javax.swing.JButton();
        BookButton = new javax.swing.JButton();
        CategoryButton = new javax.swing.JButton();
        CreateSheetButton = new javax.swing.JButton();
        ViewSheetButton = new javax.swing.JButton();
        CreateOrderButton = new javax.swing.JButton();
        ViewOrderButton = new javax.swing.JButton();
        Header = new javax.swing.JPanel();
        ProfileButton = new javax.swing.JButton();
        SignOutButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Navbar.setBackground(new java.awt.Color(204, 204, 204));

        AuthorButton.setText("Author");
        AuthorButton.setPreferredSize(new java.awt.Dimension(50, 23));
        AuthorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AuthorButtonActionPerformed(evt);
            }
        });

        PublisherButton.setText("Publisher");
        PublisherButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PublisherButtonActionPerformed(evt);
            }
        });

        BookButton.setText("Book");
        BookButton.setPreferredSize(new java.awt.Dimension(50, 23));
        BookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BookButtonActionPerformed(evt);
            }
        });

        CategoryButton.setText("Category");
        CategoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CategoryButtonActionPerformed(evt);
            }
        });

        CreateSheetButton.setText("Create Sheet");
        CreateSheetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateSheetButtonActionPerformed(evt);
            }
        });

        ViewSheetButton.setText("View Sheet");
        ViewSheetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewSheetButtonActionPerformed(evt);
            }
        });

        CreateOrderButton.setText("Create Order");
        CreateOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateOrderButtonActionPerformed(evt);
            }
        });

        ViewOrderButton.setText("View Order");
        ViewOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewOrderButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout NavbarLayout = new javax.swing.GroupLayout(Navbar);
        Navbar.setLayout(NavbarLayout);
        NavbarLayout.setHorizontalGroup(
                NavbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(NavbarLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(NavbarLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(BookButton, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(CreateSheetButton, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(CategoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 211,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(AuthorButton, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(PublisherButton, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ViewSheetButton, javax.swing.GroupLayout.Alignment.TRAILING,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(CreateOrderButton, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ViewOrderButton, javax.swing.GroupLayout.Alignment.TRAILING,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(23, Short.MAX_VALUE)));
        NavbarLayout.setVerticalGroup(
                NavbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(NavbarLayout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(BookButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(AuthorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(CategoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(PublisherButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(CreateSheetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ViewSheetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CreateOrderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ViewOrderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(155, Short.MAX_VALUE)));

        Header.setBackground(new java.awt.Color(153, 153, 153));

        ProfileButton.setText("Profile");
        ProfileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProfileButtonActionPerformed(evt);
            }
        });

        SignOutButton.setText("Sign Out");
        SignOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignOutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
                HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeaderLayout.createSequentialGroup()
                                .addContainerGap(1051, Short.MAX_VALUE)
                                .addComponent(ProfileButton)
                                .addGap(18, 18, 18)
                                .addComponent(SignOutButton)
                                .addGap(20, 20, 20)));
        HeaderLayout.setVerticalGroup(
                HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(HeaderLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(ProfileButton)
                                        .addComponent(SignOutButton))
                                .addContainerGap(25, Short.MAX_VALUE)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(Navbar, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Header, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Navbar, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(Header, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void hideAllPanels() {
        tableBookPanel.setVisible(false);
        tableAuthorPanel.setVisible(false);
        tableCategoryPanel.setVisible(false);
        tablePublisherPanel.setVisible(false);
    }

    private void switchPanel(String panelName) {
        hideAllPanels();
        switch (panelName) {
            case "Book":
                tableBookPanel.setVisible(true);
                break;
            case "Author":
                tableAuthorPanel.setVisible(true);
                break;
            case "Category":
                tableCategoryPanel.setVisible(true);
                break;
            case "Publisher":
                tablePublisherPanel.setVisible(true);
                break;
            default:
                break;
        }
    }

    private void BookButtonActionPerformed(java.awt.event.ActionEvent evt) {
        switchPanel("Book");
    }

    private void AuthorButtonActionPerformed(java.awt.event.ActionEvent evt) {
        switchPanel("Author");
    }

    private void CategoryButtonActionPerformed(java.awt.event.ActionEvent evt) {
        switchPanel("Category");
    }

    private void PublisherButtonActionPerformed(java.awt.event.ActionEvent evt) {
        switchPanel("Publisher");
    }

    private void CreateSheetButtonActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("CreateSheetButtonActionPerformed");
    }

    private void ViewSheetButtonActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("ViewSheetButtonActionPerformed");
    }

    private void CreateOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("CreateOrderButtonActionPerformed");
    }

    private void ViewOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("ViewOrderButtonActionPerformed");
    }

    private void ProfileButtonActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("ProfileButtonActionPerformed");
    }

    private void SignOutButtonActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("SignOutButtonActionPerformed");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainEmployee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AuthorButton;
    private javax.swing.JButton BookButton;
    private javax.swing.JButton CategoryButton;
    private javax.swing.JButton CreateOrderButton;
    private javax.swing.JButton CreateSheetButton;
    private javax.swing.JPanel Header;
    private javax.swing.JPanel Navbar;
    private javax.swing.JButton ProfileButton;
    private javax.swing.JButton PublisherButton;
    private javax.swing.JButton SignOutButton;
    private javax.swing.JButton ViewOrderButton;
    private javax.swing.JButton ViewSheetButton;
    // End of variables declaration//GEN-END:variables
}