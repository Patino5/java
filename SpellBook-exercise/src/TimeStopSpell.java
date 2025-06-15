public class TimeStopSpell implements Spell {
    public void cast() {
        System.out.println("Time halts around you, the world frozen as you move freely through stillness.");
    }

    public String getIncantation() {
        return "Tempora Fractum";
    }

    public String getHelp() {
        return String.format(getIncantation() + "\t Freeze time around you for a short duration");
    }
}
