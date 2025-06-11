public class Warrior extends Character{
    private String weaponType;

    public Warrior(String name, int health, int attackPower, String weaponType) {
        super(name, health, attackPower);
        this.weaponType = weaponType;
    }

    public void attack() {
        System.out.println("The warrior swung the " +
                weaponType + " to attack for " +
                attackPower + " damage.");
    }
}
