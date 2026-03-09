package dungeonanddragons.tile;

import dungeonanddragons.Menu;
import dungeonanddragons.hero.Hero;
import dungeonanddragons.monster.Monster;

public class TileMonster extends Tile {
    private Monster content = null;

    public TileMonster(Monster content){
        this.content = content;
    }


    @Override
    public int interaction(Hero heros, Menu menu) {
        menu.displayTileMonster(this.getContent().toString());

        // le héros attaque :
        heros.displayCombat();
        this.getContent().decreasePV(heros.getAtkTotal());

        if (this.isMonsterAlive()){
            this.getContent().displayDefense();
            heros.decreasePV(this.getContent().getAtk());

            if (heros.isHeroAlive()) {
                //board.modifyEmplacmentTile(this);
                return 1;
            }else{
                //GameOver
                return 3;
            }

        }  else {
            heros.displayVictoryCombat();
            // board.cleanTile(this);
            return 2;
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
