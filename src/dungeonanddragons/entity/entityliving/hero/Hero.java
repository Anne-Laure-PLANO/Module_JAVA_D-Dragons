package dungeonanddragons.entity.entityliving.hero;

import dungeonanddragons.entity.entityliving.EntityLiving;
import dungeonanddragons.entity.offensiveequipment.OffensiveEquipment;

public class Hero extends EntityLiving {
    private OffensiveEquipment equipment;

    public Hero (int boardLength, String name, int atk, int pv, boolean isAlive){
        super(boardLength, name, atk, pv, isAlive);

    }


    public void setEquipment (OffensiveEquipment equipment){
        if (this.equipment != null){
            unsetEquipment();
        }
        this.equipment = equipment;
            this.setAtk(this.getAtk() + equipment.getAtk());
    }
    public void unsetEquipment () {
        int totalAtk = this.getAtk()-this.equipment.getAtk();
        this.setAtk(totalAtk);
        this.equipment = null;
    }


    }
