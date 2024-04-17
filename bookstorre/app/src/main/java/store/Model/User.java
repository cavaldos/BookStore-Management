package store.Model;

public class User {
    private int userID;
    private String userName;
    private String password;
    private Boolean status;
    private String Firstname;
    private String Lastname;
    private String Role;

    public User() {
    }

    public User(int userID, String userName, String password, Boolean status, String Firstname, String Lastname,
            String Role) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.status = status;
        this.Firstname = Firstname;
        this.Lastname = Lastname;
        this.Role = Role;
    }

    public User(String userName, String password, Boolean status, String Firstname, String Lastname,
            String Role) {

        this.userName = userName;
        this.password = password;
        this.status = status;
        this.Firstname = Firstname;
        this.Lastname = Lastname;
        this.Role = Role;
    }

    // Getters
    public int getUserID() {
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

    public String getFirstName() {
        return Firstname;
    }

    public String getLastName() {
        return Lastname;
    }

    public String getRole() {
        return Role;
    }
    // Setters

    public void setUserID(int userID) {
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

    public void setFirstName(String Firstname) {
        this.Firstname = Firstname;
    }

    public void setLastName(String Lastname) {
        this.Lastname = Lastname;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    // toString
    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", Firstname='" + Firstname + '\'' +
                ", Lastname='" + Lastname + '\'' +
                ", Role='" + Role + '\'' +
                '}';
    }
}
