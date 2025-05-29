//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String firstName = "Harry";
        String lastName = "Potter";
        String fullName = firstName + " " + lastName;

        System.out.println("Full name: " + fullName);
        System.out.println("Length: " + fullName.length());

        char firstLetter = fullName.charAt(0);
        System.out.println("First character: " + firstLetter);
        System.out.println("Index of 'r': " + fullName.indexOf('r'));

        // Part 2 Extracting Parts of a String
        String sentence = "Learning Java is fun!";
        System.out.println("First word: " + sentence.substring(0, 8));
        System.out.println("Second word: " + sentence.substring(9,13));
        System.out.println("Last word: " + sentence.substring(17));

        //Part 3 Splitting Strings
        String csvData = "apple,banana,grape,orange";
        String[] fruits = csvData.split(",");

        for (int i = 0; i < fruits.length; i++){
            System.out.printf("Fruit %d: %s%n", i, fruits[i]);
        }
    }
}