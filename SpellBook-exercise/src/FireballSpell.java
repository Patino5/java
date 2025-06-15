public class FireballSpell implements Spell {
    public void cast() {
        System.out.println("A fireball explodes outward, incinerating everything in its path.");
    }

    public String getIncantation() {
        return "Ignis Orbis";
    }

    public String getHelp() {
        return String.format(getIncantation() + "\t Cast a fireball.");
    }
}
