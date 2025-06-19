package inc.shopping;

import inc.shopping.model.Product;
import inc.shopping.service.CartService;
import inc.shopping.view.TerminalUtils;

public class App {
    public static void main(String[] args) {
        TerminalUtils io = new TerminalUtils();
        CartService cart = new CartService();

        io.displayMessage("Shopping Inc. Shopping Cart System");
        // application loop
        while (true) {
            io.displayMainMenu();
            int choice = io.getIntRequired("Enter a menu choice by number");

            switch (choice) {
                case 1 -> cart.displayCart();
                case 2 -> io.displayMessage("Item/s available to remove:"); // Remove Item from cart
                case 3 -> {
                    // Add Item to cart
                    Product newProduct =
                            new Product(
                                    io.getString("Enter name of product"),
                                    io.getIntRequired("Enter Price of product"),
                                    io.getIntRequired("Enter quantity to add")
                            );
                    cart.addProduct(newProduct);
                    io.displayMessage(newProduct.getName() + " added to cart.");
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
                default -> io.displayMessage("Invalid choice. Please select again");
            }

        }
    }
}