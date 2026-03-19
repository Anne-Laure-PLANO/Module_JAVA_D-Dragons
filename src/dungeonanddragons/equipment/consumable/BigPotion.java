package dungeonanddragons.equipment.consumable;

import dungeonanddragons.Color;

/**
 * Représente une grande potion dans le jeu Donjon et Dragons.
 * Restaure 5 points de vie au héros qui l'utilise.
 * @author Anne-Laure PLANO
 */
public class BigPotion extends Consumable{

    /**
     * Constructeur de la grande potion.
     */
    public BigPotion() {
        super( "Grande potion", 5 );
    }

    /**
     * {@inheritDoc}
     */
    @Override
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

    /**
     * {@inheritDoc}
     */
    @Override
    public String getColor(){
        return Color.DARK_GREEN;
    }


}
