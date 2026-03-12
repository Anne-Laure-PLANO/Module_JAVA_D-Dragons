package dungeonanddragons.equipment.wizardequipment;

import dungeonanddragons.Color;

public class Fireball extends WizardEquipment {

    public Fireball (){
        super("Boule de feu", 7, "Wizard");
    }

    public String draw() {
        return """  
                    .( ).
                  .( 🔥🔥 ).
                 ( 🔥🔥🔥🔥 )
                ( 🔥🔥🔥🔥🔥 )
                 ( 🔥🔥🔥🔥 )
                  '( 🔥 )'
                    ` `
                """;
    }

    public String getColor(){
        return Color.YELLOW;

    }
}
