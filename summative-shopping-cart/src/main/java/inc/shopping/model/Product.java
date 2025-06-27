package inc.shopping.model;

public class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity){ // change to this.name = name;
        setName(name);
        setPrice(price);
        setQuantity(quantity);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }

    public double getSubtotal() {
        return this.quantity * this.price;
    }

    public String getDetails() {    // print details from the command terminal
        return String.format(
                "%-10.10s | $%6.2f | %5d | $%8.2f",
                getName(), getPrice(), getQuantity(), getSubtotal());
    }
}
