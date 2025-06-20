package inc.shopping;

import inc.shopping.service.CartService;
import inc.shopping.view.TerminalUtils;

public class App {
    public static void main(String[] args) {
        TerminalUtils io = new TerminalUtils();
        CartService cart = new CartService(io);

        io.displayMessage("Shopping Inc. Shopping Cart System");
        // application loop
        while (true) {
            io.displayMainMenu();
            int choice = io.getIntRequired("Enter a menu choice by number");

            switch (choice) {
                case 1 -> cart.displayCart();
                case 2 -> cart.removeProduct(); // Remove Item from cart
                case 3 -> cart.addProduct();
                case 4 -> cart.checkout();
                case 5 -> exitMessage(io);
                default -> io.displayMessage("Invalid choice. Please select again");
            }
        }
    }
    private static void exitMessage(TerminalUtils io){
        io.displayMessage("Thank you for using the Shopping Cart App!");
        System.exit(0);
    }
}