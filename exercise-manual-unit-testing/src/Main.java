import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner io = new Scanner(System.in);
        String[] drinks = {"water", "soda", "juice"};

        //runTest();
        selectDrink("water");
        selectDrink("juice");
        selectDrink("soda");
        selectDrink("");
        selectDrink("Tea");
        selectDrink("WATER");

    }
    public static void displayChoices(String[] choices){
        for (String choice : choices){
            System.out.println(choice);
        }
    }
    public static String selectDrink(String input){
        System.out.println("Received input: " + input);
        String inputToLowerCase = input.toLowerCase();
        System.out.println("Lowercase input: " + inputToLowerCase);
        String message = "";
        return switch (inputToLowerCase) {
            case "water" :
                message += "You selected Water";
                System.out.println("Selected: " + message);
                yield message;
            case "soda" :
                message += "You selected Soda";
                System.out.println("Selected: " + message);
                yield message;
            case "juice" :
                message += "You selected Juice";
                System.out.println("Selected: " + message);
                yield message;
            default:
                message += "Invalid selection";
                yield message;
        };
    }
    private static void runTest(){
        String[] inputs = {"water", "soda", "juice", "WATER", "Tea",""};
        String[] outputs = {"You selected Water", "You selected Soda", "You selected Juice", "You selected Water","Invalid selection", "Invalid selection"};

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