import java.util.Scanner;

public class ShoppingCartApp {
    private static Scanner io = new Scanner(System.in);
    public static void main(String[] args) {
        // Product Info
        byte productId = 1;
        byte productCategory = 2;
        double productCost = 2.56;
        double productPrice = 4.99;
        short productQuantity = 78;
        boolean isConfirmed = false;
        Scanner io = new Scanner(System.in);

        // Write code to calculate the total cost of the product based on the inventory.
        double totalCost = productCost * productQuantity;
        System.out.println("Total Cost: " + totalCost);

        // Write code to calculate the profit in dollars of the product.
        double profit = productPrice - productCost;
        System.out.println("Profit in dollars: " + profit);

        // Write code to calculate the total potential profit.
        double potentialProfit = (profit * productQuantity);
        System.out.println("Potential total profit: " + potentialProfit);

        // Exercise for Shopping Cart Strings
        String businessName = "Visa";
        String contactInformation = "visa.com";
        String productDescription = "A global payments technology company";

        System.out.printf("Business name: %s%nContact Information: %s%nProduct Description: %s%n", businessName, contactInformation, productDescription);

        // console io additions
        String taxExempt = promptUserForString("Are you tax-exempt? (y/n) ");
        String shipping = promptUserForString("Shipping? (standard/overnight/twoday");
        int orderQuantity = promptUserForInt("Order quantity: ");
        String promoCode = promptUserForString("Promo code for free shipping: ");

        // Loops additions - isConfirmed boolean as well

        while (!isConfirmed) {
            System.out.print("Confirm Order y/n: ");
            isConfirmed = "y".equalsIgnoreCase(io.nextLine().trim());
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


        // Shipping address menu
        int addressIndex = promptMenuOption("Shipping Address: ", shippingAddresses);

        // productSize menu

        int sizeIndex = promptMenuOption("What size: ", productSizes);

        //Print details
        System.out.println("\nShipping and Size Details");
        System.out.println("Address: " + shippingAddresses[addressIndex]);
        System.out.println("Product Size: " + productSizes[sizeIndex]);

    }
    // displayChoices - parameter array - displays a list of choices from an array
    public static void displayChoices(String[] choices){
        for (int i = 0; i < choices.length; i++){
            System.out.println((i + 1) + ". " + choices[i]);
        }
    }
    // promptUserForInt - parameter is a prompt = returns an Integer
    public static int promptUserForInt(String prompt) {
        int value;
        while (true){
            try {
                System.out.print(prompt);
                value = Integer.parseInt(io.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
    // promptUserForString - parameter prompt for string - return String input
    public static String promptUserForString(String prompt) {
        System.out.print(prompt);
        return io.nextLine();
    }
    // prompt menu choices selection based on menu choices available
    public static int promptMenuOption(String prompt, String[] options) {
        int choice;
        while (true){
            displayChoices(options);
            try {
                choice = promptUserForInt(prompt);
                if (choice >= 1 && choice <= options.length){
                    return choice -1;
                } else {
                    System.out.println("Please enter a valid option.");
                }
            } catch (Exception e){
                System.out.println("Exception message: " + e.getMessage());
            }
        }
    }
}