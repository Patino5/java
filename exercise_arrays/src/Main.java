import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Part 1: Basic Array Operations
        // 1. Declare an array
        // create an array of 5 cities and assign values directly
        String[] cities = {"Austin", "Round Rock", "Cedar Park", "Leander", "Georgetown"};
        System.out.println(cities[0]);
        System.out.println(cities[1]);
        System.out.println(cities[2]);
        System.out.println(cities[3]);
        System.out.println(cities[4]);

        // 2. Access & Modify Elements
        // update the 3rd city in the array to a different name
        cities[2] = "San Antonio";
        System.out.println(cities[2]);
        // 3. Find the Length of an Array
        System.out.println("Number of cities in the array: " + cities.length);

        // Part 2: Iterating Over Arrays
        // 4. Print Array elements using a loop
        for (String city : cities) {
            System.out.println(city);
        }
        // 5. Reverse an array
        for (int i = cities.length -1; i >= 0; i--){
            System.out.println(cities[i]);
        }
        // 6. Find a specific element
        // ask for a city from user
        Scanner io = new Scanner(System.in);
        System.out.print("Enter a city: ");
        String userInput = io.nextLine();
        boolean foundCity = false;
        for (String city : cities){
            if (city.equalsIgnoreCase(userInput)) {
                System.out.println("City found!");
                foundCity = true;
                break;
            }
        }
        if (!foundCity) {
            System.out.println("City not found");
        }

        // Part 3: Numeric Arrays & Calculations
        // 7. Sum of Numbers in an array
        // create 5 test scores. loop through and calculate the sum for all scores. Print sum.
        int[] scores = {75, 84, 90, 96, 65};
        int sum = 0;

        for (int score : scores){
            sum += score;
        }
        System.out.println("Sum of scores: " + sum);

        // 8. Find the min and max of scores array
        int maxScore = scores[0];
        int minScore = scores[0];

        for (int score : scores) {
            if (score > maxScore){
                maxScore = score;
            }
            if (score < minScore){
                minScore = score;
            }
        }
        System.out.println("Max score: " + maxScore);
        System.out.println("Min score: " + minScore);

        // 9. Calculate the avg.

        int scoreAvg = sum / scores.length;
        System.out.println(scoreAvg);

        // Part 4: Advanced Challenges
        // 10. Count Occurrences of a value
        Random randomNum = new Random();
        int[] randomNums = new int[10];
        int count = 0;
        for (int i = 0; i < randomNums.length ; i++){

            randomNums[i] = randomNum.nextInt(5) + 1;
            System.out.print(randomNums[i] + ", ");
            if (randomNums[i] == 3){
                count++;
            }
        }
        System.out.println("There is " + count + " 3's in randomNums array.");

        // 11. Shift Elements in an Array
        int[] givenArr = {1, 2, 3, 4, 5};
        int temp = givenArr[0];
        for ( int i = 0; i < givenArr.length - 1; i++) {
            givenArr[i] = givenArr[i + 1];
        }
        givenArr[givenArr.length - 1] = temp;

        for (int num : givenArr){
            System.out.println(num);
        }

        // 12. Check for Duplicates in a n Array of Names
        String[ ] students = {"Ryan", "Briar", "Shanice", "Eleanor", "Magnolia", "Molly"};
        HashSet<String> uniqueStudents = new HashSet<>(); // only allows for one occurs of each element
        // check for duplicates
        for (String student : students) {
            uniqueStudents.add(student);
        }

        if (uniqueStudents.toArray().length == students.length) {  // if lengths equal no duplicates
            System.out.println("No Duplicates");
        } else {
            System.out.println("Duplicates found"); // otherwise duplicates are found
        }


        // Print Duplicates found! if any names appear more than once

    }
}