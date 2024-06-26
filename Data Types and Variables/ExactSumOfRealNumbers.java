import java.math.BigDecimal;
import java.util.Scanner;

//Write a program to enter n numbers and calculate and print their exact sum (without rounding).

//Example

//Input:
//3
//
//1000000000000000000
//
//5

//Output:
//1000000000000000015

public class ExactSumOfRealNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());

        BigDecimal sum = new BigDecimal("0");
        for (int number = 1; number <= count; number++) {
            BigDecimal value = new BigDecimal(scanner.nextLine());

            sum = sum.add(value);
        }

        System.out.println(sum);
    }
}
