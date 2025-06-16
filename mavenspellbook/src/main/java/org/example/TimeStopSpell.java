package org.example;

public class TimeStopSpell implements Spell {
    @Override
    public void cast() {
        System.out.println("Time halts around you, the world frozen as you move freely through stillness.");
    }

    @Override
    public String getIncantation() {
        return "halt";
    }
}
