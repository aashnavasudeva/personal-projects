package entities;

import java.util.ArrayList;
import java.util.HashMap;

public class Order {
    private String orderID;
    private HashMap<String, Integer> items;
    private String buyerID;
    private int counter;
    private boolean shipped;

    public Order(String buyerID, HashMap<String, Integer> items){
        this.buyerID = buyerID;
        this.items = items;
        this.orderID = String.valueOf(counter);
        counter++;
    }

    public String getOrderID(){
        return orderID;
    }

    public String getBuyerID(){
        return buyerID;
    }

    public HashMap<String, Integer> getItems(){
        return items;
    }

    public boolean getShipped(){
        return shipped;
    }
}
