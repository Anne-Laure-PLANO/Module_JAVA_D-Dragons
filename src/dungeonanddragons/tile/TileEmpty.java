package dungeonanddragons.tile;

import dungeonanddragons.Menu;
import dungeonanddragons.hero.Hero;

public class TileEmpty extends  Tile{

    public TileEmpty (){
        super("empty");
    }

    @Override
    public void interact(Hero heros, Menu menu) {
        menu.displayTileEmpty();
    }
}
