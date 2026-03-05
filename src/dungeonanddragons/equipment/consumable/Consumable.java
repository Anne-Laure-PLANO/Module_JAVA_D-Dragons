package dungeonanddragons.equipment.consumable;

import dungeonanddragons.equipment.Equipment;
import dungeonanddragons.hero.Hero;

public abstract class Consumable extends Equipment {
    private int pv;

    public Consumable(String name, int pv){
        super(name,0,"all");
        this.pv = pv;
    }



    public void usePotion(Hero hero){
        hero.cure(this.getPv());
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }



}
