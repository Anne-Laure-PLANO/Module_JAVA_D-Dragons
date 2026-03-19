package dungeonanddragons.equipment.wizardequipment;

import dungeonanddragons.Color;
import dungeonanddragons.equipment.Equipment;

/**
 * Représente un éclair dans le jeu Donjon et Dragons.
 * Équipement de mage apportant 2 points d'attaque supplémentaires.
 * @author Anne-Laure PLANO
 */
public class Flash extends WizardEquipment {

    /**
     * Constructeur de l'éclair.
     */
    public Flash (){
        super("Eclair", 2,  "Wizard");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String draw() {
        return """     
                            _________
                          //       //
                         //     //
                        //   //
                       //  //________
                      //________    //
                               // //
                              // //
                             // //
                             ////
                             //
                """;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getColor(){
        return Color.ORANGE;

    }
}
