package inc.shopping;

import inc.shopping.command.*;
import inc.shopping.service.ProductList;
import inc.shopping.service.ShoppingCartService;
import inc.shopping.view.TerminalUtils;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TerminalUtils io = new TerminalUtils(scanner);
        ShoppingCartService cart = new ShoppingCartService();
        ProductList availableProducts = new ProductList();

        io.displayMessage("Shopping Inc. Shopping Cart System");
        // application loop
        while (true) {
            io.displayMainMenu();
            int choice = io.getIntRequired("Enter a menu choice by number");

            switch (choice) {
                case 1 -> new DisplayCartCommand(cart, io).execute();
                case 2 -> new RemoveItemCommand(cart, io).execute();
                case 3 -> new AddItemFromListCommand(availableProducts, cart, io).execute();
                case 4 -> new CheckoutCommand(cart, io).execute();
                case 5 -> new ExitCommand(io).execute();
                default -> io.displayMessage("Invalid choice. Please select again");
            }
        }
    }
}