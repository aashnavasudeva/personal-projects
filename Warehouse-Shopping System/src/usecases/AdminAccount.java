package usecases;
import entities.*;

public class AdminAccount extends UserAccount {

    public AdminAccount(){}

    public void messageUser(String adminID, String userID, String message){
        if (buyers.containsKey(userID)){
            buyers.get(userID).getMessageReceived().add(message);
            admin.get(adminID).getMessagesSent().add(message);
        }
        else if (seller.containsKey(userID)){
            seller.get(userID).getMessageReceived().add(message);
            admin.get(adminID).getMessagesSent().add(message);
        }
    }

    public void changeAttribute(String itemID, String attributeType, String change){
        if (attributeType.equalsIgnoreCase("material")){
            allItems.get(itemID).setMaterial(change);
        }
        else if (attributeType.equalsIgnoreCase("colour")){
            allItems.get(itemID).setColour(change);
        }
        else if (attributeType.equalsIgnoreCase("item name")){
            allItems.get(itemID).setItemName(change);
        }
        else if (attributeType.equalsIgnoreCase("stock")){
            allItems.get(itemID).setStock(Integer.parseInt(change));
        }
    }

    public void deleteUser(String username){
        allUsers.remove(username);
        buyers.remove(username);
        if (seller.containsKey(username)){
            for (Item item : allItems.values()){
                if (item.getSellerID().equals(username)){
                    allItems.remove(item.getItemID());
                }
            }
            seller.remove(username);
        }
    }




}
