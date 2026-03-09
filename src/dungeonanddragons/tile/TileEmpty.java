package dungeonanddragons.tile;

import dungeonanddragons.Menu;
import dungeonanddragons.hero.Hero;

public class TileEmpty extends  Tile{


    @Override
    public int interaction(Hero heros, Menu menu) {
        menu.displayTileEmpty();
    return 0;
    }
}
