package inc.shopping.view;

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
                validNumber = true;
            } catch (NumberFormatException e) {
                displayMessage("Not a valid number. Try again.");
            }
        }
        return number;
    }

    public double getDouble(String prompt) {
        double price = 0;
        boolean validPrice = false;

        while(!validPrice) {
            try {
                price = Double.parseDouble(getStringRequired(prompt));
                if (price >= 0.00){
                    validPrice = true;
                } else{
                    displayMessage("Price cannot be negative. Try again");
                }
            } catch (NumberFormatException e) {
                displayMessage("Not a number. Try again");
            }
        }
        return price;
    }

    public void displayMainMenu() {
        displayMessage("Main Menu");
        displayMessage("1. Display Cart");
        displayMessage("2. Remove an Item");
        displayMessage("3. Add an Item");
        displayMessage("4. Checkout");
        displayMessage("5. Exit");

    }
}
