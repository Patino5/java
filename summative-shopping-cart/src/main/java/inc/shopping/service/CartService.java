package inc.shopping.service;

import inc.shopping.model.Product;
import inc.shopping.view.TerminalUtils;

import java.util.ArrayList;
import java.util.HashMap;

public class CartService {
    private TerminalUtils io;
    private HashMap<String, Product > cart;
    private ArrayList<Product> productList;

    public CartService(TerminalUtils io) {
        this.io = io;
        this.cart = new HashMap<>();
        this.productList = new ArrayList<>();
        initialProducts();
    }

    public void initialProducts() {
        productList.add(new Product("Baseball", 5.99, 0));
        productList.add(new Product("Basketball", 34.99, 0));
        productList.add(new Product("Soccerball", 29.00, 0));
        productList.add(new Product("Football", 24.99, 0));
        productList.add(new Product("Desk", 350, 0));
        productList.add(new Product("Chair", 265, 0));
        productList.add(new Product("Headset", 359, 0));
    }

    // display item/s in cart
    public void displayCart() {
        if (cart.isEmpty()) {
            io.displayMessage("Cart is currently empty.");
            return;
        }
        io.displayMessage(" PRODUCT |  PRICE  |  QTY  | SUBTOTAL");
        for (Product product : cart.values()) {
            io.displayMessage(product.getDetails());
        }
        io.getString("Press enter to continue.");
    }

    // add item to cart
    public void addProduct() {
        displayProducts();
        int choice = io.getIntRequired("Select a product by number") - 1;

        if (choice < 0 || choice >= productList.size()) {
            io.displayMessage("not a valid product. choose between 1 and " + productList.size());
            return;
        }

        Product selectedProduct = productList.get(choice);
        int quantity = io.getIntRequired("Enter quantity to add to cart");

        addProductToCart(selectedProduct.getName(), selectedProduct.getPrice(), quantity);
        io.displayMessage(quantity + " " + selectedProduct.getName() +
                (quantity > 1 ? "s added to cart." : " added to cart."));
    }

    // remove item from cart


    // Cart check out
    public void checkout() {
        double total = 0;
        for (Product product : cart.values()) {
            total += product.getSubtotal();
        }
        cart.clear();
        io.displayMessage("Total Due: $" + total);
    }

    private void displayProducts(){
        io.displayMessage("Available Products");
        for (int i = 0; i < productList.size(); i++) {
            io.displayMessage(String.format((i + 1) + ". " +
                    "%-10s | $%6.2f", productList.get(i).getName(), productList.get(i).getPrice()));
        }
    }

    private void addProductToCart(String productName, double price, int quantity) {
        if (cart.containsKey(productName)) {
            cart.get(productName).addQuantity(quantity);
        } else {
            cart.put(productName, new Product(productName, price, quantity));
        }
    }

}
