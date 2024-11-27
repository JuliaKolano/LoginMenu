import java.util.Scanner;

public class Account {
// This class handles all the methods provided in the menu options

    // Array storing 3 users' credentials
    private static final String[][] users = {
            {"Plutonic", "yKDBBZ4ap"},
            {"Misdrawn", "HJfJTjdl"},
            {"Zoneless", "password"}
    };
    private final static Scanner scanner = new Scanner(System.in);

    // TODO: Method used to create and add the user to the array
    // A new array would have to be created or a collection used instead
    public static void createUser() {
        System.out.println("Create user not implemented yet.");
    }

    // Method used to log in and authenticate the user
    public static void loginUser() {
        boolean authenticated = false;
        String username = "";
        String password = "";

        System.out.println("\nLogin User: ");

        // Keep asking for credentials until correct
        do {

            try{
                System.out.print("Please input your username: ");
                username = scanner.nextLine();
            } catch (Exception e){
                System.out.println("There was an error with your username.");
            }

            try {
                System.out.print("Please input your password: ");
                password = scanner.nextLine();
            } catch (Exception e){
                System.out.println("There was an error with your password.");
            }

            // Loop through all the users' in the array and see if the username and passwords match
            for (String[] user : users) {
                // Allow username to not be case-sensitive, but enforce it on the password
                if (username.equalsIgnoreCase(user[0]) && password.equals(user[1])) {
                    // Authenticate the user only after both username and password have been obtained to prevent brute-force
                    authenticated = true;
                    System.out.println("\nYou have successfully logged in!");
                    break;
                    // TODO: Could reformat the code to only allow creating and deleting users after authentication
                }
            }

            if (!authenticated) {
                System.out.println("Invalid username or password. Try again.\n");
            }

        } while (!authenticated);
    }

    // TODO: Method used to delete the user and remove them from the array
    public static void deleteUser() {
        System.out.println("Delete user not implemented yet.");
    }

    // Method used to terminate the program
    public static void exitProgram() {
        System.out.println("\nExiting Program...");
    }
}
