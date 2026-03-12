package dungeonanddragons.equipment.consumable;

import dungeonanddragons.Menu;
import dungeonanddragons.equipment.Equipment;
import dungeonanddragons.hero.Hero;

public abstract class Consumable extends Equipment {

    public Consumable(String name, int pv){
        super(name,0, pv,"all");
    }

    public abstract String draw();

    public abstract String getColor();


    @Override
    public void interact(Hero heros, Menu menu) {
        heros.cure(this.getPv());
    }




}
