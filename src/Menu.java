import java.util.Scanner;

public class Menu {
    private static final Scanner scanner = new Scanner(System.in);
    private static byte choice = 0;

    // A method used to display all the menu options
    public static void display() {

        // User Interface
        System.out.println("""
                Login Menu:
                1. Create User
                2. Login User
                3. Delete User
                4. Exit Program
                """);

        // Keep prompting for an option until a valid one is entered
        do {

            try {
                System.out.print("Please choose an option: ");
                choice = scanner.nextByte();

                switch (choice) {
                    case 1:
                        Account.createUser();
                        break;
                    case 2:
                        Account.loginUser();
                        break;
                    case 3:
                        Account.deleteUser();
                        break;
                    case 4:
                        Account.exitProgram();
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.\n");
                }

            } catch (Exception e) {
                System.out.println("Invalid choice. Try again.\n");
            }

            // Clean out the scanner
            scanner.nextLine();

        } while (choice < 1 || choice > 4);
    }
}
