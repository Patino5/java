public class HealingSpell implements Spell {
    public void cast() {
        System.out.println("Warm light envelops the wounded, knitting flesh and restoring life.");
    }

    public String getIncantation() {
        return "Salus Vitae";
    }
    public String getHelp() {
        return String.format(getIncantation() + "\t Restores health and vitality to the injured");
    }
}
