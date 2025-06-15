public class LightningBolt implements Spell {
    public void cast() {
        System.out.println("A crackling bolt of lightning surges from your hands, electrocuting anything in its path.");
    }

    public String getIncantation() {
        return "Fulmen Voco";
    }
}
