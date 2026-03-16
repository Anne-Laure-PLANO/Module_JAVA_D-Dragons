package dungeonanddragons.tile;

import dungeonanddragons.Menu;
import dungeonanddragons.hero.Hero;

/**
 * Classe abstraite représentant une tuile du plateau de jeu dans Donjon et Dragons.
 * Chaque tuile possède un type et définit une interaction spécifique avec le héros.
 * @author Anne-Laure PLANO
 */
public abstract class Tile {

    /** Le type de la tuile */
    private String typeTile;

    /**
     * Constructeur d'une tuile.
     * @param typeTile le type de la tuile
     */
    public Tile (String typeTile){
        this.typeTile = typeTile;
    }

    /**
     * Définit l'interaction de la tuile avec le héros.
     * @param menu le menu du jeu
     * @param heros le héros qui interagit avec la tuile
     */
    public abstract void interact( Menu menu, Hero heros);


}
