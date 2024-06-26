import java.util.Scanner;

//Multiplication Table

//You will receive an integer as input from the console. Print the 10 times table for this integer.
//Example

//Input: 5

//Output:
//5 X 2 = 10
// 5 X 3 = 15
//5 X 4 = 20
//5 X 5 = 25
//5 X 6 = 30
//5 X 7 = 35
//5 X 8 = 40
//5 X 9 = 45
//5 X 10 = 50

//Print every row of the table in the following format:
//{theInteger} X {times} = {product}
//Constraints
//•	The integer will be in the interval [1…100]

public class MultiplicationTable {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        for (int multiplier = 1; multiplier <= 10 ; multiplier++) {
            System.out.printf("%d X %d = %d%n", number, multiplier, number * multiplier);
            //System.out.println(number + " X " + multiplier + " = " + number * multiplier);
        }

        int multiplier = 1;
        while (multiplier <= 10) {
            System.out.printf("%d X %d = %d%n", number, multiplier, number * multiplier);
            multiplier++;
        }


    }
}
