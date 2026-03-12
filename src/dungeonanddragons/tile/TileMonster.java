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

            // le héros attaque :
            heros.displayAttack();
            this.getContent().decreasePV(heros.getAtkTotal());
            menu.displayMonsterPV(getContent().getColor(), getContent().getType(), heros.getAtkTotal(), getContent().getPv(), getContent().getMaxPV());

            if (this.isMonsterAlive()) {
                //le monstre contre-attaque
                this.getContent().displayDefense();
                heros.decreasePV(this.getContent().getAtk());
                menu.displayHeroPV(heros.getPv(), heros.getMaxPV());

            } else {
                this.getContent().displayIsKilled();
                heros.displayVictoryCombat();
            }
    }

    public void monsterAttack(Hero heros,  Menu menu) {
        this.getContent().displayAttack();
        heros.decreasePV(this.getContent().getAtk());
        menu.displayHeroPV(heros.getPv(), heros.getMaxPV());

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
