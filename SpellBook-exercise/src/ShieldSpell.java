public class Shield implements Spell {
    public void cast() {
        System.out.println("A translucent barrier forms around you, absorbing the incoming strike.");
    }

    public String getIncantation() {
        return "Aegis Protectum";
    }
}
