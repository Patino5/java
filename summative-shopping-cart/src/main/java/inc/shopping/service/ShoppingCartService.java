package inc.shopping.service;

import inc.shopping.model.Product;
import inc.shopping.view.TerminalUtils;

import java.util.HashMap;

public class ShoppingCartService {
    private HashMap<String, Product> cart;

    public ShoppingCartService() {
        cart = new HashMap<>();
    }

    public HashMap<String, Product> getCart() {
        return new HashMap<>(cart);
    }

    public void addToCart(Product product) {
        if (cart.containsKey(product.getName())) {
            cart.get(product.getName()).addQuantity(product.getQuantity());
        } else {
            cart.put(product.getName(), product);
        }
    }

    public Product removeFromCart(String productName, int qtyToRemove) {
        if(cart.isEmpty()) {
            System.out.println("Cart Empty. No Items to remove");
            return null;
        }

        if (!cart.containsKey(productName)) return null;
        else {
            Product productToRemove = cart.get(productName);
            if (productToRemove.getQuantity() < qtyToRemove) {
                System.out.println("Number to remove must be less than or equal to " + productToRemove.getQuantity());
                return null;
            }

            productToRemove.addQuantity(-qtyToRemove);
            if (productToRemove.getQuantity() == 0) cart.remove(productName);

            return productToRemove;
        }
    }

    public double checkout() {
        double total = 0;
        if (cart.isEmpty()) return total;

        for (Product p : getCart().values()){
            total += p.getSubtotal();
            System.out.println(p.getDetails());
        }
        cart.clear();
        return total;

    }
}
