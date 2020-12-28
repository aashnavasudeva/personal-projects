package gateway;

import entities.*;
import usecases.UserAccount;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Gateway {
    private UserAccount userAccount = new UserAccount();

    public Gateway() {
    }

    public ArrayList<User> readUsers(String path) throws ClassNotFoundException, IOException {
        ArrayList<User> users = new ArrayList<>();
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path));
        Object obj;
        while (true) {
            try {
                obj = inputStream.readObject();
                users.add((User) obj);
            } catch (EOFException ex) {
                break;
            }
        }
        inputStream.close();
        return users;
    }


    public ArrayList<Complaint> readComplaints(String path) throws IOException {
        ArrayList<Complaint> complaints = new ArrayList<>();
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path));
        Object obj;
        while (true) {
            try {
                obj = inputStream.readObject();
                complaints.add((Complaint) obj);
            } catch (EOFException ex) {
                break;
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        inputStream.close();
        return complaints;
    }

    public ArrayList<Item> readItems(String path) throws IOException {
        ArrayList<Item> items = new ArrayList<>();
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path));
        Object obj;
        while (true) {
            try {
                obj = inputStream.readObject();
                items.add((Item) obj);
            } catch (EOFException ex) {
                break;
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        inputStream.close();
        return items;
    }

    public ArrayList<Order> readOrders(String path) throws IOException {
        ArrayList<Order> orders = new ArrayList<>();
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path));
        Object obj;
        while (true) {
            try {
                obj = inputStream.readObject();
                orders.add((Order) obj);
            } catch (EOFException ex) {
                break;
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        inputStream.close();
        return orders;
    }

    public void writeToFile(String path) throws IOException {
        OutputStream file = new FileOutputStream(path);
        OutputStream buffer = new BufferedOutputStream(file);
        ObjectOutput output = new ObjectOutputStream(buffer);
        if (path.contains("user")){
            for (User user: userAccount.getAllUsers().values()){
                output.writeObject(user);
            }
        }
        else if (path.contains("complaint")){
            for (Complaint c: userAccount.getComplaints().values()){
                output.writeObject(c);
            }
        }
        else if (path.contains("item")){
            for (Item i: userAccount.getAllItems().values()){
                output.writeObject(i);
            }
        }
        else if (path.contains("order")){
            for (Order o: userAccount.getAllOrders().values()){
                output.writeObject(o);
            }
        }
        output.close();
    }





}
