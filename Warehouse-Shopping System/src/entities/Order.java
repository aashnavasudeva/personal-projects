package entities;

import java.util.ArrayList;

public class Order {
    private String orderID;
    private ArrayList<String> items;
    private String buyerID;
    private int counter;
    private boolean shipped;

    public Order(String buyerID, ArrayList<String> items){
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

    public ArrayList<String> getItems(){
        return items;
    }

    public boolean getShipped(){
        return shipped;
    }
}
