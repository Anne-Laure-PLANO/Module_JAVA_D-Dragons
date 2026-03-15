package dungeonanddragons.tile;

import dungeonanddragons.Menu;
import dungeonanddragons.hero.Hero;

public abstract class Tile {
    private String typeTile;

    public Tile (String typeTile){
        this.typeTile = typeTile;
    }


    public abstract void interact( Menu menu, Hero heros);


}
