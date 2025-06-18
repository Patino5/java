package inc.shopping.service;

import inc.shopping.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {

    @BeforeEach
    void setUp() {
        ArrayList<Product> cart = new ArrayList<>();
    }

    @Test
    void testAddProduct() {
        //ARRANGE
        ArrayList<Product> cart = new ArrayList<>();
        Product newProduct = new Product("testProduct", 1.00, 2);
        int expected = 1;
        // ACT
        cart.add(newProduct);
        int actual = cart.size();
        // ASSERT
        Assertions.assertEquals(expected, actual);
    }
}