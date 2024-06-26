import java.util.Scanner;

//Tony and Andi love playing in the snow and having snowball fights,
//but they always argue about which makes the best snowballs.
//They have decided to involve you in their fray by making you write a program
//that calculates snowball data and outputs the best snowball value.

//You will receive N – an integer, the number of snowballs being made by Tony and Andi.
//For each snowball, you will receive 3 input lines:
//On the first line, you will get the snowballSnow – an integer.
//On the second line, you will get the snowballTime – an integer.
//On the third line, you will get the snowballQuality – an integer.

//For each snowball, you must calculate its snowballValue by the following formula:
//(snowballSnow / snowballTime) ^ snowballQuality
//In the end, you must print the highest calculated snowballValue.

//Input
//On the first input line, you will receive N – the number of snowballs.
//On the next N * 3 input lines, you will receive data about snowballs.

//Output
//As output, you must print the highest calculated snowballValue, by the formula specified above.
//The output format is: "{snowballSnow} : {snowballTime} = {snowballValue} ({snowballQuality})"

//Constraints

//The number of snowballs (N) will be an integer in the range [0, 100].
//The snowballSnow is an integer in the range [0, 1000].
//The snowballTime is an integer in the range [1, 500].
//The snowballQuality is an integer in the range [0, 100].

//Example

//Input:
//2
//10
//2
//3
//5
//5
//5

//Output:
//10 : 2 = 125 (3)

public class Snowballs {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        double maxValue = 0;
        int snowballSnowBiggest = 0;
        int snowballTTimeBiggest = 0;
        int snowballQualityBiggest = 0;

        for (int snowBall = 1; snowBall <= n; snowBall++) {

            int snowBallSnow = Integer.parseInt(scanner.nextLine());
            int snowBallTime = Integer.parseInt(scanner.nextLine());
            int snowBallQuality = Integer.parseInt(scanner.nextLine());
            double snowBallValue = Math.pow(snowBallSnow / snowBallTime, snowBallQuality);

            if (snowBallValue > maxValue) {
                maxValue = snowBallValue;
                snowballSnowBiggest = snowBallSnow;
                snowballTTimeBiggest = snowBallTime;
                snowballQualityBiggest = snowBallQuality;
            }
        }

        System.out.printf("%d : %d = %.0f (%d) ", snowballSnowBiggest, snowballTTimeBiggest, maxValue, snowballQualityBiggest);
    }
}
