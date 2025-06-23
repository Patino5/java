package inc.shopping.command;

import inc.shopping.model.Product;
import inc.shopping.service.ShoppingCartService;
import inc.shopping.view.TerminalUtils;

public class AddItemCommand implements Command {
    private final ShoppingCartService basket;
    private final TerminalUtils io;

    public AddItemCommand(ShoppingCartService basket, TerminalUtils io) {
        this.basket = basket;
        this.io = io;
    }

    public void execute() {
        String name = io.getStringRequired("Enter Product Name");
        double price = io.getDoubleRequired("Enter Product Price");
        int quantity = io.getIntRequired("Enter Quantity");

        Product product = new Product(name, price, quantity);
        basket.addToCart(product);
        io.displayMessage("Item added to cart.");
    }
}