package dungeonanddragons.equipment.warriorequipment;

import dungeonanddragons.Color;
import dungeonanddragons.equipment.Equipment;

public class Club extends WarriorEquipment {

    public Club() {
        super("Massue", 3,  "Warrior");
    }


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

    public String getColor(){
        return Color.BROWN_WOOD;

    }


}
