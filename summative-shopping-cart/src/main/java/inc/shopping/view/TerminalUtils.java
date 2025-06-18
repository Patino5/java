package inc.shopping.view;

import java.util.ArrayList;
import java.util.Scanner;

public class TerminalUtils {
    private Scanner scanner = new Scanner(System.in);

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void prompt(String message) {
        System.out.print(message + ": ");
    }

    public String getString(String prompt) {
        prompt(prompt);
        return scanner.nextLine();
    }

    public String getStringRequired(String prompt) {
        boolean validInput = false;
        String result = null;

        while (!validInput) {
            result = getString(prompt);
            if (result != null && !result.isEmpty()) {
                validInput = true;
            }
        }
        return result;
    }

    public int getIntRequired(String prompt) {
        int number = 0;
        boolean validNumber = false;

        while (!validNumber) {
            try {
                number = Integer.parseInt(getStringRequired(prompt));
                validNumber = true;
            } catch (NumberFormatException e) {
                displayMessage("Not a number. Try again.");
            }
        }
        return number;
    }

}
