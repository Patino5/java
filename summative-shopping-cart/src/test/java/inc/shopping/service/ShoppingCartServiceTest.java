package inc.shopping.service;

import inc.shopping.model.Product;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartServiceTest {

    @Test
    public void shoppingCartInitializedAsEmpty() {
        ShoppingCartService cart = new ShoppingCartService();

        assertTrue(cart.getCart().isEmpty());
    }

    @Test
    public void canAddProductToCart() {
        ShoppingCartService cart = new ShoppingCartService();
        Product p1 = new Product("Ball", 4.99, 1);

        cart.addToCart(p1);

        assertEquals(1, cart.getCart().size());
        assertTrue(cart.getCart().containsKey("Ball"));
    }

    @Test
    public void addExistingProductToCart() {
        ShoppingCartService cart = new ShoppingCartService();
        Product p1 = new Product("Ball", 4.99, 1);
        cart.addToCart(p1);

        Product p2 = new Product("Ball", 4.99, 2);
        cart.addToCart(p2);

        assertEquals(3, cart.getCart().get("Ball").getQuantity());
        assertTrue(cart.getCart().containsKey("Ball"));
    }

    @Test
    public void returnsNullWhenProductNotInCart() {
        ShoppingCartService cart = new ShoppingCartService();
        Product p1 = new Product("Ball", 4.99, 2);

        cart.addToCart(p1);

        assertNull(cart.removeFromCart("Bat", 1));
    }

    @Test
    public void returnsNullIfRemovingTooMuch() {
        ShoppingCartService cart = new ShoppingCartService();
        Product p1 = new Product("Ball", 4.99, 2);

        cart.addToCart(p1);

        assertNull(cart.removeFromCart("Ball", 3));
    }

    @Test
    public void returnsCorrectQtyAfterRemoval() {
        ShoppingCartService cart = new ShoppingCartService();
        Product p1 = new Product("Ball", 4.99, 4);

        cart.addToCart(p1);
        cart.removeFromCart("Ball" , 2);
        int expected = 2;
        int actual = p1.getQuantity();

        assertEquals(expected, actual);
    }

    @Test
    public void removesProductIfQtyEqualsZero() {
        ShoppingCartService cart = new ShoppingCartService();
        Product p1 = new Product("Ball", 4.99, 4);
        cart.addToCart(p1);

        cart.removeFromCart("Ball" , 4);
        boolean expected = true;
        boolean actual = cart.getCart().isEmpty();

        assertEquals(expected, actual);
    }

    @Test
    public void returnZeroOnEmptyCartCheckout() {
        ShoppingCartService cart = new ShoppingCartService();

        double expected = 0;
        double actual = cart.checkout();

        assertEquals(expected, actual);
    }

    @Test
    public void returnsTotalSumOfCartAtCheckout() {
        ShoppingCartService cart = new ShoppingCartService();
        Product p1 = new Product("Ball", 4.99, 4);
        cart.addToCart(p1);
        Product p2 = new Product("Bat", 129, 2);
        cart.addToCart(p2);

        double expected = (4 * 4.99) + (129 * 2);
        double actual = cart.checkout();

        assertEquals(expected, actual);
    }
}