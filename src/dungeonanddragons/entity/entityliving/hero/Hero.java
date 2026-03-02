package dungeonanddragons.entity.entityliving.hero;

import dungeonanddragons.entity.entityliving.EntityLiving;

public class Hero extends EntityLiving {
    private String name;
    private OffensiveEquipment equipment;

    public Hero (String name, int atk, int pv, int position, boolean isAlive){
        super (name, atk, pv, position, isAlive);

    }

    public void newName (String name){
        this.name = name;
    }

    public void getEquipment (OffensiveEquipment equipment){
        if (this.equipment.getAtk() > equipment){
            //boolean playerWantsToChange = askChangeEquipment();
            if (playerWantsToChange = false) {
                //message : equipement non changé
            } else {
                this.equipment = equipment;
                //message : équipement changé
            }
        } else {
            //message : équipement installé
            this.equipment = equipment;

        }
    }


}
