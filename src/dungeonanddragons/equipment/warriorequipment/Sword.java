package dungeonanddragons.equipment.warriorequipment;

import dungeonanddragons.Color;

public class Sword extends WarriorEquipment {

    public Sword (){
        super("Epée", 5, "Warrior");
    }

    @Override
    public String toString() {
        return Color.SILVER_BRIGHT + """     
                                                           
                                /\\
                               /  \\
                              /    \\
                             /      \\
                             ||||||||
                             ||||||||
                             ||||||||
                             ||||||||
                             ||||||||
                            /========\\
                           /__________\\
                                ||
                                ||
                               /  \\
                              /____\\
                
                """ + Color.RESET + super.toString();
    }
}
