package dungeonanddragons.equipment.warriorequipment;

import dungeonanddragons.Color;

public class Sword extends WarriorEquipment {

    public Sword (){
        super("Epée", 5, "Warrior");
    }

    @Override
    public String draw() {
        return """     
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
                """;
    }

    public String getColor(){
        return Color.SILVER_BRIGHT;

    }
}
