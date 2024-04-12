package store.Service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import store.Repository.UserDao;

public class AdminService {
    private UserDao userDao;

    public AdminService() {
        this.userDao = new UserDao();
    }

    public boolean selectUser(int userID) throws SQLException {
        return userDao.selectUser(userID);
    }

}
    