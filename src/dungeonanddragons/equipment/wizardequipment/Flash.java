package dungeonanddragons.equipment.wizardequipment;

import dungeonanddragons.Color;
import dungeonanddragons.equipment.Equipment;

public class Flash extends WizardEquipment {

    public Flash (){
        super("Eclair", 2, "Wizard");
    }

    public String toString() {
        return Color.YELLOW + """     
                                                           
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
                          
                
                Nom : %s
                Attaque augmentée de : %d
                
                """.formatted(getName(), getAtk()) + Color.RESET;
    }
}
