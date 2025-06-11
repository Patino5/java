public class Archer extends Character{
    private String arrowType;

    public Archer(String name, int health, int attackPower, String arrowType) {
        super(name, health, attackPower);
        this.arrowType = arrowType;
    }

    public void attack() {
        System.out.println("The Archer " + name + " fires a " +
                arrowType + " arrow to attack for " +
                attackPower + " damage.");
    }
}
