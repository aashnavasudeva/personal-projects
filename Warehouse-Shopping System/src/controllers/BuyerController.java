package controllers;
import usecases.*;

import java.util.ArrayList;
import java.util.HashMap;

public class BuyerController {
    private String username;
    private BuyerAccount buyerAccount;

    public BuyerController(String username, BuyerAccount bA){
        this.username = username;
        this.buyerAccount = bA;
    }

    public void createAccount(String username, String password){
        buyerAccount.addUser("buyer", username, password);
    }

    public void callRemoveFromWL(String itemID){
        if (buyerAccount.getBuyers().get(username).getWishlist().contains(itemID)){
            buyerAccount.removeFromWishlist(this.username, itemID);
        }
    }

    public void callAddToWL(String itemID){
        if (!buyerAccount.getBuyers().get(username).getWishlist().contains(itemID) &&
                buyerAccount.getAllItems().containsKey(itemID)){
            buyerAccount.addToWishlist(this.username, itemID);
        }
    }

    public void callRemoveFromCart(String itemID){
        if (buyerAccount.getAllItems().containsKey(itemID)){
            buyerAccount.removeFromCart(this.username, itemID);
        }
    }

    public void callAddToCart(String itemID, int stock){
        if (buyerAccount.getAllItems().containsKey(itemID)){
            buyerAccount.addToCart(this.username, itemID, stock);
        }
    }

    public void callLodgeComplaint(String complaint, String sellerID, String itemID){
        if (!complaint.equals("") && !sellerID.equals("") && !itemID.equals("") &&
                buyerAccount.getAllItems().containsKey(itemID) && buyerAccount.getSeller().containsKey(sellerID)){
            buyerAccount.lodgeComplaint(complaint, this.username, sellerID, itemID);
        }
    }

    public void callRemoveComplaint(String complaint){
        buyerAccount.removeComplaint(this.username, complaint);
    }

    public void callPlaceOrder(HashMap<String, Integer> items){
        ArrayList<String> orderItems = new ArrayList<>();
        for (String s: items.keySet()){
            if (buyerAccount.canOrder(s, items.get(s))){
                orderItems.add(s);
                int currStock = buyerAccount.getAllItems().get(s).getStock();
                buyerAccount.getAllItems().get(s).setStock(currStock -1);
            }
        }
        if (!orderItems.isEmpty()){
            buyerAccount.placeOrder(this.username, orderItems);
        }
    }

    public void callCancelOrder(String orderID){
        if (!buyerAccount.getAllOrders().get(orderID).getShipped()){
            buyerAccount.cancelOrder(this.username, orderID);
        }
    }



}