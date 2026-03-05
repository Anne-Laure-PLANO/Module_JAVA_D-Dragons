package dungeonanddragons.tile;

import dungeonanddragons.monster.Monster;

public class TileMonster extends Tile {
    private Monster content = null;

    public TileMonster(Monster content){
        this.content = content;
    }


    public Monster getContent(){
        return this.content;
    }

    public void setContent(Monster content) {
        this.content = content;
    }

    public void deleteContent(){
        this.content = null;
    }


}
