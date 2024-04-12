package store.Model;

public class User {
    private String userID;
    private String userName;
    private String password;
    private Boolean status;
    private String Firstname;
    private String Lastname;

    public User() {
    }
    public User(String userID, String userName, String password, Boolean status, String Firstname, String Lastname) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.status = status;
        this.Firstname = Firstname;
        this.Lastname = Lastname;
    }

    // Getters
    public String getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getStatus() {
        return status;
    }

    public String getFirstname() {
        return Firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    // Setters

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setFirstname(String Firstname) {
        this.Firstname = Firstname;
    }

    public void setLastname(String Lastname) {
        this.Lastname = Lastname;
    }

}
