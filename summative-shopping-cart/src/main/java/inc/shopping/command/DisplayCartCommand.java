package inc.shopping.command;

import inc.shopping.model.Product;
import inc.shopping.service.ShoppingCartService;
import inc.shopping.view.TerminalUtils;

import java.util.HashMap;

public class DisplayCartCommand implements Command{
    private final ShoppingCartService basket;
    private final TerminalUtils io;

    public DisplayCartCommand(ShoppingCartService basket, TerminalUtils io){
        this.basket = basket;
        this.io = io;
    }

    public void execute() {
        HashMap<String, Product> cart = basket.getCart();
        if (cart.isEmpty()) {
            io.displayMessage("Cart is currently empty.");
            return;
        }
        io.displayMessage("PRODUCT  |  PRICE  |  QTY  | SUBTOTAL");
        for (Product product : cart.values()) {
            io.displayMessage(product.getDetails());
        }
    }
}
