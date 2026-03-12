package dungeonanddragons.equipment.consumable;

import dungeonanddragons.Color;

public class LittlePotion extends Consumable {


    public LittlePotion() {
        super( "Potion", 2);
    }


    public String draw(){
        return """
                               _____
                              `.___,'
                               (___)
                               <   >
                                ) (
                               /`-.\\
                              /     \\
                             / _    _\\
                            :,' `-.' `:
                            |         |
                            :         ;
                             \\       /
                              `.___.'    
                """;
    }
    public String getColor(){
        return Color.LIGHT_GREEN;
    }

}
