package dungeonanddragons.game;

import dungeonanddragons.entity.Entity;

import java.util.ArrayList;
import java.util.List;

    /*
    Coeur de la logique. Gère :
    - l'avancement du jeu,
    - les intéractions entre les joueurs et les ennemies
    - la fin de la partie.

Elle va orchestrer les différents éléments du jeu, tels que
- la gestion des tours,
- les combats,
- les déplacements des personnages,
- l'affichage des informations sur l'état du jeu.
     */
public class Game {
    private List<Entity> entities = new ArrayList<>() ;



    public List<Entity> getEntities() {
        return entities;
    }

    public void setEntities(List<Entity> entities) {
        entities = entities;
    }
}
