package inc.shopping.service;

import inc.shopping.model.Product;
import inc.shopping.view.TerminalUtils;

import java.util.ArrayList;
import java.util.HashMap;

public class CartService {
    TerminalUtils io = new TerminalUtils();
    private HashMap<String, Product > cart = new HashMap<>();

    //what do we want our cart to do
    // display item in cart
    public void displayCart() {
        if (cart.isEmpty()) {
            io.displayMessage("Cart is currently empty.");
            return;
        }
        io.displayMessage("PRODUCT |  PRICE  |  QTY  | SUBTOTAL");
        for (Product product : cart.values()) {
            io.displayMessage(product.getDetails());
        }
        io.getString("Press enter to continue.");
    }

    // add item to cart
    public void addProduct(String productName, double price, int quantity) {
        cart.put(productName, new Product(productName, price, quantity));
    }

    // remove item from cart


    // check out

}
