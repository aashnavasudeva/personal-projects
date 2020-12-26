package entities;

import java.util.ArrayList;

public class Item {

    private String itemName;
    private final String itemID;
    private int stock;
    private String sellerID;
    private String colour;
    private String material;
    private final ArrayList<String> usersBought = new ArrayList<>();

    /**
     * Constructor for an item
     * @param itemID the ID of the item
     * @param itemName the product's name
     * @param stock amount of the product in stock
     */
    public Item(String itemID, String itemName, int stock){
        this.itemID = itemID;
        this.itemName = itemName;
        this.stock = stock;
    }

    /**
     * Void method that sets the seller's ID
     * @param seller the seller who is selling the item
     */
    public void setSellerID(String seller){
        this.sellerID = seller;
    }

    /**
     * Void method that sets the colour of the item
     * @param colour the colour of the product
     */
    public void setColour(String colour){
        this.colour = colour;
    }

    /**
     * Void method that sets the amount in stock
     * @param stock int representing the amount in stock
     */
    public void setStock(int stock){
        this.stock = stock;
    }

    /**
     * Void method that sets the item's name
     * @param itemName the item's name
     */
    public void setItemName(String itemName){
        this.itemName = itemName;
    }

    /**
     * Void method that set's the item's material
     * @param material the item's material
     */
    public void setMaterial(String material){
        this.material = material;
    }

    /**
     * Void method that adds buyers to the list of people who have bought the item
     * @param buyerID the buyer's username
     */
    public void addUsersBought(String buyerID){
        this.usersBought.add(buyerID);
    }

    /**
     * Void method that removes buyers to the list of people who have bought the item
     * in case of cancelled orders or returns
     * @param buyerID the buyer's username
     */
    public void removeUsersBought(String buyerID){
        this.usersBought.remove(buyerID);
    }

    /**
     * Returns the item's ID
     * @return the item's ID
     */
    public String getItemID(){
        return this.itemID;
    }

    /**
     * Returns the item's name
     * @return the item's name
     */
    public String getItemName(){
        return this.itemName;
    }

    /**
     * Returns the seller's ID
     * @return the seller's ID
     */
    public String getSellerID(){
        return this.sellerID;
    }

    /**
     * Returns the amount in stock for the item
     * @return the amount in stock for the item
     */
    public int getStock(){
        return this.stock;
    }

    /**
     * Returns the item's colour
     * @return the item's colour
     */
    public String getColour(){
        return this.colour;
    }

    /**
     * Returns the item's material
     * @return the item's material
     */
    public String getMaterial(){
        return this.material;
    }

    /**
     * Returns the list of people who have bought the item
     * @return an arraylist of buyer usernames of those who have bought the item
     */
    public ArrayList<String> getUsersBought(){
        return this.usersBought;
    }
}
