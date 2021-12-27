package entities;

public class User {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private int phNum;
    private String email;

    public User(String username, String pw) {
        this.username = username;
        this.password = pw;
    }

    public String getUsername() {
        return this.username;
    }

    public void setPassword(String pw) {
        this.password = pw;
    }

    public void setFirstName(String first) {
        this.firstName = first;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastNameName() {
        return this.lastName;
    }

    public void setNum(int num) {
        this.phNum = num;
    }

    public int getPhNum() {
        return this.phNum;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }
}
