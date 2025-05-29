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
        System.out.printf("Hello %s, let's get started with your order.", userName);

        System.out.print("What product would you like to purchase? ");
        productName = io.nextLine();

        System.out.print("How many would you like to purchase? ");
        quantity = Integer.parseInt(io.nextLine());

        System.out.print("What is the unit price? ");
        unitPrice = Double.parseDouble(io.nextLine());




    }
}