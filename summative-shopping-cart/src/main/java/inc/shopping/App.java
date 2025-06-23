package inc.shopping;

import inc.shopping.command.DisplayCartCommand;
import inc.shopping.model.Product;
import inc.shopping.service.ShoppingCartService;
import inc.shopping.view.TerminalUtils;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TerminalUtils io = new TerminalUtils(scanner);
        ShoppingCartService basket = new ShoppingCartService();

        io.displayMessage("Shopping Inc. Shopping Cart System");
        // application loop
        while (true) {
            io.displayMainMenu();
            int choice = io.getIntRequired("Enter a menu choice by number");

            switch (choice) {
                case 1 -> new DisplayCartCommand(basket, io).execute();
                case 2 -> basket.removeFromCart(
                        io.getStringRequired("Enter Product to Remove: "),
                        io.getIntRequired("Enter Quantity to remove: "));
                case 3 -> basket.addToCart(new Product(
                        io.getStringRequired( "Enter Product Name: "),
                        io.getDoubleRequired("Enter Product Price: "),
                        io.getIntRequired("Enter Quantity: ")));
                case 4 -> {
                    double total = basket.checkout();
                    io.displayMessage("Total: $" + total);
                }
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