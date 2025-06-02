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


    }
}