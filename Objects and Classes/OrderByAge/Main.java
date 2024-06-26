import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

//You will receive an unknown number of lines.
//On each line, you will receive an array with 3 elements.
//The first element will be a string and represents the name of the person.
//The second element will be a string and will represent the ID of the person.
//The last element will be an integer which represents the age of the person.

//When you receive the command "End", stop taking input and print all the people,
//ordered by age

//Example

//Input:
//George 123456 20
//Peter 78911 15
//Stephan 524244 10
//End

//Output:
//Stephan with ID: 524244 is 10 years old.
//Peter with ID: 78911 is 15 years old.
//George with ID: 123456 is 20 years old

public class OrderByAge {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {

            //"George 123456 20"
            String name = input.split(" ")[0];
            String id = input.split(" ")[1];
            int age = Integer.parseInt(input.split(" ")[2]);

            Person person = new Person(name, id, age);
            people.add(person);

            input = scanner.nextLine();
        }

        people.sort(Comparator.comparing(Person::getAge));

        for (Person person : people) {
            System.out.printf("%s with ID: %s is %d years old.\n", person.getName(), person.getId(), person.getAge());
        }
    }
}
