package dungeonanddragons.entity.offensiveequipment;

import dungeonanddragons.entity.Entity;

public class OffensiveEquipment extends Entity {
    private int atk;

    public OffensiveEquipment(int boardlength, int atk) {
        super(boardlength);
    }


    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }
}
