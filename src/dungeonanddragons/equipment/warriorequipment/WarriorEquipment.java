package dungeonanddragons.equipment.warriorequipment;

import dungeonanddragons.Menu;
import dungeonanddragons.equipment.Equipment;
import dungeonanddragons.hero.Hero;

/**
 * Classe abstraite représentant un équipement de guerrier dans le jeu Donjon et Dragons.
 * Un équipement de guerrier augmente les points d'attaque du héros
 * et peut être réservé à un type de héros spécifique.
 * @author Anne-Laure PLANO
 */
public abstract class WarriorEquipment extends Equipment {

    /**
     * Constructeur d'un équipement de guerrier.
     * @param name le nom de l'équipement
     * @param atk les points d'attaque supplémentaires
     * @param userType le type de héros autorisé à utiliser l'équipement
     */
    public WarriorEquipment(String name, int atk, String userType){
        super(name, atk, 0, userType);
    }

    /**
     * {@inheritDoc}
     */
    public abstract String draw();

    /**
     * {@inheritDoc}
     */
    public abstract String getColor();


}
