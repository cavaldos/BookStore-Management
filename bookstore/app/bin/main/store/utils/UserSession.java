package store.utils;

import java.sql.SQLException;
import java.util.List;
import store.Service.AuthService;
import store.Model.User;

import store.Service.UserService;

public class UserSession {
    private static UserSession instance;
    private Integer userID;
    private String username;
    private String role;
    private AuthService authService;

    private UserSession() {

    }

    private UserSession(Integer userID, String username, String role) {
        this.userID = userID;
        this.username = username;
        this.role = role;
    }

    public Boolean authenticateUser(String username, String password, String role) throws SQLException {
        authService = new AuthService();
        UserService userservice = new UserService();
        if (authService.authenticateUser(username, password, role)) {
            User user = userservice.getUser(username);
            this.userID = user.getUserID();
            this.username = user.getUserName();
            this.role = user.getRole();
            return true;
        }
        return false;
    }

    public Boolean checkLogin() {
        return this.userID != null;

    }

    public void logout() {
        this.userID = null;
        this.username = null;
        this.role = null;
    }

    public static UserSession getInstance() {
        if (instance == null) {
            instance = new UserSession();
        }
        return instance;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }

    public Integer getUserID() {
        return userID;
    }

    @Override
    public String toString() {
        return "UserSession{" +
                "username='" + username + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
