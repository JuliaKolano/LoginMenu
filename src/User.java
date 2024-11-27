public class User {
// This class will be used in the implementation of the Create User functionality

    private final String username;
    private final String password;

    // Constructor for the user object
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Only getter methods implemented because username and password shouldn't be changed
    // Unless a new menu option gets added, such as 'Edit User'
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
