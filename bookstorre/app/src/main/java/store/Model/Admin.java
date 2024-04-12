package store.Model;

public class Admin extends User {
    private String adminRole;

    public Admin() {
    }

    // Include Firstname and Lastname in the constructor.
    public Admin(String userID, String userName, String password, Boolean status, String Firstname, String Lastname) {
        // Pass all the parameters to the superclass constructor.
        super(userID, userName, password, status, Firstname, Lastname);
        this.adminRole = "admin";
    }

    public String getAdminRole() {
        return adminRole;
    }
}
