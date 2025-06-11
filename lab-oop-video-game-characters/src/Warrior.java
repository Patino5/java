public class Warrior extends Character{
    private String weaponType;

    public Warrior(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    public void attack() {
        System.out.println("The warrior swung the " +
                weaponType + " to attack for " +
                attackPower + " damage.");
    }
}
