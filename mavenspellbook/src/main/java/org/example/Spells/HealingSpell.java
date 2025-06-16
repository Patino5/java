package org.example.Spells;

public class HealingSpell implements Spell {
    public void cast() {
        System.out.println("Warm light envelops the wounded, knitting flesh and restoring life.");
    }

    public String getIncantation() {
        return "Revive";
    }

    public String getHelp() {
        return String.format(getIncantation() + "\t\t Restores health and vitality to the injured");
    }
}
