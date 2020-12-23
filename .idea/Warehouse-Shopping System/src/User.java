public class User {

    private String username;
    private String password;
    private String name;
    private String email;
    private int phNumber;

    /**
     * Constructor for a general user
     * @param username the username of the user
     * @param password the password of the user's account
     */
    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    /**
     * Sets the password of the user account. Used if password wants to be
     * changed in the future
     * @param password the new password to be assigned
     */
    public void setPassword(String password){
        this.password = password;
    }

    /**
     * Set the name of the user who the account belongs to
     * @param name the name of the user
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Sets the email associated with the user account
     * @param email the email to be assigned
     */
    public void setEmail(String email){
        this.email = email;
    }

    /**
     * Sets the phone number of the user
     * @param num the user's phone number
     */
    public void setPhNumber(int num){
        this.phNumber = num;
    }

    /**
     * Returns the username of the user
     * @return String representing username
     */
    public String getUsername(){
        return this.username;
    }

    /**
     * Returns the password of the user account
     * @return String representing password
     */
    public String getPassword(){
        return this.password;
    }

    /**
     * Returns the user's name
     * @return String representing the user's name
     */
    public String getName(){
        return this.name;
    }

    /**
     * Returns the user's email
     * @return String representing the user's email
     */
    public String getEmail(){
        return this.email;
    }

    /**
     * Returns the user's phone number
     * @return int representing the phone number - doesn't have country code before it
     */
    public int getPhNumber(){
        return this.phNumber;
    }
}
