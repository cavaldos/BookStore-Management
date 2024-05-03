package store.Service;

import java.sql.SQLException;
import java.util.List;
import store.Model.User;
import store.Repository.UserDao;

public class UserService {
    private UserDao userDao;

    public UserService() {
        this.userDao = new UserDao();
    }

    public List<User> getAllUsers() throws SQLException, ClassNotFoundException {
        return userDao.getAllUsers();
    }

    public User selectUser(int userID) throws SQLException {
        return userDao.selectUser(userID);
    }

    public void deleteUser(int userID) throws SQLException {
        userDao.deleteUser(userID);
    }

    public void addUser(User user) throws SQLException {
        userDao.addUser(user);
    }

    public void updateUser(User user) throws SQLException {
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            // khong nhap gi ca
            userDao.updateUser(user);
        } else {
            // co nhap
            userDao.updatePassword(user);
        }
    }

    public User getUser(String username) throws SQLException {
        return userDao.selectUserbyname(username);
    }
}
