package entities;

import java.util.ArrayList;
import java.util.HashMap;

public class Buyer extends User {

    private String address;
    private final ArrayList<String> orders;
    private final ArrayList<String> wishlist;
    private final HashMap<String, Integer> cart;

    /**
     * Constructor for a buyer
     * @param username the username of the buyer
     * @param password the password of the buyer's account
     */
    public Buyer(String username, String password) {
        super(username, password);
        this.orders = new ArrayList<>();
        this.wishlist = new ArrayList<>();
        this.cart = new HashMap<String, Integer>();
    }

    public void setAddress(String address){
        this.address = address;
    }

    public ArrayList<String> getWishlist(){
        return wishlist;
    }

    public ArrayList<String> getOrders(){
        return orders;
    }

    public HashMap<String, Integer> getCart(){
        return cart;
    }


}
