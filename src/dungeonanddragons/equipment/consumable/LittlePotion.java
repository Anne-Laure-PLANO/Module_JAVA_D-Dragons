package dungeonanddragons.equipment.consumable;

import dungeonanddragons.Color;

/**
 * Représente une petite potion dans le jeu Donjon et Dragons.
 * Restaure 2 points de vie au héros qui l'utilise.
 * @author Anne-Laure PLANO
 */
public class LittlePotion extends Consumable {

    /**
     * Constructeur de la petite potion.
     */
    public LittlePotion() {
        super( "Potion", 2);
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
        return Color.LIGHT_GREEN;
    }

}
