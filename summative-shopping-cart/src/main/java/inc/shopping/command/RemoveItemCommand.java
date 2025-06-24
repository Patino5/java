package inc.shopping.command;

import inc.shopping.model.Product;
import inc.shopping.service.ShoppingCartService;
import inc.shopping.view.TerminalUtils;
import java.util.HashMap;

public class RemoveItemCommand implements Command {
    private final ShoppingCartService cart;
    private final TerminalUtils io;

    public RemoveItemCommand(ShoppingCartService cart, TerminalUtils io) {
        this.cart = cart;
        this.io = io;
    }

    public void execute() {
        HashMap<String, Product> cart = this.cart.getCart();
        if (cart.isEmpty()) {
            io.displayMessage("Cart is empty. Nothing to remove.");
            return;
        }

        new DisplayCartCommand(this.cart, io).execute();

        String name = io.getStringRequired("Enter Product to Remove").toLowerCase();
        if (!cart.containsKey(name)){
            io.displayMessage("Item: " + name + " not found in cart.");
            return;
        }
        Product productToRemove = cart.get(name);

        int productCurrentQuantity = productToRemove.getQuantity();
        io.displayMessage("Current quantity: " + productCurrentQuantity);
        int qtyToRemove = io.getIntRequired("Enter quantity to remove");

        if (qtyToRemove > productCurrentQuantity || qtyToRemove <= 0) {
            io.displayMessage((productCurrentQuantity >  1 ? "Must be between 1 and " + productCurrentQuantity + "." : "Enter 1 for last item."));
            return;
        }

        Product removed = this.cart.removeFromCart(name, qtyToRemove);
        if (removed != null) {
            io.displayMessage(qtyToRemove + " " + name + (qtyToRemove > 1 ? "s removed." : " removed."));

        } else {
            io.displayMessage("Unable to remove item.");
        }
    }
}