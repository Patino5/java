import java.lang.classfile.attribute.SourceFileAttribute;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

//    public static boolean isPrime(int number) {
//        if (number <= 1) return false;
//        if (number == 2) return true;
//        if (number % 2 == 0) return false;
//
//        for (int i = 3; i <= Math.sqrt(number); i++) {
//            if (number % i == 0) return false;
//        }
//
//        return true;
//    }

    public static void main(String[] args) {
        // Basic loops Practice
        // count up (for Loop)
//        for (int i = 1; i < 101; i++){
//            System.out.println(i);
//        }
//
//        // Countdown Timer (while Loop)
        Scanner io = new Scanner(System.in);
//        System.out.print("Enter a starting number: ");
//        int startNum = Integer.parseInt(io.nextLine());
//        while (startNum > 0){
//            System.out.println(startNum);
//            startNum--;
//            if (startNum == 0){
//                System.out.println(startNum);
//                System.out.println("Blast off!");
//            }
//        }
//
//        // guess the number
//        // generate random number between 0.0 and 1 exclusive Math.random()
//        // random number between 0 and 100
//        int randomNum = (int)(Math.random() * 51);
//        int guess;
//        do {
//            System.out.print("Guess a number between 1 and 50: ");
//            guess = Integer.parseInt(io.nextLine());
//        } while (guess != randomNum);

        // Intermediate Loops Challenges

        // Multiplication Table (For Loop)
        // ask for number
//        System.out.print("Enter a number: ");
//        int number = Integer.parseInt(io.nextLine());
//
//        for (int i = 1; i <= 10; i++){
//            System.out.println(i + " * " + number + " = "+ (number * i));
//        }
//
//        // Password Validator (While Loop)
//        // Ask user to enter a password
//        // keep asking until they enter the correct password "letmein"
//        String password = "";
//
//        while (!password.equals("letmein")){
//            System.out.print("Enter the password: ");
//            password = io.next();
//        }

        // Find the first vowel (for loop)
//        System.out.print("Enter a word: ");
//        String word = io.nextLine();
//        String vowels = "aeiou";
//
//        for (int i = 0; i < word.length(); i++){
//            char c = word.charAt(i);
//            if (vowels.indexOf(c) != -1){
//                System.out.println("First vowel '" + c + "' found at position: " + i );
//                break;
//            }
//        }
        // simple ATM System (Do-While-Loop)
//        double acctBalance = 500;
//        int input;
//        do {
//            System.out.println("1 Withdraw");
//            System.out.println("2 Deposit");
//            System.out.println("3 Check Balance");
//            System.out.println("4 Exit");
//            System.out.print("Enter an option number: ");
//            input = Integer.parseInt(io.nextLine());
//
//        } while (input != 4);

        // Advance Loops Exercise
        // Fizzbuzz challenge (For loop)
//        for (int i = 1; i < 101; i++){
//            if (i % 3 == 0 && i % 5 == 0){
//                System.out.println("Fizzbuzz");
//            } else if (i % 3 == 0) {
//                System.out.println("Fizz");
//            } else if (i % 5 == 0) {
//                System.out.println("Buzz");
//            } else {
//                System.out.println(i);
//            }
//        }

        // Reverse a String
        // ask for word
//        System.out.print("Enter a word to be reversed: ");
//        String inputWord = io.nextLine();
//
//        for (int i = inputWord.length() - 1; i >= 0; i--) {
//            System.out.print(inputWord.charAt(i));
//        }

        // Prime number checker While loop
        // ask for number
//        System.out.print("Enter a number: ");
//        int checkPrime = Integer.parseInt(io.nextLine());
//        boolean isPrime = true;
//
//        if (checkPrime <= 1) {
//            isPrime = false; // 0 and 1 are not prime
//        } else {
//            int i = 2;
//            while (i <= Math.sqrt(checkPrime)) {
//                if (checkPrime % i == 0) {
//                    isPrime = false; // Found a divisor
//                    break;
//                }
//                i++;
//            }
//        }
//
//        // Output the result
//        if (isPrime) {
//            System.out.println(checkPrime + " is a prime number.");
//        } else {
//            System.out.println(checkPrime + " is not a prime number.");
//        }

        // Word counter (for loop with split)
        // ask user for sentence
//        System.out.print("Enter a sentence: ");
//        String sentence = io.nextLine();
//        String[] splitSentence = sentence.split(" ");
//
//        for (int i = 0; i < splitSentence.length; i++) {
//            System.out.println((i + 1) + " " + splitSentence[i] + ".");
//
//        }

        // Break & Continue Challenges
        // Skip negative Numbers

//        int numbers=1;
//
//        while (numbers != 0){
//            System.out.print("Enter a number: 0 to quit. ");
//            numbers = Integer.parseInt(io.nextLine());
//            if (numbers % 2 != 0){
//                continue;
//            }
//            System.out.println(numbers);
//        }

        // Find the first Prime Number (Break Statement)
        // ask for a range
        // for loop to find first prime number in range then stop checking
//        int min;
//        int max;
//        boolean found = false;
//
//        System.out.print("Enter a min value: ");
//        min = Integer.parseInt(io.nextLine());
//        System.out.print("Enter max value: ");
//        max = Integer.parseInt(io.nextLine());
//
//        for (int i = min; i <= max; i++) {
//            if (isPrime(i)) {
//                System.out.println("First prime number in range: " + i);
//                found = true;
//                break;
//            }
//        }
//
//        if (!found){
//            System.out.println("No prime numbers in range");
//        }
//
         // Infinite Loops & Fixing Them
//        int i = 0;
//        while (i <= 10) {
//            System.out.println(i);
//            i++;
//        }

//        // Even number checker
//        int number = 1;
//
//        while (true){
//            System.out.println("Enter a even number: ");
//            number = Integer.parseInt(io.nextLine());
//            if (number % 2 == 0){
//                break;
//            }
//            System.out.println(number + " is not an even number.");
//
//        }

        // Bank Withdrawal System
        double balance = 1000;
        double withdrawal;

        while (balance >= 0){
            System.out.print("Enter amount to withdrawal: ");
            withdrawal = Double.parseDouble(io.nextLine());
            if (withdrawal > balance){
                System.out.println("Transaction denied... Insufficient funds");
                System.out.println("Current Balance: " + balance);
                continue;
            }
            balance -= withdrawal;
            System.out.println("New balance: " + balance);


        }

    }
}
