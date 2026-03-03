package dungeonanddragons.hero;

import dungeonanddragons.Game;
import dungeonanddragons.equipment.OffensiveEquipment;

import java.util.ArrayList;
import java.util.List;

public class Hero {
    private String type;
    private int pv;
    private int atk;
    private OffensiveEquipment equipment;
    private int position;

    public Hero(String type, int pv, int atk, OffensiveEquipment equipment, int position){
        this.type = type;
        this.pv = pv;
        this.atk = atk;
        this.equipment = equipment;
        this.position = position;

    }

    @Override
    public String toString() {
        return "type='" + type + '\'' +
                ", pv=" + pv +
                ", atk=" + atk +
                ", Equipment=" + equipment +
                ", Position= " + position +
                '}';
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public OffensiveEquipment getEquipment() {
        return equipment;
    }

    public void setEquipment(OffensiveEquipment equipment) {
        this.equipment = equipment;
    }
}
