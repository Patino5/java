package com.learn.inventory_manager.ui;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Scanner;

@Component
public class ConsoleIO implements TextIO {
    private final Scanner scanner = new Scanner(System.in);
    @Override
    public void println(Object value) {
        System.out.println(value);
    }

    @Override
    public void print(Object value) {
        System.out.print(value);
    }

    @Override
    public void printf(String format, Object... values) {
        System.out.printf(format, values);
    }

    @Override
    public String readString(String prompt) {
        print(prompt);
        return scanner.nextLine();
    }

    @Override
    public boolean readBoolean(String prompt) {
        String result = readString(prompt);
        return result.equalsIgnoreCase("y");
    }

    @Override
    public int readInt(String prompt) {
        return readInt(prompt, false);
    }

    @Override
    public Integer readInt(String prompt, boolean allowSkip) {

        String input = readString(prompt);
        if (input.isEmpty() && allowSkip) return null;

        if (input.isEmpty()) {
            displayError("Input cannot be empty. Please try again.");
            return readInt(prompt, false);
        }

        try {
            int value = Integer.parseInt(input);
            if (value < 0) {
                displayError("Please enter a non-negative number.");
            }
            return value;

        } catch (NumberFormatException e) {
            displayError("`" + input + "` is not a valid number.");
            return readInt(prompt, allowSkip);
        }
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        while (true) {
            int value = readInt(prompt);
            if (value >= min && value <= max) {
                return value;
            }
            displayError("Value must be between " + min + " and " + max + ".");
        }
    }

    @Override
    public BigDecimal getBigDecimal(String prompt) {
        return getBigDecimal(prompt, false);
    }

    @Override
    public BigDecimal getBigDecimal(String prompt, boolean allowSkip) {
        String input = readString(prompt);

        if (input.isEmpty() && allowSkip) {
            return null;
        }

        if (input.isEmpty()) {
            displayError("Input cannot be empty. Please try again.");
            return getBigDecimal(prompt);
        }

        try {
            BigDecimal value = new BigDecimal(input);
            if (value.compareTo(BigDecimal.ZERO) <= 0) {
                displayError("Please enter a positive price.");
                return getBigDecimal(prompt);
            }
            return value;
        } catch (NumberFormatException e) {
            displayError("Please enter a valid price (e.g., 19.99).");
            return getBigDecimal(prompt);
        }
    }

    @Override
    public boolean getConfirmation(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim().toLowerCase();

        while (!input.equals("y") && !input.equals("n") &&
                !input.equals("yes") && !input.equals("no")) {
            displayError("Please enter 'y' for yes or 'n' for no.");
            System.out.print(prompt);
            input = scanner.nextLine().trim().toLowerCase();
        }

        return input.equals("y") || input.equals("yes");
    }

    private void displayError(String message) {
        println("✗ ERROR: " + message);
    }
}
