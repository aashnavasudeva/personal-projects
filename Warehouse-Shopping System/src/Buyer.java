import java.util.ArrayList;

public class Buyer extends User {

    private String address;
    private final ArrayList<String> orders;
    private final ArrayList<String> wishlist;
    private final ArrayList<String> complaints;

    /**
     * Constructor for a buyer
     * @param username the username of the buyer
     * @param password the password of the buyer's account
     */
    public Buyer(String username, String password) {
        super(username, password);
        this.orders = new ArrayList<>();
        this.complaints = new ArrayList<>();
        this.wishlist = new ArrayList<>();
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void addWishlist(String itemID){
        wishlist.add(itemID);
    }

    public void addOrder(String itemID){
        orders.add(itemID);
        wishlist.remove(itemID);
    }

    public void removeWishlist(String itemID){
        wishlist.remove(itemID);
    }

    public void removeOrders(String itemID){
        if (orders.contains(itemID)){
            orders.remove(itemID);
            wishlist.add(itemID);
        }
    }

    public void addComplaint(String complaintID){
        this.complaints.add(complaintID);
    }

    public void removeComplaint(String complaintID){
        this.complaints.remove(complaintID);
    }
}
