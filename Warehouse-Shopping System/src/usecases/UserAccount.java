package usecases;

import entities.*;

import java.util.HashMap;

public class UserAccount {
    protected HashMap<String, Buyer> buyers = new HashMap<>();
    protected HashMap<String, Seller> seller = new HashMap<>();
    protected HashMap<String, Admin> admin = new HashMap<>();
    protected HashMap<String, User> allUsers = new HashMap<>();
    protected HashMap<String, Item> allItems = new HashMap<>();
    protected HashMap<String, Order> allOrders = new HashMap<>();
    protected HashMap<String, Complaint> complaints = new HashMap<>();

    /**
     * Constructor for a Entities.User Account
     */
    public UserAccount(){}

    /**
     * Creates a new account of the desired type (buyer, admin or seller)
     * @param type the type of user account to be created
     * @param username the username of the account
     * @param password the account's password
     */
    public void addUser(String type, String username, String password){
        if (type.equalsIgnoreCase("Entities.Buyer")){
            Buyer b = new Buyer(username, password);
            buyers.put(username, b);
            allUsers.put(username, b);
        }
        else if (type.equalsIgnoreCase("Entities.Seller")){
            Seller s = new Seller(username, password);
            seller.put(username, s);
            allUsers.put(username, s);
        }
        else if (type.equalsIgnoreCase("Entities.Admin")){
            Admin a = new Admin(username, password);
            admin.put(username, a);
            allUsers.put(username, a);
        }
    }

    /**
     * Returns true if the log in credentials are accurate
     * @param username the username entered
     * @param password the password entered
     * @return true iff the username is in the system (the user is registered) and
     * the password matches that of the user account
     */
    public boolean checkCredentials(String username, String password){
        if (allUsers.containsKey(username)){
            return allUsers.get(username).getPassword().equals(password);
        }
        return false;
    }

    /**
     * Void method that changes the password of a user account
     * @param username the username of the user account whose password needs to be changed
     * @param newPass the new password that needs to be set
     */
    public void changePassword(String username, String newPass){
        allUsers.get(username).setPassword(newPass);
    }

    public HashMap<String, Item> getAllItems(){
        return allItems;
    }

    public HashMap<String, Seller> getSeller(){
        return seller;
    }

    public HashMap<String, Buyer> getBuyers(){
        return buyers;
    }

    public HashMap<String, Admin> getAdmin(){
        return admin;
    }

    public HashMap<String, Complaint> getComplaints(){
        return complaints;
    }

    public HashMap<String, Order> getAllOrders(){
        return allOrders;
    }

    public HashMap<String, User> getAllUsers(){
        return allUsers;
    }
}
