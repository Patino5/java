package inc.shopping.command;

import inc.shopping.model.Product;
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
        int itemTotal = 0;
        Product productDetails;

        if(!basket.getCart().isEmpty()){
            io.displayMessage("\nScanning items in cart...");

            for (String key : basket.getCart().keySet()){
                productDetails = basket.getCart().get(key);
                io.displayMessage( productDetails.getQuantity() +
                        " " + productDetails.getName() +
                        (productDetails.getQuantity() > 1 ? "s " : " ") + "scanned. ");

                itemTotal += basket.getCart().get(key).getQuantity();
            }

            double total = basket.checkout();
            io.displayMessage("Total Items: "+ itemTotal);
            io.displayMessage(String.format("Total: $%.2f", total));

        } else io.displayMessage("Cart is empty. Thank you");
        io.getString("\nPress enter to continue");

    }
}
