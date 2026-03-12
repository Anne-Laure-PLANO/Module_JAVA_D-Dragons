package dungeonanddragons.equipment.wizardequipment;

import dungeonanddragons.Color;
import dungeonanddragons.equipment.Equipment;

public class Flash extends WizardEquipment {

    public Flash (){
        super("Eclair", 2,  "Wizard");
    }

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

    public String getColor(){
        return Color.ORANGE;

    }
}
