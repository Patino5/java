import java.util.Scanner;

public class Main {
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
        System.out.print("Enter a word: ");
        String word = io.nextLine();
        String vowels = "aeiou";

        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if (vowels.indexOf(c) != -1){
                System.out.println("First vowel '" + c + "' found at position: " + i );
                break;
            }
        }
    }
}
