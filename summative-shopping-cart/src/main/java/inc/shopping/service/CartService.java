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
        productList.add(new Product("Soccer ball", 29.00, 0));
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
    public void removeProduct(){
        if (cart.isEmpty()){
            io.displayMessage("Cart is empty.");
            return;
        }

        displayCart();
        String productName = io.getStringRequired("Enter the name of Product you want to remove");

        if (!cart.containsKey(productName)){
            io.displayMessage("Item: " + productName + " not found in cart.");
            return;
        }

        Product productToRemove = cart.get(productName);

        int productCurrentQuantity = productToRemove.getQuantity();
        io.displayMessage("Current quantity: " + productCurrentQuantity);
        int qtyToRemove = io.getIntRequired("Enter quantity to remove");

        if (qtyToRemove > productCurrentQuantity || qtyToRemove <= 0) {
            io.displayMessage((productCurrentQuantity >  1 ? "Must be between 1 and " + productCurrentQuantity + "." : "Enter 1 for last item."));
            return;
        }
        if (qtyToRemove == productCurrentQuantity){
            io.displayMessage("All " + productName + " removed from cart.");
            cart.remove(productName);
        } else {
            io.displayMessage(String.format("%d %s removed from cart.", qtyToRemove, productName));
            productToRemove.addQuantity(-qtyToRemove);
        }
    }

    // Cart check out
    public void checkout() {
        double total = 0;
        int itemTotal = 0;
        Product productDetails;

        io.displayMessage("Scanning items in cart...");

        for (String key : cart.keySet()){
            productDetails = cart.get(key);
            io.displayMessage("Scanning..." + productDetails.getQuantity() +
                    " " + productDetails.getName() +
                    (productDetails.getQuantity() > 1 ? "s. " : ". "));

            total += cart.get(key).getSubtotal();
            itemTotal += cart.get(key).getQuantity();
        }

        cart.clear();
        io.displayMessage("Total Items: "+ itemTotal + "\nTotal Due: $" + total);
        io.getString("\nPress enter to continue");
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
