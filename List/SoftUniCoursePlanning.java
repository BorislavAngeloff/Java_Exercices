import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

//You are tasked to help plan the next Programming Fundamentals course
// by keeping track of the lessons that will be included in the course,
// as well as all the exercises for the lessons.

//On the first input line, you will receive the initial schedule of lessons and
//exercises that will be part of the next course, separated by a comma and
//space ", ". But before the course starts, there are some changes to be made.
//Until you receive "course start", you will be given some commands to modify
//the course schedule. The possible commands are:

//Add:{lessonTitle} - add the lesson to the end of the schedule, if it does not exist

//Insert:{lessonTitle}:{index} - insert the lesson to the given index,
// if it does not exist

//Remove:{lessonTitle} - remove the lesson, if it exists

//Swap:{lessonTitle}:{lessonTitle} - change the place of the two lessons,
// if they exist

//Exercise:{lessonTitle} - add Exercise in the schedule right after the lesson index, if the lesson exists and there is no exercise already, in the following format: "{lessonTitle}-Exercise". If the lesson doesn't exist, add the lesson at the end of the course schedule, followed by the Exercise.

//Each time you Swap or Remove a lesson, you should do the same with the Exercises, if there are any, which follow the lessons.



public class SoftUniCoursePlanning {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> lessons = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        // 1. Add:{lessonTitle} - add the lesson to the end of the schedule, if it does not exist
        // 2. Insert:{lessonTitle}:{index} - insert the lesson to the given index, if it does not exist
        // 3. Remove:{lessonTitle} - remove the lesson, if it exists
        // 4. Swap:{lessonTitle}:{lessonTitle} - change the place of the two lessons, if they exist
        // 5. Exercise:{lessonTitle} - add Exercise in the schedule right after the lesson index,
        //if the lesson exists and there is no exercise already,
        //in the following format: "{lessonTitle}-Exercise".
        //If the lesson doesn't exist, add the lesson at the end of the course schedule,
        // followed by the Exercise.

        //Input

        //On the first line -the initial schedule lessons -strings,
        // separated by comma and space ", ".
        //Until "course start", you will receive commands in the format described above.

        //Output
        //Print the whole course schedule, each lesson on a new line with
        // its number(index) in the schedule: "{lesson index}.{lessonTitle}".

        //Example

        //Input:
        //Data Types, Objects, Lists
        //Add:Databases
        //Insert:Arrays:0
        //Remove:Lists
        //course start

        //Output:
        //Data Types, Objects, Lists
        //Add:Databases
        //Insert:Arrays:0
        //Remove:Lists
        //course start

        String input = scanner.nextLine();
        while (!input.equals("course start")) {

            String[] commandParts = input.split(":");
            String commandName = commandParts[0];
            String lesson = commandParts[1];

            switch (commandName) {
                case "Add":
                    if (!lessons.contains(lesson)) {
                        lessons.add(lesson);
                    }
                    break;
                case "Insert":
                    int index = Integer.parseInt(commandParts[2]);
                    if (!lessons.contains(lesson)) {
                        lessons.add(index, lesson);
                    }
                    break;
                case "Remove":
                    lessons.remove(lesson);
                    lessons.remove(lesson + "-Exercise");
                    break;
                case "Swap":
                    String lesson2 = commandParts[2];
                    if (lessons.contains(lesson) && lessons.contains(lesson2)) {
                        int indexFirst = lessons.indexOf(lesson);
                        int indexSecond = lessons.indexOf(lesson2);

                        lessons.set(indexFirst, lesson2);
                        lessons.set(indexSecond, lesson);

                        String firstLessonExercise = lesson + "-Exercise";
                        String secondLessonExercise = lesson2 + "-Exercise";

                        if (lessons.contains(firstLessonExercise)) {
                            lessons.remove(firstLessonExercise);
                            lessons.add(indexSecond + 1, firstLessonExercise);
                        }

                        if (lessons.contains(secondLessonExercise)) {
                            lessons.remove(secondLessonExercise);
                            lessons.add(indexFirst + 1, secondLessonExercise);
                        }
                    }
                    break;
                case "Exercise":
                    String exerciseName = lesson + "-Exercise";
                    if (lessons.contains(lesson)) {
                        if (!lessons.contains(exerciseName)) {
                            int indexOfTheLesson = lessons.indexOf(lesson);
                            lessons.add(indexOfTheLesson + 1, exerciseName);
                        }
                    } else {
                        lessons.add(lesson);
                        lessons.add(exerciseName);
                    }
                    break;
            }

            input = scanner.nextLine();
        }

        int number = 1;
        for (String lesson : lessons) {
            System.out.println(number + "." + lesson);
            number++;
        }
    }
}
