package dungeonanddragons.equipment.warriorequipment;

import dungeonanddragons.Color;

/**
 * Représente une massue dans le jeu Donjon et Dragons.
 * Équipement de guerrier apportant 3 points d'attaque supplémentaires.
 * @author Anne-Laure PLANO
 */
public class Club extends WarriorEquipment {

    /**
     * Constructeur de la massue.
     */
    public Club() {
        super("Massue", 3,  "Warrior");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String draw() {
        return """     
                         ___
                      //  @ //
                    //@     //
                    //   @ //
                   //@   //
                   // //
                  // //
                 //_//
                """;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getColor(){
        return Color.BROWN_WOOD;

    }


}
