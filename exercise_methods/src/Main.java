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

        // Task 8: Method Overloading
        greet("Ryan", 36);
        greet("Ryan");
        greet("Briar");
        greet("Briar", 2);

        // Task 9: Count Vowels in a String
        System.out.println("'hello world' has " + countVowels("hello world") + " vowels in it.");
        System.out.println(countVowels("java programming"));

        // Task 10: Mini Calculator
        System.out.println(calculator(1,3,'+'));
        System.out.println(calculator(4, 5, '*'));
        System.out.println(calculator(50, 20, '-'));
        System.out.println(calculator(32, 0, '/'));
        System.out.println(calculator(21, 7, '/'));

        // Bonus: isPalindrome
        System.out.println(isPalindrome("race car"));
        System.out.println(isPalindrome("hello"));
        System.out.println(isPalindrome("taco cat"));
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
    // method overloading - greet (String name) and greet(Sting name, int age)
    public static void greet(String name){
        System.out.println("Hello, " + name);
    }
    public static void greet(String name, int age){
        System.out.println("Hello, " + name + "!\nYou are " + age + " years old.");
    }
    // count vowels in a string - countVowels(String text) returns int numberVowels
    public static int countVowels(String text) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if ("aeiou".indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }
    // mini calculator - calculator performs addition, subtraction, multiplication, or division based on user input
    public static int calculator(int num1, int num2, char operator){

        return switch (operator){
            case '+': 
                yield num1 + num2;
            case '-':
                yield num1 - num2;
            case '*':
                yield num1 * num2;
            case '/': 
                if (num2 == 0){
                    System.out.print("Division by zero not allowed. ");
                    yield 0;
                } else {
                    yield num1 / num2;
                }
            default : {
                    System.out.print("Operator not recognized. Try again. ");
                    yield 0;
                }
        };
    }
    // isPalindrome - checks if text is same forward and backwards
    public static boolean isPalindrome(String text){
        String reverse = "";
        for (int i = text.length() - 1; i >= 0; i--){
            if (text.charAt(i) == ' ') continue;
            reverse += text.charAt(i);
        }
        return reverse.equals(text.replace(" ", ""));
    }
}