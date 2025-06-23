package inc.shopping.command;

import inc.shopping.model.Product;
import inc.shopping.service.ProductList;
import inc.shopping.service.ShoppingCartService;
import inc.shopping.view.TerminalUtils;

import java.util.ArrayList;

public class AddItemFromListCommand implements Command {
    private final ProductList availableProducts;
    private final ShoppingCartService cart;
    private final TerminalUtils io;

    public AddItemFromListCommand(ProductList availableProducts, ShoppingCartService cart, TerminalUtils io) {
        this.availableProducts = availableProducts;
        this.cart = cart;
        this.io = io;
    }

    public void execute() {
        if (availableProducts.isEmpty()) {
            io.displayMessage("No products available in catalog.");
            return;
        }

        ArrayList<Product> catalog = availableProducts.getAvailableProducts();

        io.displayMessage("\nAvailable Products:");
        io.displayMessage("NO. | PRODUCT  | PRICE");
        io.displayMessage("------------------------");

        for (int i = 0; i < catalog.size(); i++) {
            Product product = catalog.get(i);
            io.displayMessage(String.format("%2d  | %-8.8s | $%6.2f",
                    (i + 1), product.getName(), product.getPrice()));
        }

        int selection = io.getIntRangeRequired("Select product by number", 1, availableProducts.getListSize());
        Product selectedProduct = availableProducts.getProductByIndex(selection - 1);

        if (selectedProduct == null) {
            io.displayMessage("Invalid selection. Please try again.");
            return;
        }

        int quantity = io.getIntRequired("Enter quantity to add");

        Product productToAdd = new Product(selectedProduct.getName().toLowerCase(), selectedProduct.getPrice(), quantity);
        cart.addToCart(productToAdd);

        io.displayMessage(quantity + " " + selectedProduct.getName() +
                (quantity > 1 ? "s added to the cart." : " added to the cart."));
    }
}