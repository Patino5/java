import java.util.Scanner;

public class UserRegistration {

    public static void main(String[] args) {
        Scanner io = new Scanner(System.in);

        int age = getAge("Enter your age: ", io);

        String email = getEmail("Enter your email: ", io);

        System.out.print("Enter your 4-digit PIN: ");
        int pin = Integer.parseInt(io.nextLine());

        System.out.println("\nRegistration Successful!");
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
        System.out.println("PIN: " + pin);
    }

    public static int getAge(String prompt, Scanner io){
        while (true){
            System.out.print(prompt);
            try {
                int age = Integer.parseInt(io.nextLine());
                if (age > 0 && age < 120) {
                    return age;
                } else {
                    System.out.println("That is not within the age range, try again?");
                }
            } catch (NumberFormatException e) {
                System.out.println("That is not a number");
            }
        }
    }

    public static String getEmail(String prompt, Scanner io){
        while (true){
            System.out.print(prompt);
            try {
                String email = io.nextLine();
                if (!email.isEmpty() ){
                    return email;
                } else{
                    throw new Exception("Email can not be empty or null.");
                }
            } catch (Exception e) {
                System.out.println("Email needs a value. " + e.getMessage() + " Try again.");
            }
        }
    }

}