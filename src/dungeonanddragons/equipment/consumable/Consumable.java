package dungeonanddragons.equipment.consumable;

import dungeonanddragons.Menu;
import dungeonanddragons.equipment.Equipment;
import dungeonanddragons.hero.Hero;

public abstract class Consumable extends Equipment {
    private int pv;

    public Consumable(String name, int pv){
        super(name,0,"all");
        this.pv = pv;
    }

    @Override
    public String toString(){
        return """
                      |---|
                      |   |
                    __|   |__
                   /  *   *  \\
                  |  * * * *  |
                  |   * * *   |
                  |  ~~~~~~~  |
                   \\         /
                    |_______|
                Nom : %s
                PV restaurés : %d
                """.formatted(getName(), getPv());
    }

    @Override
    public void interact(Hero heros, Menu menu) {
        heros.cure(this.getPv());
    }


    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }



}
