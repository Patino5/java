import java.util.ArrayList;

public class SpellBook {
     private ArrayList<Spell> spells;

     public SpellBook() {
          spells = new ArrayList<>();
          spells.add(new FireballSpell());
          spells.add(new HealingSpell());
          spells.add(new ShieldSpell());
          spells.add(new LightningBoltSpell());
          spells.add(new TimeStopSpell());
          spells.add(new ExitSpell());
     }

     public void tryIncantation(String incantation) {
          if (incantation.equalsIgnoreCase("help")){
               help();
               return;
          }
          for (Spell spell : spells){
               if (spell.getIncantation().equalsIgnoreCase(incantation.trim())) {
                    spell.cast();
                    return;
               }

          }
          System.out.println("The spell fizzled out! Try again!");
     }

     public void help() {
          System.out.println("\nIncantation\t| Description");
          for (Spell spell : spells){
               System.out.println(spell.getHelp());
          }
          System.out.println();
     }
}
