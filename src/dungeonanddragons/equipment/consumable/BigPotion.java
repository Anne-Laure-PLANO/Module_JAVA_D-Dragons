package dungeonanddragons.equipment.consumable;

import dungeonanddragons.Color;

public class BigPotion extends Consumable{

    public BigPotion() {
        super( "Grande potion", 5 );
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
        return Color.DARK_GREEN;
    }


}
