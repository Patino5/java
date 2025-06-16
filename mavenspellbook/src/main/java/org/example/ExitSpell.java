package org.example;

public class ExitSpell implements Spell {
    public void cast() {
        System.out.println("A portal opens beneath your feet. Goodbye, wizard");
        System.exit(0);
    }

    public String getIncantation() {
        return "Quit";
    }

    public String getHelp() {
        return String.format(getIncantation() + "\t\t Opens a portal to another dimension/ quits program");
    }
}