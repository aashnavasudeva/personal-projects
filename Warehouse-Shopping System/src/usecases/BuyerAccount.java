package usecases;

import entities.*;

import java.util.HashMap;

public class BuyerAccount extends UserAccount {

    public BuyerAccount() {
    }

    public void removeFromWishlist(String username, String itemID) {
        buyers.get(username).getWishlist().remove(itemID);
    }

    public void addToWishlist(String username, String itemID) {
        buyers.get(username).getWishlist().add(itemID);
    }


    public void addToCart(String username, String itemID, int stock) {
        Buyer curr = buyers.get(username);
        curr.getCart().put(itemID, stock);
        curr.getWishlist().remove(itemID);
    }

    public void removeFromCart(String username, String itemID) {
        Buyer curr = buyers.get(username);
        curr.getCart().remove(itemID);
        curr.getWishlist().add(itemID);

    }

    public void removeComplaint(String username, String complaintID) {
        buyers.get(username).getComplaints().remove(complaintID);
        Complaint comp = complaints.get(complaintID);
        seller.get(comp.getComplainAbout()).getComplaintsAgainst().remove(comp.getComplaintID());
        complaints.remove(complaintID);
    }

    public void lodgeComplaint(String complaint, String buyerID, String sellerID, String itemID) {
        Complaint comp = new Complaint(complaint, buyerID, sellerID, itemID);
        complaints.put(comp.getComplaintID(), comp);
        seller.get(sellerID).getComplaintsAgainst().add(comp.getComplaintID());
        buyers.get(buyerID).getComplaints().add(comp.getComplaintID());
    }

    public void placeOrder(String buyerID, HashMap<String, Integer> orderItems) {
        Order curr = new Order(buyerID, orderItems);
        allOrders.put(curr.getOrderID(), curr);
        buyers.get(buyerID).getOrders().add(curr.getOrderID());
    }

    public boolean canOrder(String itemID, int amount) {
        return allItems.get(itemID).getStock() >= amount;
    }

    public void cancelOrder(String buyerID, String orderID) {
        for (String order : allOrders.get(orderID).getItems().keySet()) {
            allItems.get(order).setStock(allItems.get(order).getStock() + allOrders.get(orderID).getItems().get(order));
        }
        allOrders.remove(orderID);
        buyers.get(buyerID).getOrders().remove(orderID);
    }
}
