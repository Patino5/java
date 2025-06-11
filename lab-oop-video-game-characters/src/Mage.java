public class Mage extends Character{
    private String spell;

    public Mage(String name, int health, int attackPower, String spell) {
        super(name, health, attackPower);
        this.spell = spell;
    }

    public void attack() {
        System.out.println("The Mage cast the " +
                spell + " spell to attack for " +
                attackPower + " damage.");
    }
}
