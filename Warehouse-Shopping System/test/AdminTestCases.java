import org.junit.Test;
import entities.*;
import usecases.*;
import controllers.*;

public class AdminTestCases {
    UserAccount ua = new UserAccount();
    AdminAccount aa = new AdminAccount();


    @Test
    public void canAddAdmin(){
        aa.addUser("admin", "a", "12345678");
        assert (aa.getAdmin().containsKey("a"));
        assert (aa.getAllUsers().containsKey("a"));
    }

    @Test
    public void canRemoveUser(){
        aa.addUser("admin", "a", "12345678");
        aa.addUser("buyer", "b", "12345678");
        AdminController ac = new AdminController("a", aa);
        assert (aa.getBuyers().containsKey("b"));
        assert (aa.getAllUsers().containsKey("b"));
        ac.callDeleteUser("b");
        assert (!aa.getBuyers().containsKey("b"));
        assert (!aa.getAllUsers().containsKey("b"));
    }

    @Test
    public void canCreateAdAcc(){
        aa.addUser("admin", "a", "12345678");
        AdminController ac = new AdminController("a", aa);
        ac.createAdminAccount("b", "12345678");
        assert (aa.getAdmin().containsKey("b"));
        assert (aa.getAllUsers().containsKey("b"));
    }

    @Test
    public void canMsgSeller(){
        aa.addUser("admin", "a", "12345678");
        AdminController ac = new AdminController("a", aa);
        aa.addUser("seller", "s", "12345678");
        aa.addUser("buyer", "b", "12345678");
        ac.callMessageUser("s", "hi");
        assert (aa.getSeller().get("s").getMessageReceived().contains("hi"));
        assert (aa.getAdmin().get("a").getMessagesSent().contains("hi"));
        ac.callMessageUser("b", "hi2");
        assert (aa.getBuyers().get("b").getMessageReceived().contains("hi2"));
        assert (aa.getAdmin().get("a").getMessagesSent().contains("hi2"));
    }

    @Test
    public void canChangeAtt(){
        aa.addUser("admin", "a", "12345678");
        AdminController ac = new AdminController("a", aa);
        Item i = new Item("a1", "b", 6);
        i.setColour("b");
        i.setMaterial("s");
        aa.getAllItems().put("a1", i);
        ac.callChangeAttribute("a1", "colour", "blue");
        assert (i.getColour().equals("blue"));
        ac.callChangeAttribute("a1", "material", "");
        assert (i.getMaterial().equals("s"));
    }

    @Test
    public void canChangePass(){
        aa.addUser("admin", "a", "12345678");
        AdminController ac = new AdminController("a", aa);
        ac.changePassword("12345678", "asdkajhfsd");
        assert (aa.getAdmin().get("a").getPassword().equals("asdkajhfsd"));
    }
}
