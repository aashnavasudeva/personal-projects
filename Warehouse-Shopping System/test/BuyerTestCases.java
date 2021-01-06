import org.junit.Test;
import entities.*;
import usecases.*;
import controllers.*;

public class BuyerTestCases {
    UserAccount ua = new UserAccount();
    BuyerAccount ba = new BuyerAccount();

    @Test
    public void canAddBuyer(){
        ua.addUser("buyer", "aash", "aashna01");
        assert (ua.getAllUsers().containsKey("aash"));
        assert (!ua.getAllUsers().containsKey("b"));
        assert (ua.getBuyers().containsKey("aash"));
    }

    @Test
    public void checkCred(){
        ua.addUser("buyer", "aash", "aashna01");
        assert (!ua.checkCredentials("aash", "bb"));
        assert (ua.checkCredentials("aash", "aashna01"));
    }

    @Test
    public void canChPass(){
        ua.addUser("buyer", "aash", "aashna01");
        ua.changePassword("aash", "bb");
        assert (ua.checkCredentials("aash", "bb"));
        assert (!ua.checkCredentials("aash", "aashna01"));
    }

    @Test
    public void canCreateAcc(){
        ba.addUser("buyer", "aash", "aashna01");
        BuyerController bc = new BuyerController("aash", ba);
        bc.createAccount("a", "bb");
        bc.createAccount("b", "bbccddee");
        assert (!ba.getBuyers().containsKey("a"));
        assert (ba.getBuyers().containsKey("b"));
    }

    @Test
    public void canAddAndRemWL(){
        Item i = new Item("a1", "b", 6);
        ba.getAllItems().put(i.getItemID(), i);
        ba.addUser("buyer", "aash", "aashna01");
        BuyerController bc = new BuyerController("aash", ba);
        bc.callAddToWL("a1");
        assert (ba.getBuyers().get("aash").getWishlist().contains("a1"));
        assert (ba.getBuyers().get("aash").getWishlist().size()==1);
        assert (!ba.getBuyers().get("aash").getWishlist().contains("a11"));
        bc.callRemoveFromWL("a1");
        assert (!ba.getBuyers().get("aash").getWishlist().contains("a1"));
        assert (ba.getBuyers().get("aash").getWishlist().size()==0);
    }

    @Test
    public void canAddAndRemCart(){
        Item i = new Item("a1", "b", 6);
        ba.getAllItems().put(i.getItemID(), i);
        ba.addUser("buyer", "aash", "aashna01");
        BuyerController bc = new BuyerController("aash", ba);
        bc.callAddToCart("a1", 5);
        assert (ba.getBuyers().get("aash").getCart().containsKey("a1"));
        assert (ba.getBuyers().get("aash").getCart().get("a1")==5);
        assert (ba.getBuyers().get("aash").getCart().size()==1);
        bc.callRemoveFromCart("a1");
        assert (!ba.getBuyers().get("aash").getCart().containsKey("a1"));
        assert (ba.getBuyers().get("aash").getCart().size()==0);
        assert (ba.getBuyers().get("aash").getWishlist().contains("a1"));
    }

    @Test
    public void canPlaceAndDelOrder(){
        Item i = new Item("a1", "b", 6);
        ba.getAllItems().put(i.getItemID(), i);
        ba.addUser("buyer", "aash", "aashna01");
        ba.addUser("seller", "s", "12345678");
        assert (ba.getSeller().containsKey("s"));
        ba.getSeller().get("s").getSelling().add("a1");
        i.setSellerID("s");
        BuyerController bc = new BuyerController("aash", ba);
        bc.callAddToCart("a1", 5);
        Order order = new Order("aash", ba.getBuyers().get("aash").getCart());
        assert (ba.canOrder("a1", 5));
        bc.callPlaceOrder(ba.getBuyers().get("aash").getCart());
        assert (ba.getAllOrders().containsKey(order.getOrderID()));
        assert (ba.getBuyers().get("aash").getOrders().contains(order.getOrderID()));
        assert (ba.getAllItems().get("a1").getStock()==1);
        bc.callCancelOrder(order.getOrderID());
        assert (!ba.getBuyers().get("aash").getOrders().contains(order.getOrderID()));
        assert (ba.getAllItems().get("a1").getStock()==6);
        assert (!ba.getAllOrders().containsKey(order.getOrderID()));
    }

    @Test
    public void canAddAndRemComp(){
        Item i = new Item("a1", "b", 6);
        ba.getAllItems().put(i.getItemID(), i);
        ba.addUser("buyer", "aash", "aashna01");
        ba.addUser("seller", "s", "12345678");
        ba.getSeller().get("s").getSelling().add("a1");
        i.setSellerID("s");
        BuyerController bc = new BuyerController("aash", ba);
        bc.callLodgeComplaint("no", "s", "a1");
        assert (ba.getBuyers().get("aash").getComplaints().size()==1);
        assert (ba.getSeller().get("s").getComplaintsAgainst().size()==1);
        String o = null;
        for (String orderID: ba.getBuyers().get("aash").getComplaints()){
            o = orderID;
        }
        bc.callRemoveComplaint(o);
        System.out.println(ba.getSeller().get("s").getComplaintsAgainst().size());
        assert (ba.getBuyers().get("aash").getComplaints().size()==0);
        assert (ba.getSeller().get("s").getComplaintsAgainst().size()==0);
    }
}
