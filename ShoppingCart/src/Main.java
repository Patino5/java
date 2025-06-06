import java.util.Scanner;

public class Main {
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

    }
}