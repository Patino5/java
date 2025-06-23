package inc.shopping.command;

import inc.shopping.service.ShoppingCartService;
import inc.shopping.view.TerminalUtils;

public class CheckoutCommand implements Command {
    private final ShoppingCartService basket;
    private final TerminalUtils io;

    public CheckoutCommand(ShoppingCartService basket, TerminalUtils io){
        this.basket = basket;
        this.io = io;
    }

    public void execute() {
        double total = basket.checkout();
        io.displayMessage(String.format("Total: $%.2f", total));
        io.displayMessage("Cart is empty. Thank you");
    }
}
