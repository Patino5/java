import java.util.Scanner;

public class ShoppingCartApp {
    public static void main(String[] args) {
        // Product Info
        byte productId = 1;
        byte productCategory = 2;
        double productCost = 2.56;
        double productPrice = 4.99;
        short productQuantity = 78;
        boolean isConfirmed = false;

        // Write code to calculate the total cost of the product based on the inventory.
        // Print the value.
        double totalCost = productCost * productQuantity;
        System.out.println("Total Cost: " + totalCost);

        // Write code to calculate the profit in dollars of the product.
        // Print the value.
        double profit = productPrice - productCost;
        System.out.println("Profit in dollars: " + profit);

        // Write code to calculate the total potential profit.
        // Print the value.
        double potentialProfit = (profit * productQuantity);
        System.out.println("Potential total profit: " + potentialProfit);

        // Exercise for Shopping Cart Strings
        String businessName = "Visa";
        String contactInformation = "visa.com";
        String productDescription = "A global payments technology company";

        System.out.printf("Business name: %s%nContact Information: %s%nProduct Description: %s%n", businessName, contactInformation, productDescription);

        // console io additions
        Scanner io = new Scanner(System.in);
        String taxExempt;
        String shipping;
        int orderQuantity;
        String promoCode;

        // collect data
        System.out.print("Are you tax-exempt? (y/n) ");
        taxExempt = io.nextLine();
        System.out.print("Shipping (y/n) ");
        shipping = io.nextLine();
        System.out.print("Order quantity? ");
        orderQuantity = Integer.parseInt(io.nextLine());
        System.out.print("Promo code for free shipping: ");
        promoCode = io.nextLine();

        // Loops additions - isConfirmed boolean as well

        while (!isConfirmed) {
            System.out.println("Confirm Order y/n: ");
            isConfirmed = "y".equals(io.nextLine());
        }

        // print details from data collection
        System.out.println("\nDetails:");
        System.out.printf("Tax-Exempt:     %s%n", taxExempt);
        System.out.printf("Shipping:       %s%n", shipping);
        System.out.printf("Order quantity: %d%n", orderQuantity);
        System.out.printf("Promo code:     %s%n", promoCode);

        // Arrays additions
        String[] shippingAddresses = {"123 Main St", "456 Main St", "789 Main St"};
        String[] productSizes = {"small", "medium", "large"};

        int addressIndex = 0;
        int sizeIndex = 0;
        // Shipping address menu
        for (int i = 0; i < shippingAddresses.length; i++){
            System.out.println((i+1) + ". " + shippingAddresses[i]);;
        }
        System.out.print("Shipping Address? ");
        String address = io.nextLine();
        addressIndex = Integer.parseInt(address);

        // productSize menu
        for (int i = 0; i < productSizes.length; i++){
            System.out.println((i + 1) + ". " + productSizes[i]);
        }
        System.out.print("Select size? ");
        String size = io.nextLine();
        sizeIndex = Integer.parseInt(size);

        //Print details
        System.out.println("\nShipping and Size Details");
        System.out.println("Address: " + shippingAddresses[addressIndex -1]);
        System.out.println("Product Size: " + productSizes[sizeIndex - 1]);

    }
}