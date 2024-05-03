package store.view.auth;

import store.utils.UserSession;
import javax.swing.*;
import java.awt.*;

public class SignIn extends JPanel {
        private JButton signinButton;
        private JLabel usernameLabel, passwordLabel, signinLabel;
        private JTextField usernameTextField;
        private JPasswordField passwordField;
        private JComboBox<String> roleComboBox;

        public SignIn() {
                initializeComponents();
                layoutComponents();
                this.setVisible(true);
        }

        private void initializeComponents() {
                // Set up the components
                signinButton = new JButton("SIGN IN");
                signinButton.addActionListener(e -> signinButtonActionPerformed());

                signinLabel = new JLabel("SIGN IN", SwingConstants.CENTER);
                signinLabel.setFont(new Font("Arial", Font.BOLD, 24));

                usernameLabel = new JLabel("Username");
                usernameLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                passwordLabel = new JLabel("Password");
                passwordLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                usernameTextField = new JTextField(15);
                passwordField = new JPasswordField(15);

                roleComboBox = new JComboBox<>(new String[] { "admin", "employee" });
                roleComboBox.addActionListener(e -> roleComboBoxActionPerformed());

                customizeComponents();
        }

        private void customizeComponents() {
                // Customizing components
                Font labelFont = new Font("Arial", Font.BOLD, 14);
                Color backgroundColor = new Color(230, 240, 250);
                Color buttonColor = new Color(100, 149, 237);

                this.setBackground(backgroundColor);

                usernameLabel.setFont(labelFont);
                passwordLabel.setFont(labelFont);

                usernameTextField.setFont(labelFont);
                passwordField.setFont(labelFont);

                signinButton.setBackground(buttonColor);
                signinButton.setForeground(Color.WHITE);
                signinButton.setFont(labelFont);
        }

        private void layoutComponents() {
                // Layout using GridBagLayout
                setLayout(new GridBagLayout());
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.insets = new Insets(10, 10, 10, 10);
                gbc.gridx = 0;
                gbc.gridy = 0;

                gbc.gridwidth = 2;
                this.add(signinLabel, gbc);

                gbc.gridwidth = 1;
                gbc.gridy++;
                this.add(usernameLabel, gbc);
                gbc.gridx = 1;
                this.add(usernameTextField, gbc);

                gbc.gridx = 0;
                gbc.gridy++;
                this.add(passwordLabel, gbc);
                gbc.gridx = 1;
                this.add(passwordField, gbc);

                gbc.gridx = 0;
                gbc.gridy++;
                this.add(roleComboBox, gbc);

                gbc.gridx = 0;
                gbc.gridy++;
                gbc.gridwidth = 2;
                this.add(signinButton, gbc);
        }

        private void signinButtonActionPerformed() {
                UserSession userSession = UserSession.getInstance();
                try {
                        if (userSession.authenticateUser(usernameTextField.getText(),
                                        new String(passwordField.getPassword()),
                                        roleComboBox.getSelectedItem().toString())) {
                                System.out.println("Login successful");
                                // run some kind of success operation
                        } else {
                                JOptionPane.showMessageDialog(this, "Login failed. Please check username and password.",
                                                "Login Error", JOptionPane.ERROR_MESSAGE);
                        }
                } catch (Exception e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(this, "An error occurred during login: " + e.getMessage(),
                                        "Login Error", JOptionPane.ERROR_MESSAGE);
                }
        }

        private void roleComboBoxActionPerformed() {
                // Handle role combo box action if needed
        }

        public static void main(String[] args) {
                JFrame frame = new JFrame("Login");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(400, 300);
                frame.setLocationRelativeTo(null);
                frame.add(new SignIn());
                frame.setVisible(true);
        }
}