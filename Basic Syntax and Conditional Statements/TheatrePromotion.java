import java.util.Scanner;
//A theatre is having a ticket sale, but they need a program to calculate the price of a single ticket. If the given age
// does not fit one of the categories, you should print "Error!". You can see the prices in the table below
//Day / Age	0 <= age <= 18	18 < age <= 64	64 < age <= 122
//Weekday	     12$	         18$	         12$
//Weekend	     15$	         20$	         15$
//Holiday	      5$	         12$	         10$

//Input:
//The input comes in two lines. On the first line, you will receive the type of day. On the second – is the age of the person.

//Output:
//Print the ticket price according to the table, or "Error!" if the age is not in the table

//Constraints
//The age will be in the interval [-1000…1000].
//The type of day will always be valid.

//Example

//Input
//Weekday
//42

//Output:
//18$

public class TheatrePromotion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String day = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());

        int price = 0;

        //If-else could be replaced with switch for the string input(type of the day of error)

        if (day.equals("Weekday")) {
            if ((age >= 0 && age <= 18) || (age > 64 && age <= 122)) {
                price = 12;
            } else if (age > 18 && age <= 64) {
                price = 18;
            } else {
                System.out.println("Error!");
            }
        } else if (day.equals("Weekend")) {
            if ((age >= 0 && age <= 18) || (age > 64 && age <= 122)) {
                price = 15;
            } else if (age > 18 && age <= 64) {
                price = 20;
            } else {
                System.out.println("Error!");
            }
        } else if (day.equals("Holiday")) {
            if ((age >= 0 && age <= 18)) {
                price = 5;
            } else if (age > 18 && age <= 64) {
                price = 12;
            } else if (age > 64 && age <= 122) {
                price = 10;
            } else {
                System.out.println("Error!");
            }
        }

        if (price != 0) {
            System.out.printf("%d$", price);
        }
    }
}
