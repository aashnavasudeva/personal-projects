import controllers.UserController;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        UserController uc = new UserController();
        uc.mainMenu();
    }
}
