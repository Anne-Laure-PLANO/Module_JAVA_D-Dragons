package dungeonanddragons.equipment.warriorequipment;

import dungeonanddragons.Color;
import dungeonanddragons.equipment.Equipment;

public class Club extends WarriorEquipment {

    public Club (){
        super("Massue", 3, "Warrior");
    }


    @Override
    public String toString() {
        return Color.BROWN_WOOD + """                                                        
                         ___
                      //  @ //
                    //@     //
                    //   @ //
                   //@   //
                   // //
                  // //
                 //_//
                
                Nom : %s
                Attaque augmentée de : %d
                
                """.formatted(getName(), getAtk()) + Color.RESET;
    }
}
