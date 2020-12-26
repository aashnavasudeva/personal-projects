package entities;

public class Admin extends User{

    /**
     * Constructor for an admin user
     * @param username the username of the admin user
     * @param password the password of the admin user's account
     */
    public Admin(String username, String password) {
        super(username, password);
    }
}
