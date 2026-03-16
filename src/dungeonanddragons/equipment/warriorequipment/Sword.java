package dungeonanddragons.equipment.warriorequipment;

import dungeonanddragons.Color;

/**
 * Représente une épée dans le jeu Donjon et Dragons.
 * Équipement de guerrier apportant 5 points d'attaque supplémentaires.
 * @author Anne-Laure PLANO
 */
public class Sword extends WarriorEquipment {

    /**
     * Constructeur de l'épée.
     */
    public Sword (){
        super("Epée", 5, "Warrior");
    }

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
    @Override
    public String getColor(){
        return Color.SILVER_BRIGHT;

    }
}
