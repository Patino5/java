import java.util.Scanner;

public class TerminalUtils {
    private Scanner io = new Scanner(System.in);

    public void print(String msg){
        System.out.println(msg);
    }

    public void pressEnterToContinue() {
        print("\nPress enter to continue...");
        io.nextLine();
    }

    public String getString(String prompt) {
        print(prompt);
        return io.nextLine();
    }


}
