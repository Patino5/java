package inc.shopping;

import inc.shopping.command.AddItemCommand;
import inc.shopping.command.CheckoutCommand;
import inc.shopping.command.DisplayCartCommand;
import inc.shopping.command.RemoveItemCommand;
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
                case 2 -> new RemoveItemCommand(basket, io).execute();
                case 3 -> new AddItemCommand(basket, io).execute();
                case 4 -> new CheckoutCommand(basket, io).execute();
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