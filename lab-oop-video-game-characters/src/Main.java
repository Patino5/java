import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Lab Video Game Characters");
        ArrayList<Character> characters = new ArrayList<>();

        characters.add(new Mage("Gandalf", 80, 30, "Fireball"));
        characters.add(new Archer("Hawkeye", 90, 25, "Sharp"));
        characters.add(new Warrior("Thor", 100, 40, "Mjolnir"));

        for(Character character : characters) {
            character.attack();
        }
    }
}
