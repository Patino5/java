package inc.shopping.command;

import inc.shopping.model.Product;
import inc.shopping.service.ShoppingCartService;
import inc.shopping.view.TerminalUtils;

import java.util.HashMap;

public class RemoveItemCommand implements Command {
    private final ShoppingCartService basket;
    private final TerminalUtils io;

    public RemoveItemCommand(ShoppingCartService cartService, TerminalUtils io) {
        this.basket = cartService;
        this.io = io;
    }

    @Override
    public void execute() {
        HashMap<String, Product> cart = basket.getCart();
        if (cart.isEmpty()) {
            io.displayMessage("Cart is empty. Nothing to remove.");
            return;
        }

        String name = io.getStringRequired("Enter Product to Remove");
        int qty = io.getIntRequired("Enter Quantity to remove");

        Product removed = basket.removeFromCart(name, qty);
        if (removed != null) {
            io.displayMessage("Removed " + qty + " of " + name);
        } else {
            io.displayMessage("Unable to remove item.");
        }
    }
}