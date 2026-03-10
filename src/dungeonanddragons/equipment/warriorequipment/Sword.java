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
                
                Nom : %s
                Attaque augmentée de : %d
                
                """.formatted(getName(), getAtk()) + Color.RESET;
    }
}
