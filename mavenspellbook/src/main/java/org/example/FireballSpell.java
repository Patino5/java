package org.example;

public class FireballSpell implements Spell{

    public String getIncantation() {
        return "Fireball";
    }

    public void cast() {
        System.out.println("A fireball is hurled through the air at your target");
    }

    public String getHelp() {
        return String.format(getIncantation() + "\t Cast a fireball.");
    }
}
