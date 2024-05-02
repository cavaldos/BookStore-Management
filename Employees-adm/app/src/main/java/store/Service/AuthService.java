package store.Service;

import java.sql.SQLException;
import java.util.List;
import store.Model.User;

public class AuthService {

    private List<User> users;// = userService.getAllUsers();
    private UserService userService;

    public AuthService() throws SQLException {
        userService = new UserService();
        loadUsers();
    }

    private void loadUsers() throws SQLException {
        try {
            users = userService.getAllUsers();
        } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();

        }
    }

    public boolean authenticateUser(String username, String password, String role) {
        for (User user : users) {
            if (user.getUserName().equals(username) &&
                    user.getPassword().equals(password) &&
                    user.getRole().equals(role) && user.getStatus()) {
                return true;
            }
        }
        return false;
    }

}
