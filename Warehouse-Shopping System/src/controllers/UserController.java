package controllers;
import gateway.Gateway;
import usecases.*;
import entities.*;

import java.io.IOException;
import java.util.ArrayList;

public class UserController {
    private final BuyerAccount bA = new BuyerAccount();
    private final SellerAccount sA = new SellerAccount();
    private final AdminAccount aA = new AdminAccount();
    private final UserAccount uA = new UserAccount();
    private final Gateway g = new Gateway();

    public boolean login(String username, String password) throws IOException, ClassNotFoundException {
        populateOrdersItemsComplaints();
        populateUserMaps();
        if (bA.getBuyers().containsKey(username)){
            return bA.getBuyers().get(username).getPassword().equals(password);
        }
        else if (sA.getSeller().containsKey(username)){
            return sA.getSeller().get(username).getPassword().equals(password);
        }
        else if (aA.getAdmin().containsKey(username)){
            return aA.getAdmin().get(username).getPassword().equals(password);
        }
        return false;
    }

    public void populateUserMaps() throws IOException, ClassNotFoundException {
        ArrayList<User> users = g.readUsers("./Warehouse-Shopping System/src/users.ser");
        for (User u: users){
            if(u.getClass().getName().equalsIgnoreCase("buyer")){
                bA.getBuyers().put(u.getUsername(), (Buyer) u);
            }
            else if(u.getClass().getName().equalsIgnoreCase("seller")){
                sA.getSeller().put(u.getUsername(), (Seller) u);
            }
            else if(u.getClass().getName().equalsIgnoreCase("admin")){
                aA.getAdmin().put(u.getUsername(), (Admin) u);
            }
            uA.getAllUsers().put(u.getUsername(), u);
        }
    }

    public void populateOrdersItemsComplaints() throws IOException{
        ArrayList<Order> orders = g.readOrders("./Warehouse-Shopping System/src/orders.ser");
        for (Order o: orders){
            uA.getAllOrders().put(o.getOrderID(), o);
        }
        ArrayList<Item> items = g.readItems("./Warehouse-Shopping System/src/items.ser");
        for (Item item: items){
            uA.getAllItems().put(item.getItemID(), item);
        }
        ArrayList<Complaint> comp = g.readComplaints("./Warehouse-Shopping System/src/complaints.ser");
        for (Complaint c: comp){
            uA.getComplaints().put(c.getComplaintID(), c);
        }
    }

    public void logout() throws IOException {
        g.writeToFile("./Warehouse-Shopping System/src/users.ser");
        g.writeToFile("./Warehouse-Shopping System/src/items.ser");
        g.writeToFile("./Warehouse-Shopping System/src/complaints.ser");
        g.writeToFile("./Warehouse-Shopping System/src/orders.ser");
    }
}
