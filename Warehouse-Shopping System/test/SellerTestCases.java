import org.junit.Test;
import entities.*;
import usecases.*;
import controllers.*;

public class SellerTestCases {
    UserAccount ua = new UserAccount();
    SellerAccount sa = new SellerAccount();

    @Test
    public void canAddSeller(){
        sa.addUser("seller", "s", "12345678");
        assert (sa.getAllUsers().containsKey("s"));
        assert (!sa.getAllUsers().containsKey("b"));
        assert (sa.getSeller().containsKey("s"));
    }

    @Test
    public void canAddAndRemSelling(){
        sa.addUser("seller", "s", "12345678");
        SellerController sc = new SellerController("s", sa);
        sc.callAddSelling("a1", "a", 6, "p", "m");
        assert (sa.getSeller().get("s").getSelling().contains("a1"));
        assert (sa.getSeller().get("s").getSelling().size()==1);
        assert (sa.getAllItems().containsKey("a1"));
        sc.callRemoveSelling("a1");
        assert (!sa.getSeller().get("s").getSelling().contains("a1"));
        assert (sa.getSeller().get("s").getSelling().size()==0);
        assert (!sa.getAllItems().containsKey("a1"));
    }

    @Test
    public void canCreateAccount(){
        sa.addUser("seller", "s", "12345678");
        SellerController sc = new SellerController("s", sa);
        sc.createSellerAccount("b", "bb");
        sc.createSellerAccount("a", "bbccddee");
        assert (sa.getSeller().containsKey("a"));
        assert (!sa.getSeller().containsKey("b"));
    }

    @Test
    public void canAddAndRemComp(){
        sa.addUser("seller", "s", "12345678");
        SellerController sc = new SellerController("s", sa);
        sc.callAddSelling("a1", "a", 6, "p", "m");
        assert (sa.getAllItems().containsKey("a1"));
        sc.callLodgeComplaint("c", "a1");
        assert (sa.getSeller().get("s").getComplaints().size()==1);
        assert (sa.getComplaints().size()==1);
        String o = null;
        for (String orderID: sa.getSeller().get("s").getComplaints()){
            o = orderID;
        }
        sc.callRemoveComplaint(o);
        assert (sa.getSeller().get("s").getComplaints().size()==0);
        assert (sa.getComplaints().size()==0);
    }
}
