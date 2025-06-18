package inc.shopping;

import inc.shopping.view.TerminalUtils;

public class App {
    public static void main(String[] args) {
        TerminalUtils io = new TerminalUtils();

        // application loop
        while (true) {
            io.displayMessage("Main Menu");
            io.displayMessage("1. Display Cart");
            io.displayMessage("2. Remove an Item");
            io.displayMessage("3. Add an Item");
            io.displayMessage("4. Checkout");
            io.displayMessage("5. Exit");

            int choice = io.getIntRequired("Enter a menu choice by number");

            switch (choice) {
                case 1 -> {
                    // Display cart
                    io.displayMessage("Cart contents:");
                }
                case 2 -> {
                    // Remove Item from cart
                    io.displayMessage("Item/s available to remove:");
                }
                case 3 -> {
                    // Add Item to cart
                    io.displayMessage("Item to add:");
                }
                case 4 -> {
                    // Checkout
                    io.displayMessage("Checking out cart...");
                }
                case 5 -> {
                    // exit
                    io.displayMessage("Thank you for using the Shopping Cart App!");
                    System.exit(0);
                }
            }

        }
    }
}
