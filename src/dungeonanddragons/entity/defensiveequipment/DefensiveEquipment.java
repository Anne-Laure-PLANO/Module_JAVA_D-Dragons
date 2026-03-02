package dungeonanddragons.entity.defensiveequipment;

import dungeonanddragons.entity.Entity;

public class DefensiveEquipment extends Entity {
    private int pv;

    public DefensiveEquipment(int boardlength, int pv) {
        super(boardlength);
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }
}
