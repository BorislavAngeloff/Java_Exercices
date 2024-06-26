import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

//SoftUni just got a new parking lot. It's so fancy,
//it even has online parking validation.
//Except, the online service doesn't work. It can only receive users' data
//but doesn't know what to do with it. Good thing you're on the dev team
//and know how to fix it, right?

//Write a program that validates parking for an online service.
//Users can register to park and unregister to leave.

//The program receives 2 commands:

//"register {username} {licensePlateNumber}":

//The system only supports one car per user at the moment,
//so if a user tries to register another license plate using the same username,
//the system should print: "ERROR: already registered with plate number
//{licensePlateNumber}"

//If the aforementioned checks pass successfully, the plate can be registered,
//so the system should print: "{username} registered {licensePlateNumber} successfully"
//"unregister {username}":

//If the user is not present in the database, the system should print:
//"ERROR: user {username} not found"

//If the aforementioned check passes successfully, the system should print:
//"{username} unregistered successfully"

//After you execute all of the commands, print all the currently registered users
//and their license plates in the format:

//"{username} => {licensePlateNumber}"

//Input

//First line: n - number of commands – integer.

//Next n lines: commands in one of two possible formats:

//Register: "register {username} {licensePlateNumber}"

//Unregister: "unregister {username}"

//The input will always be valid, and you do not need to check it explicitly.

//Example

//Input:
//5
//register John CS1234JS
//register George JAVA123S
//register Andy AB4142CD
//register Jesica VR1223EE
//unregister Andy

//Output:
//John registered CS1234JS successfully
//George registered JAVA123S successfully
//Andy registered AB4142CD successfully
//Jesica registered VR1223EE successfully
//Andy unregistered successfully
//John => CS1234JS
//George => JAVA123S
//Jesica => VR1223EE

public class SoftUniParking {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, String> registeredStudents = new LinkedHashMap<>();

        for (int i = 1; i <= n; i++) {

            String[] data = scanner.nextLine().split("\\s+");
            String command = data[0];

            switch (command) {
                case "register":
                    String studentName = data[1];
                    String plateNumber = data[2];
                    if (registeredStudents.containsKey(studentName)) {
                        System.out.printf("ERROR: already registered with plate number %s%n", plateNumber);
                    } else {
                        registeredStudents.put(studentName, plateNumber);
                        System.out.printf("%s registered %s successfully%n", studentName, plateNumber);
                    }
                    break;
                case "unregister":
                    String userName = data[1];
                    if (!registeredStudents.containsKey(userName)) {
                        System.out.println(String.format("ERROR: user %s not found", userName));
                    } else {
                        registeredStudents.remove(userName);
                        System.out.println(String.format("%s unregistered successfully", userName));
                    }
                    break;
            }
        }

        registeredStudents.entrySet().forEach(entry -> System.out.printf("%s => %s\n", entry.getKey(), entry.getValue()));
    }
}
