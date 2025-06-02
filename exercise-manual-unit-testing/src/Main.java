import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner io = new Scanner(System.in);
        String[] drinks = {"water", "soda", "juice"};

        runTest();

    }
    public static void displayChoices(String[] choices){
        for (String choice : choices){
            System.out.println(choice);
        }
    }
    public static String selectDrink(String input){
        return switch (input) {
            case "water" -> "You selected Water";
            case "soda" -> "You selected Soda";
            case "juice" -> "You selected Juice";
            default -> "Invalid selection";
        };
    }
    private static void runTest(){
        String[] inputs = {"water", "soda", "juice"};
        String[] outputs = {"You selected Water", "You selected Soda", "You selected Juice"};

        for (int i = 0; i < inputs.length; i++){
            String input = inputs[i];
            String output = outputs[i];
            System.out.print("Testing with " + input + "...");
            String actual = selectDrink(input);

            if (output.equals(actual)) {
                System.out.println("Passed!");
            }  else {
                System.out.println("Fail: Expected '" + output + "', got '" + actual + "'");;
            }
        }
    }
}