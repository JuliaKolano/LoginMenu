import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {
    // Possible to run tests separately by clicking on individual tests
    // But all test can't be run at the same time by clicking on the class test
    // TODO: Fix this issue

    private ByteArrayOutputStream outputStream;
    private PrintStream originalOut;

    @BeforeEach
    public void setOutputStream() {
        outputStream = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void CleanOutputStream() {
        System.setOut(originalOut);
    }

    // A test to see if the login method responds accordingly when the user inputs correct account information
    @Test
    public void LoginUserMethodShouldOutputSuccessMessageWhenCredentialsAreCorrect() {
        String input = """
                Plutonic
                yKDBBZ4ap
                """;
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Account.loginUser();

        String output = outputStream.toString();
        assertTrue(output.contains("You have successfully logged in!"));
    }

    // A test to see if the login method responds accordingly to the user inputting a password that is included in
    // the users array, but does not input a matching username
    @Test
    public void LoginUserMethodShouldOutputAFailureMessageWhenUsernameIsWrong() {
        // Need to include both wrong and correct credentials in the input stream
        // otherwise will create an infinite loop
        // (Because the program keeps asking the user for credentials if they get them wrong)
        String input = """
                hfdhgjdfgv
                yKDBBZ4ap
                Plutonic
                yKDBBZ4ap
                """;
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Account.loginUser();

        String output = outputStream.toString();
        assertTrue(output.contains("Invalid username or password. Try again."));
    }

    // A test to see if the login method responds accordingly to the user leaving the username blank
    @Test
    public void LoginUserMethodShouldOutputAFailureMessageWhenUsernameIsNotPresent() {
        // Need to include both wrong and correct credentials in the input stream
        // otherwise will create an infinite loop
        // (Because the program keeps asking the user for credentials if they get them wrong)
        String input = """
                
                Plutonic
                yKDBBZ4ap
                """;
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Account.loginUser();

        String output = outputStream.toString();
        assertTrue(output.contains("You provided no input"));
    }

    // A test to see if the login method responds accordingly to the user inputting a username that is included in
    // the users array, but does not input a matching password
    @Test
    public void LoginUserMethodShouldOutputAFailureMessageWhenPasswordIsWrong() {
        // Need to include both wrong and correct credentials in the input stream
        // otherwise will create an infinite loop
        // (Because the program keeps asking the user for credentials if they get them wrong)
        String input = """
                Plutonic
                fhgdjhgf
                Plutonic
                yKDBBZ4ap
                """;
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Account.loginUser();

        String output = outputStream.toString();
        assertTrue(output.contains("Invalid username or password. Try again"));
    }

    // A test to see if the login method responds accordingly to the user leaving the password blank
    @Test
    public void LoginUserMethodShouldOutputAFailureMessageWhenPasswordIsNotPresent() {
        // Need to include both wrong and correct credentials in the input stream
        // otherwise will create an infinite loop
        // (Because the program keeps asking the user for credentials if they get them wrong)
        String input = """
                Plutonic
                
                Plutonic
                yKDBBZ4ap
                """;
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Account.loginUser();

        String output = outputStream.toString();
        assertTrue(output.contains("Invalid username or password. Try again"));
    }

    // A test to see if the login method responds accordingly to the user inputting a username and password
    // that are not present in the users array
    @Test
    public void LoginUserMethodShouldOutputAFailureMessageWhenUsernameAndPasswordAreWrong() {
        // Need to include both wrong and correct credentials in the input stream
        // otherwise will create an infinite loop
        // (Because the program keeps asking the user for credentials if they get them wrong)
        String input = """
                fdgjhjfvhbdj
                fhgdjhgf
                Plutonic
                yKDBBZ4ap
                """;
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Account.loginUser();

        String output = outputStream.toString();
        assertTrue(output.contains("Invalid username or password. Try again"));
    }

    // A test to see if the exit program method responds in the desired way
    @Test
    public void ExitProgramMethodShouldDisplayAnExitMessage() {
        Account.exitProgram();
        assertEquals("Exiting Program...", outputStream.toString().trim());
    }
}