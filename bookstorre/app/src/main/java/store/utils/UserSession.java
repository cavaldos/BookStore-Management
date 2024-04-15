package store.utils;

import java.sql.SQLException;
import java.util.List;
import store.Service.AuthService;


public class UserSession {
    private static UserSession instance;
    private Integer userID;
    private String username;
    private String firstname;
    private String lastname;
    private String userRole; 
    private String password;


    
    private UserSession(String username, String userRole) {
        this.username = username;
        this.userRole = userRole;
    }

    public static UserSession getInstance(String username, String userRole) {
        if (instance == null) {
            instance = new UserSession(username, userRole);
        }
        return instance;
    }

    public String getUsername() {
        return username;
    }

    public String getUserRole() {
        return userRole;
    }

    public void cleanUserSession() {
        username = ""; // hoặc null
        userRole = ""; // hoặc null
        instance = null;
    }
}
