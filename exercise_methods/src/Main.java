public class Main {
    public static void main(String[] args) {
        // Task 1: Define and Call a Simple Method
        printWelcomeMessage();

        // Task 2: Calculate the Sum of Two Numbers
        System.out.println(sum(3, 6));
        System.out.println(sum(500, 3));
        System.out.println(sum(-34, -55));

        // Task 3: Convert Celsius to Fahrenheit
        System.out.println(convertToFahrenheit(0));
        System.out.println(convertToFahrenheit( 80));
        System.out.println(convertToFahrenheit(-34));

        // Task 4: Check if a number is Even or Odd
        System.out.println(isEven(3));
        System.out.println(isEven(434));
        System.out.println(isEven(1249393));
        System.out.println(isEven(232132454));

        // Task 5: Print a String Multiple Times
        printMultipleTimes("hello", 4);
        printMultipleTimes("world", 3);
        printMultipleTimes("Ryan", 1);

        // Task 6: Find Maximum of 3 nums
        System.out.println(findMax(1,4,5));
        System.out.println(findMax(356, 323,41));
        System.out.println(findMax(23,42,13));

        // Task 7: Factorial Using Recursion
        System.out.println(factorial(5));
        System.out.println(factorial(7));
        System.out.println(factorial(10));
    }
    // printWelcomeMessage
    public static void printWelcomeMessage() {
        System.out.println("Welcome to the Java Methods Exercise!");
    }
    // sum
    public static int sum(int a, int b) {
        return a + b;
    }
    // convert Celsius to Fahrenheit
    public static double convertToFahrenheit(double celsius) {
        return (celsius * (9/5))+ 32;
    }
    // isEven return true if even; false otherwise
    public static boolean isEven(int number){
        return number % 2 == 0;
    }
    // printMultipleTimes - prints a string n times
    public static void printMultipleTimes(String text, int times) {
        for (int i = times; i > 0; i--){
            System.out.println(text);
        }
    }
    // findMax - takes 3 integers and returns largest
    public static int findMax(int a, int b, int c){
        //return Math.max(a, Math.max(b, c));
        if (Math.max(b, c) < a) {
            return a;
        } else return Math.max(b, c);
    }
    // factorial - calculates the factorial using recursion
    public static int   factorial(int n){
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }
}