package controllers;

import usecases.SellerAccount;

public class SellerController {
    private String username;
    private SellerAccount sellerAccount;

    public SellerController(String username, SellerAccount sA){
        this.username = username;
        this.sellerAccount = sA;
    }

    public void callAddSelling(String itemID, String itemName, int stock, String colour, String material){
        sellerAccount.addSellingItem(this.username, itemID, itemName, stock, colour, material);
    }

    public void callRemoveSelling(String itemID){
        if (sellerAccount.getAllItems().containsKey(itemID)){
            sellerAccount.removeSellingItem(itemID, this.username);
        }
    }

    public void callRemoveComplaint(String complaintID){
        if (sellerAccount.getComplaints().containsKey(complaintID)){
            sellerAccount.removeComplaint(this.username, complaintID);
        }
    }

    public void callLodgeComplaint(String complaint, String itemID){
        if (!complaint.equals("") && !itemID.equals("") && sellerAccount.getAllItems().containsKey(itemID)){
            sellerAccount.lodgeComplaint(complaint, this.username, itemID);
        }
    }

    public void createSellerAccount(String username, String password){
        if (password.length() >= 8 && !sellerAccount.getAllUsers().containsKey(username)) {
            sellerAccount.addUser("seller", username, password);
        }
    }

    public void changePassword(String oldPass, String newPass){
        if (!oldPass.equals(newPass) && newPass.length() >= 8){
            sellerAccount.changePassword(this.username, newPass);
        }
    }

    public String viewBuyers(){
        StringBuilder output = new StringBuilder();
        for (String buyerID: sellerAccount.getSeller().get(this.username).getBuyers()){
            output.append("Username: ").append(buyerID).append(" ");
        }
        return output.toString();
    }

    public String viewComplaintsAgainst(){
        StringBuilder output = new StringBuilder();
        for (String complaint: sellerAccount.getSeller().get(this.username).getComplaintsAgainst()){
            output.append("Complaint: ").append(sellerAccount.getComplaints().get(complaint).getComplaintContent());
        }
        return output.toString();
    }
}
