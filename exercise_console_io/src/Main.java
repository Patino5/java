import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String userName;
        String productName;
        int quantity;
        double unitPrice;

        Scanner io = new Scanner(System.in);

        System.out.println("Welcome to the order form!");
        System.out.print("Enter your name: ");
        userName = io.nextLine();
        System.out.printf("Hello %s, let's get started with your order.%n", userName);

        System.out.print("What product would you like to purchase? ");
        productName = io.nextLine();

        System.out.print("How many would you like to purchase? ");
        quantity = Integer.parseInt(io.nextLine());

        System.out.print("What is the unit price? ");
        unitPrice = Double.parseDouble(io.nextLine());

        // Calculate totals
        double subTotal = quantity * unitPrice;
        double taxRate = 8.25;
        double taxAmount = subTotal * (taxRate / 100);
        double grandTotal = subTotal + taxAmount;

        // formated receipt
        System.out.println("Order Summary");
        System.out.println("----------------------");
        System.out.printf("Item: %14s%nQuantity: %7s%nUnit Price:     $%.2f%n", productName, quantity, unitPrice);
        System.out.println("----------------------");
        System.out.printf("Subtotal:       $%.2f%n", subTotal);
        System.out.printf("Tax (%.2f%%):    $%.2f%n", taxRate, taxAmount);
        System.out.printf("Grand Total:    $%.2f%n", grandTotal);
        System.out.println("----------------------");
        System.out.println("Thank you for your order, " + userName);

    }
}