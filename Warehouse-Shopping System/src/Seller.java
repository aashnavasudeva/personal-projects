import java.util.ArrayList;
import java.util.Date;

public class Seller extends User{

    private Date contractExp;
    private final ArrayList<String> selling = new ArrayList<>();
    /**
     * Constructor for a seller
     * @param username the username of the seller
     * @param password the password of the seller's account
     */
    public Seller(String username, String password) {
        super(username, password);
    }

    /**
     * Void method that adds items to the list of items the seller sells
     * @param itemID the item's ID that is to be sold
     */
    public void addItemsToSell(String itemID){
        selling.add(itemID);
    }

    /**
     * Void method that removes an item from the list of items being sold
     * @param itemID the item's ID that is to be removed
     */
    public void deleteItemsToSell(String itemID){
        selling.remove(itemID);
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

}
