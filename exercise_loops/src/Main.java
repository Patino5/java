import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Basic loops Practice
        // count up (for Loop)
        for (int i = 1; i < 101; i++){
            System.out.println(i);
        }

        // Countdown Timer (while Loop)
        Scanner io = new Scanner(System.in);
        System.out.print("Enter a starting number: ");
        int startNum = Integer.parseInt(io.nextLine());
        while (startNum > 0){
            System.out.println(startNum);
            startNum--;
            if (startNum == 0){
                System.out.println(startNum);
                System.out.println("Blast off!");
            }
        }

    }
}
