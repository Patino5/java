public class ShieldSpell implements Spell {
    public void cast() {
        System.out.println("A translucent barrier forms around you, absorbing the incoming strike.");
    }

    public String getIncantation() {
        return "Aegis Protectum";
    }

    public String getHelp() {
        return String.format(getIncantation() + "\t Creates a magical wall to block physical or magical attacks.");
    }
}
