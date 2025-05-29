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


    }
}