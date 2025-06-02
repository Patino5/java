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


    }
}