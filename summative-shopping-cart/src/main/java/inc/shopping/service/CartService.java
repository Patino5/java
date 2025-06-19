package inc.shopping.service;

import inc.shopping.model.Product;
import inc.shopping.view.TerminalUtils;

import java.util.ArrayList;

public class CartService {
    TerminalUtils io = new TerminalUtils();
    private static ArrayList<Product> cart = new ArrayList<>();

    //what do we want our cart to do
    // display item in cart
    public void displayCart() {
        if (cart.isEmpty()) {
            io.displayMessage("Cart is currently empty.");
            return;
        }
        io.displayMessage("PRODUCT |  PRICE  |  QTY  | SUBTOTAL");
        for (Product product : cart) {
            io.displayMessage(product.getDetails());
        }

    }
    // add item to cart
    public void addProduct(Product product) {
        cart.add(product);
    }
    // remove item from cart

    // check out

}
