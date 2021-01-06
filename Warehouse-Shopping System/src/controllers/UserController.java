package controllers;
import gateway.Gateway;
import usecases.*;
import entities.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class UserController {
    private final BuyerAccount bA = new BuyerAccount();
    private final SellerAccount sA = new SellerAccount();
    private final AdminAccount aA = new AdminAccount();
    private final UserAccount uA = new UserAccount();
    private final Gateway g = new Gateway();

    public void mainMenu() throws IOException, ClassNotFoundException {
        System.out.println("1. Create buyer account\n" +
                "2. Login\n" +
                "3. Exit");
        populateUserMaps();
        //populateOrdersItemsComplaints();
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        switch (input) {
            case "1": {
                System.out.println("Enter un");
                String un = sc.nextLine();
                System.out.println("pw");
                String pw = sc.nextLine();
                bA.addUser("buyer", un, pw);
                System.out.println("Account created! Returning to main menu...");
                mainMenu();
                break;
            }
            case "2": {
                System.out.println("Enter un");
                String un = sc.nextLine();
                System.out.println("pw");
                String pw = sc.nextLine();
                if (bA.getBuyers().isEmpty()){
                    System.out.println("no buyers");
                }

                if (login(un, pw)) {
                    System.out.println("Log in successful");
                }
                else{
                    System.out.println("no");
                }
                mainMenu();
                break;
            }
            case "3": {
                logout();
            }
        }
    }

    public boolean login(String username, String password) throws IOException, ClassNotFoundException {
        boolean done = false;
        if (bA.getBuyers().containsKey(username)){
            if (bA.getBuyers().get(username).getPassword().equals(password)){
                done = true;
            }
        }
        else if (sA.getSeller().containsKey(username)){
            if (sA.getSeller().get(username).getPassword().equals(password)){
                done = true;
            }
        }
        else if (aA.getAdmin().containsKey(username)){
            if (aA.getAdmin().get(username).getPassword().equals(password)){
                done = true;
            }
        }
        if (done){
            System.out.println("Done");
            System.out.println(uA.getAllUsers().containsKey(username));
            return true;
        }
        return false;

    }

    public void populateUserMaps() throws IOException, ClassNotFoundException {
        HashMap<String, User> users = g.readUsers("./Warehouse-Shopping System/user.ser");
        System.out.println(users.isEmpty());
        for (User u: users.values()){
            uA.getAllUsers().put(u.getUsername(), u);
        }
//        ArrayList<User> users = g.readUsers("./Warehouse-Shopping System/User.ser");
//        for (User u: users){
//            if(u.getClass().getName().equalsIgnoreCase("buyer")){
//                bA.getBuyers().put(u.getUsername(), (Buyer) u);
//            }
//            else if(u.getClass().getName().equalsIgnoreCase("seller")){
//                sA.getSeller().put(u.getUsername(), (Seller) u);
//            }
//            else if(u.getClass().getName().equalsIgnoreCase("admin")){
//                aA.getAdmin().put(u.getUsername(), (Admin) u);
//            }
//            uA.getAllUsers().put(u.getUsername(), u);
//        }
    }

    public void populateOrdersItemsComplaints() throws IOException{
        ArrayList<Order> orders = g.readOrders("./Warehouse-Shopping System/orders.ser");
        for (Order o: orders){
            uA.getAllOrders().put(o.getOrderID(), o);
        }
        ArrayList<Item> items = g.readItems("./Warehouse-Shopping System/items.ser");
        for (Item item: items){
            uA.getAllItems().put(item.getItemID(), item);
        }
        ArrayList<Complaint> comp = g.readComplaints("./Warehouse-Shopping System/complaints.ser");
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
