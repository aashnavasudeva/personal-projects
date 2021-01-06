package entities;

import java.util.ArrayList;

public class Admin extends User{

    private ArrayList<String> messagesSent = new ArrayList<>();

    /**
     * Constructor for an admin user
     * @param username the username of the admin user
     * @param password the password of the admin user's account
     */
    public Admin(String username, String password) {
        super(username, password);
    }

    public ArrayList<String> getMessagesSent(){
        return messagesSent;
    }
}
