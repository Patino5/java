package org.example;

public class LightningBoltSpell implements Spell {
    public void cast() {
        System.out.println("A crackling bolt of lightning surges from your hands, electrocuting anything in its path.");
    }

    public String getIncantation() {
        return "Lightning Bolt";
    }
    public String getHelp() {
        return String.format(getIncantation() + "\t Fires a crackling bolt of electricity.");
    }
}
