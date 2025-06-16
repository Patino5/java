package org.example;

public class HealingSpell implements Spell {
    public void cast() {
        System.out.println("Warm light envelops the wounded, knitting flesh and restoring life.");
    }

    public String getIncantation() {
        return "Revive";
    }
}
