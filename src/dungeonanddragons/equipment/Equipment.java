package dungeonanddragons.equipment;

import dungeonanddragons.Menu;
import dungeonanddragons.hero.Hero;

public abstract class Equipment {
    private int equipmentId;
    private String name;
    private int atk = 0;
    private String userType = "all";

    public Equipment(String name, int atk, String userType){
        this.equipmentId +=1;
        this.name = name;
        this.atk = atk;
        this.userType = userType;
    }

    public abstract String toString() ;

    public abstract void interact(Hero heros, Menu menu);

    public boolean isCompatible(String typeHeros){
        if (this.getUserType().equals(typeHeros) || this.getUserType().equals("all")){
            return true;
        }
        return false;
    }

    public int getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(int equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
