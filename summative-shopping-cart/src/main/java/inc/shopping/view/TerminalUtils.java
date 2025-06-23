package inc.shopping.view;

import java.util.Scanner;

public class TerminalUtils {
    private final Scanner scanner;

    public TerminalUtils(Scanner scanner){
        this.scanner = scanner;
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public String getString(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextLine();
    }

    public String getStringRequired(String prompt) {
        boolean validInput = false;
        String result = null;

        while (!validInput) {
            result = getString(prompt).trim();
            if (!result.isEmpty()) {
                validInput = true;
            } else {
                displayMessage("Input can not be blank. Try again.");
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
                if (number > 0){
                    validNumber = true;
                } else {
                    displayMessage("Must be positive. Try again");
                }
            } catch (NumberFormatException e) {
                displayMessage("Not a valid number. Try again.");
            }
        }
        return number;
    }

    public double getDoubleRequired(String prompt) {
        double number = 0;
        boolean validNumber = false;

        while (!validNumber) {
            try {
                number = Double.parseDouble(getStringRequired(prompt));
                if (number > 0) {
                    validNumber = true;
                } else {
                    displayMessage("Must be positive. Try again.");
                }
            } catch (NumberFormatException e) {
                displayMessage("Not a valid number. Try again.");
            }
        }
        return number;
    }

    public void displayMainMenu() {
        displayMessage("\n===============");
        displayMessage("   Main Menu   ");
        displayMessage("===============");
        displayMessage("1. Display Cart");
        displayMessage("2. Remove an Item");
        displayMessage("3. Add an Item");
        displayMessage("4. Checkout");
        displayMessage("5. Exit");

    }
}
