package entities;

import java.util.ArrayList;
import java.util.Date;

public class Seller extends User{

    private Date contractExp;
    private final ArrayList<String> selling = new ArrayList<>();
    private final ArrayList<String> buyers = new ArrayList<>();
    private final ArrayList<String> complaintsAgainst = new ArrayList<>();
    private final ArrayList<String> messageReceived = new ArrayList<>();
    /**
     * Constructor for a seller
     * @param username the username of the seller
     * @param password the password of the seller's account
     */
    public Seller(String username, String password) {
        super(username, password);
    }

    /**
     * Void method that sets the contract expiration date of the seller
     * @param date the date the contract expires
     */
    public void setContractExp(Date date){
        this.contractExp = date;
    }

    /**
     * Returns the contract expiration date for this seller
     * @return the seller's contract expiration date
     */
    public Date getContractExp(){
        return this.contractExp;
    }

    /**
     * Returns all the item IDs that the seller has registered to sell
     * @return an arraylist containing all item IDs that the seller has registered
     */
    public ArrayList<String> getSelling(){
        return this.selling;
    }

    public ArrayList<String> getBuyers(){
        return this.buyers;
    }

    public ArrayList<String> getComplaintsAgainst(){
        return complaintsAgainst;
    }

    public ArrayList<String> getMessageReceived(){
        return messageReceived;
    }
}
