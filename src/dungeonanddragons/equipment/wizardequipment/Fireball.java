package dungeonanddragons.equipment.wizardequipment;

import dungeonanddragons.Color;

/**
 * Représente une boule de feu dans le jeu Donjon et Dragons.
 * Équipement de mage apportant 7 points d'attaque supplémentaires.
 * @author Anne-Laure PLANO
 */
public class Fireball extends WizardEquipment {

    /**
     * Constructeur de la boule de feu.
     */
    public Fireball (){
        super("Boule de feu", 7, "Wizard");
    }

    /**
     * {@inheritDoc}
     */
    @Override
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

    /**
     * {@inheritDoc}
     */
    @Override
    public String getColor(){
        return Color.YELLOW;

    }
}
