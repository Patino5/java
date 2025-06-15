import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SpellBook spellBook = new SpellBook();

        do {
            System.out.print("Enter incantation to cast a spell: ");
            String incantation = scanner.nextLine();
            spellBook.tryIncantation(incantation);
        } while (true);

    }
}
