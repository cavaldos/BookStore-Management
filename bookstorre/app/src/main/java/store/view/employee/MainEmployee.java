
package store.view.employee;

import store.view.employee.book.TableBook;

import store.Run;

import store.view.admin.profile.Profile;
import store.view.employee.author.TableAuthor;
import store.view.employee.category.TableCategory;
import store.view.employee.publisher.TablePublisher;
import store.view.employee.profile.*;
import store.view.employee.order.*;
import store.view.employee.sheet.*;
import store.view.employee.customer.*;
import javax.swing.JOptionPane;
import store.utils.UserSession;

public class MainEmployee extends javax.swing.JFrame {

    private TablePublisher tablePublisherPanel; // Biến cho TablePublisher
    private TableCategory tableCategoryPanel; // Biến cho TableCategory
    private TableAuthor tableAuthorPanel; // Biến cho TableAuthor
    private TableBook tableBookPanel; // Biến cho TableBook
    private Profile Profile; // Biến cho Profile
    private CreateOrder createOrderPanel; // Biến cho CreateOrder
    private ViewOrder viewOrderPanel; // Biến cho ViewOrder
    private ImportSheet importSheetPanel; // Biến cho ImportSheet
    private ViewSheet viewSheetPanel; // Biến cho ViewSheet
    private CustomerTable customerTablePanel; // Biến cho CustomerTable
    private Run run;
    private UserSession userSession;

    public MainEmployee() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.userSession = UserSession.getInstance();

        this.run = Run.getInstance();
        setTitleUser();
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

        Profile = new Profile();
        this.add(Profile);
        Profile.setBounds(260, 80, 1250, 750);

        createOrderPanel = new CreateOrder();
        this.add(createOrderPanel);
        createOrderPanel.setBounds(260, 80, 1250, 750);

        viewOrderPanel = new ViewOrder();
        this.add(viewOrderPanel);
        viewOrderPanel.setBounds(260, 80, 1250, 750);

        importSheetPanel = new ImportSheet();
        this.add(importSheetPanel);
        importSheetPanel.setBounds(260, 80, 1250, 750);

        customerTablePanel = new CustomerTable();
        this.add(customerTablePanel);
        customerTablePanel.setBounds(260, 80, 1250, 750);

        viewSheetPanel = new ViewSheet();
        this.add(viewSheetPanel);
        viewSheetPanel.setBounds(260, 80, 1250, 750);

        hideAllPanels();
        tableBookPanel.setVisible(true);
    }

    public void setTitleUser() {
        TitleUser.setText("Hello, " + userSession.getUsername());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Navbar = new javax.swing.JPanel();
        AuthorButton = new javax.swing.JButton();
        PublisherButton = new javax.swing.JButton();
        BookButton = new javax.swing.JButton();
        CategoryButton = new javax.swing.JButton();
        ViewSheetButton = new javax.swing.JButton();
        ImportSheetButton = new javax.swing.JButton();
        CreateOrderButton = new javax.swing.JButton();
        ViewOrderButton = new javax.swing.JButton();
        CustomerButton = new javax.swing.JButton();
        Header = new javax.swing.JPanel();
        ProfileButton = new javax.swing.JButton();
        SignOutButton = new javax.swing.JButton();
        TitleUser = new javax.swing.JLabel();

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

        ViewSheetButton.setText("View Sheet");
        ViewSheetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewSheetButtonActionPerformed(evt);
            }
        });

        ImportSheetButton.setText("Import Sheet");
        ImportSheetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImportSheetButtonActionPerformed(evt);
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

        CustomerButton.setText("Customer");
        CustomerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomerButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout NavbarLayout = new javax.swing.GroupLayout(Navbar);
        Navbar.setLayout(NavbarLayout);
        NavbarLayout.setHorizontalGroup(
            NavbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NavbarLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(NavbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BookButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ViewSheetButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CategoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AuthorButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PublisherButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ImportSheetButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CreateOrderButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ViewOrderButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CustomerButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        NavbarLayout.setVerticalGroup(
            NavbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NavbarLayout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(BookButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(AuthorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(CategoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PublisherButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ViewSheetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ImportSheetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ViewOrderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CreateOrderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CustomerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );

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

        TitleUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TitleUser.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeaderLayout.createSequentialGroup()
                .addContainerGap(840, Short.MAX_VALUE)
                .addComponent(TitleUser, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(ProfileButton)
                .addGap(18, 18, 18)
                .addComponent(SignOutButton)
                .addGap(20, 20, 20))
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TitleUser, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ProfileButton)
                        .addComponent(SignOutButton)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Navbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Navbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 660, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void hideAllPanels() {
        tableBookPanel.setVisible(false);
        tableAuthorPanel.setVisible(false);
        tableCategoryPanel.setVisible(false);
        tablePublisherPanel.setVisible(false);
        Profile.setVisible(false);
        createOrderPanel.setVisible(false);
        viewOrderPanel.setVisible(false);
        importSheetPanel.setVisible(false);
        viewSheetPanel.setVisible(false);
        customerTablePanel.setVisible(false);

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
            case "Profile":
                Profile.setVisible(true);
                break;
            case "CreateOrder":
                createOrderPanel.setVisible(true);
                break;
            case "ViewOrder":
                viewOrderPanel.setVisible(true);
                break;
            case "ViewSheet":
                viewSheetPanel.setVisible(true);
                break;
            case "ImportSheet":
                importSheetPanel.setVisible(true);
                break;
            case "Customer":
                customerTablePanel.setVisible(true);
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

    private void ViewSheetButtonActionPerformed(java.awt.event.ActionEvent evt) {

        switchPanel("ViewSheet");
    }

    private void ImportSheetButtonActionPerformed(java.awt.event.ActionEvent evt) {

        switchPanel("ImportSheet");
    }

    private void CreateOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {
        switchPanel("CreateOrder");
    }

    private void ViewOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {
        switchPanel("ViewOrder");
    }

    private void ProfileButtonActionPerformed(java.awt.event.ActionEvent evt) {
        switchPanel("Profile");
    }

    private void CustomerButtonActionPerformed(java.awt.event.ActionEvent evt) {
        switchPanel("Customer");
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
    private javax.swing.JButton AuthorButton;
    private javax.swing.JButton BookButton;
    private javax.swing.JButton CategoryButton;
    private javax.swing.JButton CreateOrderButton;
    private javax.swing.JButton CustomerButton;
    private javax.swing.JPanel Header;
    private javax.swing.JButton ImportSheetButton;
    private javax.swing.JPanel Navbar;
    private javax.swing.JButton ProfileButton;
    private javax.swing.JButton PublisherButton;
    private javax.swing.JButton SignOutButton;
    private javax.swing.JLabel TitleUser;
    private javax.swing.JButton ViewOrderButton;
    private javax.swing.JButton ViewSheetButton;
    // End of variables declaration//GEN-END:variables
}
