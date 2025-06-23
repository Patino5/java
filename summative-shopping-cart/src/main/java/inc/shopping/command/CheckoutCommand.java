package inc.shopping.command;

import inc.shopping.model.Product;
import inc.shopping.service.ShoppingCartService;
import inc.shopping.view.TerminalUtils;

public class CheckoutCommand implements Command {
    private final ShoppingCartService cart;
    private final TerminalUtils io;

    public CheckoutCommand(ShoppingCartService cart, TerminalUtils io){
        this.cart = cart;
        this.io = io;
    }

    public void execute() {
        int itemTotal = 0;
        Product productDetails;

        if(!cart.getCart().isEmpty()){
            io.displayMessage("\nScanning items in cart...");

            for (String key : cart.getCart().keySet()){
                productDetails = cart.getCart().get(key);
                io.displayMessage( productDetails.getQuantity() +
                        " " + productDetails.getName() +
                        (productDetails.getQuantity() > 1 ? "s " : " ") + "scanned. ");

                itemTotal += cart.getCart().get(key).getQuantity();
            }

            double total = cart.checkout();
            io.displayMessage("Total Items: "+ itemTotal);
            io.displayMessage(String.format("Grand Total: $%.2f", total));

        } else io.displayMessage("Cart is empty.");
        io.getString("\nPress enter to continue");

    }
}
