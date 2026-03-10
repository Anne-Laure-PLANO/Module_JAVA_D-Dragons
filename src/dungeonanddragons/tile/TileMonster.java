package dungeonanddragons.tile;

import dungeonanddragons.Menu;
import dungeonanddragons.hero.Hero;
import dungeonanddragons.monster.Monster;

public class TileMonster extends Tile {
    private Monster content = null;

    public TileMonster(Monster content){
        super("monster");
        this.content = content;
    }


    @Override
    public void interact(Hero heros, Menu menu) {
        menu.displayTileMonster(this.getContent().toString());

        // le héros attaque :
        heros.displayAttack();
        this.getContent().decreasePV(heros.getAtkTotal());

        if (this.isMonsterAlive()) {
            this.getContent().displayDefense();
            this.getContent().displayEscape();
            heros.decreasePV(this.getContent().getAtk());
        } else {
            this.getContent().displayIsKilled();
            heros.displayVictoryCombat();
        }
    }


    public boolean isMonsterAlive(){
        if (this.getContent().getPv()>0){
            return true;
        } return false;
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
