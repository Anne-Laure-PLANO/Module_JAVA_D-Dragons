package dungeonanddragons.equipment.consumable;

import dungeonanddragons.Menu;
import dungeonanddragons.equipment.Equipment;
import dungeonanddragons.hero.Hero;

/**
 * Classe abstraite représentant un consommable dans le jeu Donjon et Dragons.
 * Un consommable est un équipement utilisable par tous les héros qui restaure des points de vie.
 * @author Anne-Laure PLANO
 */
public abstract class Consumable extends Equipment {

    /**
     * Constructeur d'un consommable.
     * @param name le nom du consommable
     * @param pv les points de vie restaurés
     */
    public Consumable(String name, int pv){
        super(name,0, pv,"all");
    }

    /**
     * {@inheritDoc}
     */
    public abstract String draw();

    /**
     * {@inheritDoc}
     */
    public abstract String getColor();

    /**
     * {@inheritDoc}
     * Soigne le héros en lui restaurant les points de vie du consommable.
     */
    @Override
    public void interact(Hero heros, Menu menu) {
        heros.cure(this.getPv());
    }




}
