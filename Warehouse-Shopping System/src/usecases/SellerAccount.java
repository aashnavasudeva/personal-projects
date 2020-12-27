package usecases;
import entities.*;

import java.util.ArrayList;

public class SellerAccount extends UserAccount {

    public SellerAccount(){}

    public void addSellingItem(String username, String itemID, String itemName, int stock,
                              String colour, String material){
        Item item = new Item(itemID, itemName, stock);
        item.setColour(colour);
        item.setMaterial(material);
        item.setSellerID(username);
        allItems.put(itemID, item);
        seller.get(username).getSelling().add(itemID);
    }

    public void removeSellingItem(String itemID, String username){
        seller.get(username).getSelling().remove(itemID);
        allItems.remove(itemID);
    }

    public void removeComplaint(String username, String complaint) {
        seller.get(username).getComplaintsAgainst().remove(complaint);
        complaints.remove(complaint);
    }

    public void lodgeComplaint(String complaint, String sellerID, String itemID) {
        Complaint comp = new Complaint(complaint, sellerID, "Seller Complaint", itemID);
        complaints.put(comp.getComplaintID(), comp);
    }




}
