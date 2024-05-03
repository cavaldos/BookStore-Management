package store.Service;

import java.sql.SQLException;
import java.util.List;
import store.Model.User;
// import hashPassword
import store.utils.PasswordHasher;
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
        String hashedPassword = PasswordHasher.hashPassword(password);
        for (User user : users) {
            if (user.getUserName().equals(username) && user.getPassword().equals(hashedPassword) && user.getRole().equals(role)) {
                return true;
            }
        }
        return false;
    }

}
