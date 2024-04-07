package com.raven.swing;
import javax.swing.*;
import java.awt.GridLayout;


public class DialogEdit extends JDialog {
    private JTextField idField, userNameField, passwordField, statusField, roleField, firstNameField, lastNameField;
    private JButton saveButton;

    public DialogEdit() {
        
        setLayout(new GridLayout(8, 2)); // Cập nhật số dòng tương ứng với số trường mới

        // ID
        add(new JLabel("ID:"));
        idField = new JTextField();
        idField.setEditable(false); // Giả sử ID không được chỉnh sửa
        add(idField);

        // UserName
        add(new JLabel("UserName:"));
        userNameField = new JTextField();
        add(userNameField);

        // Password
        add(new JLabel("Password:"));
        passwordField = new JTextField();
        add(passwordField);

        // Status
        add(new JLabel("Status:"));
        statusField = new JTextField();
        add(statusField);

        // Role
        add(new JLabel("Role:"));
        roleField = new JTextField();
        add(roleField);

        // FirstName
        add(new JLabel("FirstName:"));
        firstNameField = new JTextField();
        add(firstNameField);

        // LastName
        add(new JLabel("LastName:"));
        lastNameField = new JTextField();
        add(lastNameField);

        // Save Button
        saveButton = new JButton("Save");
        add(saveButton);

        setSize(400, 400); // Điều chỉnh kích thước phù hợp
    }

    public void setInitialData(String id, String userName, String password, String status, String role, String firstName, String lastName) {
        idField.setText(id);
        userNameField.setText(userName);
        passwordField.setText(password);
        statusField.setText(status);
        roleField.setText(role);
        firstNameField.setText(firstName);
        lastNameField.setText(lastName);
    }
 public String getIdFieldText() {
        return idField.getText();
    }

    public String getUserNameFieldText() {
        return userNameField.getText();
    }

    public String getPasswordFieldText() {
        return passwordField.getText();
    }

    public String getStatusFieldText() {
        return statusField.getText();
    }

    public String getRoleFieldText() {
        return roleField.getText();
    }

    public String getFirstNameFieldText() {
        return firstNameField.getText();
    }

    public String getLastNameFieldText() {
        return lastNameField.getText();
    }
    // Getters để lấy thông tin từ các trường nhập liệu khi cần
    public JButton getSaveButton() {
        return saveButton;
    }

    // Các phương thức getter khác cho từng trường nếu cần
}
