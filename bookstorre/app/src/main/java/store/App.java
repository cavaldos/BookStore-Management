
package store;

import java.sql.SQLException;
import java.util.List;

import store.view.admin.MainAdmin;
import store.view.employee.MainEmployee;
import store.view.MainUI;
import store.Service.UserService;
import store.Model.User;
import store.Service.AuthService;
public class App {
    private List<User> users;

    

    public static void main(String args[]) throws SQLException, ClassNotFoundException {
        // MainAdmin mainUI = new MainAdmin();
        // mainUI.setVisible(true);
        // MainEmployee mainUIss = new MainEmployee();
        // mainUIss.setVisible(true);

        // MainUI mainUI = new MainUI();
        // mainUI.setVisible(true);

        // UserService userService = new UserService();
        // List<User> users = userService.getAllUsers();
        // App app = new App();
        // app.users = users;
        // System.out.println(app.authenticateUser("adminfdsf", "admin", "admin"));

        AuthService authService = new AuthService();

        System.out.println(authService.authenticateUser("employee", "employee", "employee"));
        System.out.println(authService);
    }   

}
