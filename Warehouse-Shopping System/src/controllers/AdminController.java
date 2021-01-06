package controllers;

import entities.Admin;
import entities.Buyer;
import entities.Complaint;
import usecases.AdminAccount;

import java.util.ArrayList;

public class AdminController {
    private String username;
    private AdminAccount adminAccount;

    public AdminController(String username, AdminAccount aA){
        this.username = username;
        adminAccount = aA;
    }

    public void createAdminAccount(String username, String password){
        if (password.length() >= 8 && !adminAccount.getAllUsers().containsKey(username)) {
            adminAccount.addUser("admin", username, password);
        }
    }

    public void callMessageUser(String userID, String message){
        if (adminAccount.getAllUsers().containsKey(userID) && !message.equals("")){
            adminAccount.messageUser(this.username, userID, message);
        }
    }

    public String viewComplaints(){
        StringBuilder output = new StringBuilder();
        Admin admin = adminAccount.getAdmin().get(username);
        for (String compID: admin.getComplaints()){
            Complaint curr = adminAccount.getComplaints().get(compID);
            output.append("Complaint: ").append(curr.getComplaintContent()).append(" ");
        }
        return output.toString();
    }

    public void callChangeAttribute(String itemID, String attribute, String change){
        ArrayList<String> allAttributes = new ArrayList<>();
        allAttributes.add("material");
        allAttributes.add("stock");
        allAttributes.add("colour");
        allAttributes.add("item name");
        if (adminAccount.getAllItems().containsKey(itemID) && allAttributes.contains(attribute) && !change.equals("")){
            adminAccount.changeAttribute(itemID, attribute, change);
        }
    }

    public void callDeleteUser(String username){
        if (adminAccount.getAllUsers().containsKey(username)){
            adminAccount.deleteUser(username);
        }
    }

    public void changePassword(String oldPass, String newPass){
        if (!oldPass.equals(newPass) && newPass.length() >= 8){
            adminAccount.changePassword(this.username, newPass);
        }
    }
}
