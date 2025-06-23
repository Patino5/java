package inc.shopping.command;

import inc.shopping.model.Product;
import inc.shopping.service.ShoppingCartService;
import inc.shopping.view.TerminalUtils;

public class AddItemCommand implements Command {
    private final ShoppingCartService cart;
    private final TerminalUtils io;

    public AddItemCommand(ShoppingCartService cart, TerminalUtils io) {
        this.cart = cart;
        this.io = io;
    }

    public void execute() {
        String name = io.getStringRequired("Enter Product Name").toLowerCase();
        double price = !cart.getCart().containsKey(name) ?
                io.getDoubleRequired("Enter Product Price") :
                cart.getCart().get(name).getPrice();

        int quantity = io.getIntRequired("Enter Quantity");
        Product product = new Product(name, price, quantity);
        cart.addToCart(product);
        io.displayMessage(quantity + " " + name +
                (quantity > 1 ? "s added to the cart." : " added to the cart."));
    }
}