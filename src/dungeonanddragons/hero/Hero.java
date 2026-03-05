package dungeonanddragons.hero;

import dungeonanddragons.Game;
import dungeonanddragons.Menu;
import dungeonanddragons.equipment.OffensiveEquipment;

import java.util.ArrayList;
import java.util.List;

public class Hero {
    private String pseudo;
    private String type;
    private int pv;
    private final int maxPV;
    private int atk;
    private OffensiveEquipment equipment;
    private int position;

    public  Hero(String pseudo , String type, int maxPV, int atk, OffensiveEquipment equipment, int position){
        this.pseudo = pseudo;
        this.type = type;
        this.pv = maxPV;
        this.maxPV = maxPV;
        this.atk = atk;
        this.equipment = equipment;
        this.position = position;

    }
    @Override  //chez parent car méthode existe nativement dans classe Object
    public  String  toString() {
        return "_________ " + pseudo + " _________\n" +
                "     Type : " + type + "\n" +
                "      ATK : " + atk + "\n" +
                "       PV : " + pv + "\n" +
                "Equipment : " + equipment + "\n" +
                " Position : " + position + "\n" +
                "__________________________\n";
    }

    public void cure(int quantity){
        int newPV = this.getPv()+this.getPv();

        if (this.getPv() >= this.getMaxPV()){
            this.setPv(this.getMaxPV());
        } else {
            this.setPv(newPV);
        }
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public int getMaxPV() {
        return maxPV;
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

    public void increasePV(int pvAdded) {
        if ((this.pv+pvAdded)>this.maxPV){ this.pv = this.maxPV;}
        this.pv += pvAdded;
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
