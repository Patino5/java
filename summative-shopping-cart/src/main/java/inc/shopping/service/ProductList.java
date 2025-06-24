package inc.shopping.service;

import inc.shopping.model.Product;

import java.util.ArrayList;

public class ProductList {
    private final ArrayList<Product> availableProducts;

    public ProductList() {
        this.availableProducts = new ArrayList<>();
        initializeAvailableProducts();
    }

    private void initializeAvailableProducts() {
        availableProducts.add(new Product("Apple", .99, 0));
        availableProducts.add(new Product("Orange", .89, 0));
        availableProducts.add(new Product("Banana", .79, 0));
        availableProducts.add(new Product("Milk", 4.89, 0));
        availableProducts.add(new Product("Cheese", 4.50, 0));
        availableProducts.add(new Product("Ham", 7.99, 0));
        availableProducts.add(new Product("Butter", 5.99, 0));
        availableProducts.add(new Product("Egg", 9.99, 0));
    }

    public ArrayList<Product> getAvailableProducts() {
        return  new ArrayList<>(availableProducts);
    }

    public Product getProductByIndex(int index) {
        if (index < 0 || index >= availableProducts.size()) {
            return null;
        }
        return availableProducts.get(index);
    }

    public int getListSize() {
        return availableProducts.size();
    }

    public boolean isEmpty() {
        return availableProducts.isEmpty();
    }
}
