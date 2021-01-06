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

    public HashMap<String, User> readFromFile(String path){
        HashMap<String, User> map = null;
        File file = new File(path);
        if (file.length()!=0) {
            try {
                FileInputStream fis = new FileInputStream(path);
                ObjectInputStream ois = new ObjectInputStream(fis);
                map = (HashMap<String, User>) ois.readObject();
                ois.close();
                fis.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            } catch (ClassNotFoundException c) {
                System.out.println("Class not found");
                c.printStackTrace();
            }
            return map;
        }
        else{
            return new HashMap<String, User>();
        }
    }

    public HashMap<String, User> readUsers(String path) throws ClassNotFoundException, IOException {
        HashMap<String, User> map = null;
        File file = new File(path);
            try {
                InputStream file1 = new FileInputStream(path);
                InputStream buffer = new BufferedInputStream(file1);
                ObjectInput input = new ObjectInputStream(buffer);

                // deserialize the StudentManager
                HashMap<String, User> sm = (HashMap<String, User>) input.readObject();
                input.close();
                return sm;
            } catch (IOException ex) {

                return new HashMap<String, User>();
            }
//            try {
//                FileInputStream fis = new FileInputStream(path);
//                ObjectInputStream ois = new ObjectInputStream(fis);
//                map = (HashMap<String, User>) ois.readObject();
//                ois.close();
//                fis.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            } catch (ClassNotFoundException c) {
//                System.out.println("Class not found");
//                c.printStackTrace();
//            }
//            return map;
        }

//        ArrayList<User> users = new ArrayList<>();
//        File file = new File(path);
//        if (file.length() != 0) {
//            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path));
//            Object obj;
//            while (true) {
//                try {
//                    obj = inputStream.readObject();
//                    users.add((User) obj);
//                } catch (EOFException ex) {
//                    break;
//                }
//            }
//            inputStream.close();
//            return users;
//        }
//        else{
//            return new ArrayList<>();
//        }




    public ArrayList<Complaint> readComplaints(String path) throws IOException {
        ArrayList<Complaint> complaints = new ArrayList<>();
        File file = new File(path);
        if (file.length() != 0) {
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
        else{
            return new ArrayList<>();
        }
    }

    public ArrayList<Item> readItems(String path) throws IOException {
        ArrayList<Item> items = new ArrayList<>();
        File file = new File(path);
        if (file.length() != 0) {
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
        else{
            return new ArrayList<>();
        }
    }

    public ArrayList<Order> readOrders(String path) throws IOException {
        ArrayList<Order> orders = new ArrayList<>();
        File file = new File(path);
        if (file.length() != 0) {
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
        else{
            return new ArrayList<>();
        }
    }

    public void writeToFile(String path) throws IOException {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            if (path.contains("user")) {
                outputStream.writeObject(userAccount.getAllUsers());
                outputStream.close();
            }
            else if (path.contains("item")) {
                outputStream.writeObject(userAccount.getAllItems());
                outputStream.close();
            }
            else if (path.contains("complaint")) {
                outputStream.writeObject(userAccount.getComplaints());
                outputStream.close();
            }
            else if (path.contains("order")) {
                outputStream.writeObject(userAccount.getAllOrders());
                outputStream.close();
            }
            fileOutputStream.close();
        }catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }





}
