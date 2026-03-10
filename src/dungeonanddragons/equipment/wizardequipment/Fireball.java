package dungeonanddragons.equipment.wizardequipment;

import dungeonanddragons.Color;

public class Fireball extends WizardEquipment {

    public Fireball (){
        super("Boule de feu", 7, "Wizard");
    }

    public String toString() {
        return Color.ORANGE + """  
                   
                .( ).
              .( 🔥🔥 ).
             ( 🔥🔥🔥🔥 )
            ( 🔥🔥🔥🔥🔥 )
             ( 🔥🔥🔥🔥 )
              '( 🔥 )'
                ` `
                
                Nom : %s
                Attaque augmentée de : %d
                
                """.formatted(getName(), getAtk()) + Color.RESET;
    }
}
