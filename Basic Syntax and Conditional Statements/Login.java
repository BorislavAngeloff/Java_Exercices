import java.util.Scanner;

//You will be given a string representing a username. The password will be that username reversed.
// Until you receive the correct password, print on the console "Incorrect password. Try again.".
// When you receive the correct password, print "User {username} logged in." However, on the fourth try,
// if the password is still not correct, print "User {username} blocked!" and end the program.

//Example:

//Input:
//Acer
//login
//go
//let me in
//recA

//Output:
//Incorrect password. Try again.
//Incorrect password. Try again.
//Incorrect password. Try again.
//User Acer logged in.

public class Login {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();
        String password = "";

        // Generate password
        for (int position = username.length() - 1; position >= 0; position--) {

            password += username.charAt(position);
        }

        int incorrectPasswordCount = 0;
        String enteredPassword = scanner.nextLine();
        while (!enteredPassword.equals(password)) {

            incorrectPasswordCount++;
            if (incorrectPasswordCount == 4) {
                System.out.printf("User %s blocked!", username);
                return;
            }

            System.out.println("Incorrect password. Try again.");
            enteredPassword = scanner.nextLine();
        }

        System.out.printf("User %s logged in.", username);
    }
}
