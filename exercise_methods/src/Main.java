public class Main {
    public static void main(String[] args) {
        // Task 1: Define and Call a Simple Method
        printWelcomeMessage();

        // Task 2: Calculate the Sum of Two Numbers
        System.out.println(sum(3, 6));
        System.out.println(sum(500, 3));
        System.out.println(sum(-34, -55));

    }
    // printWelcomeMessage
    public static void printWelcomeMessage() {
        System.out.println("Welcome to the Java Methods Exercise!");
    }
    // sum
    public static int sum(int a, int b) {
        return a + b;
    }

}