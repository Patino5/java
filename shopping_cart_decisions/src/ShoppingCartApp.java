import java.util.Scanner;

public class ShoppingCartApp {
    public static void main(String[] args) {
        // Product Info
        byte productId = 1;
        byte productCategory = 2;
        double productCost = 2.56;
        double productPrice = 4.99;
        short productQuantity = 78;

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

        // print details from data collection
        System.out.println("\nDetails:");
        System.out.printf("Tax-Exempt:     %s%n", taxExempt);
        System.out.printf("Shipping:       %s%n", shipping);
        System.out.printf("Order quantity: %d%n", orderQuantity);


        // decision exercise additions
        double grandTotal = 0.00;
        double subTotal = productPrice * orderQuantity;
        double taxRate = .07;
        double standardShipping = 2.00;
        double twoDayShipping = 5.00;
        double overnightShipping = 10.00;
        boolean validPromo = false;

        System.out.printf("You're sub total before any discounts: $%.2f%n", subTotal);

        // order > $500 apply 10% discount
        if (subTotal > 500){
            subTotal = (subTotal - (subTotal * .1));
            System.out.println("Your order is over $500, you get 10% off your subtotal");
            System.out.printf("New Sub Total: $%.2f%n", subTotal);

        } else if (subTotal > 100){ // order > 100 for 5% discount
            subTotal = (subTotal - (subTotal * .05));
            System.out.println("Your order is over $100, you get 5% off your subtotal");
            System.out.printf("New Sub Total: $%.2f%n", subTotal);

        } else {
            System.out.println("No discount applied");
        }

        // tax exempt
        if (taxExempt.equals("y")){
            System.out.println("You are not charged tax");

        } else {
            System.out.println("Taxes added to Subtotal");
            subTotal += subTotal * taxRate;
        }

        System.out.println("Subtotal after applicable taxes: " + subTotal);

        // shipping options
        if (shipping.equals("y")){
            System.out.printf("Shipping options:%nStandard: %.2f%nTwo-Day:  %.2f%nOvernight: %.2f%n", standardShipping, twoDayShipping, overnightShipping);
            String shippingOption;

            while (true) {
                System.out.print("Choose a shipping option: (S)tandard, (T)wo-day, (O)vernight ");
                shippingOption = io.nextLine().toUpperCase();
                switch (shippingOption){
                    case "S":
                        System.out.print("Enter promo code for free shipping: ");
                        promoCode = io.nextLine();
                        if (promoCode.equals("free")){
                            validPromo = true;
                            break;
                        }
                        grandTotal = standardShipping;
                        break;
                    case "T":
                        System.out.println("Two Day Shipping Selected");
                        grandTotal = twoDayShipping;
                        break;
                    case "O":
                        System.out.println("Overnight Shipping Selected");
                        grandTotal = overnightShipping;
                        break;
                    default:
                        System.out.println("Not a valid option");
                        continue;
                }
                break;

            }


            if (validPromo){
                System.out.println("Free Shipping applied");

            } else {
                System.out.println("Shipping cost added to Grand Total");

            }

        } else { // not shipping
            System.out.println("Picking up order in store, no shipping cost");

        }

        grandTotal += subTotal;

        System.out.printf("Your grand total: $%.2f%n", grandTotal);


    }
}