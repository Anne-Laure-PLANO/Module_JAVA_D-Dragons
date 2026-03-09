package dungeonanddragons.hero;

import dungeonanddragons.Game;
import dungeonanddragons.Menu;
import dungeonanddragons.equipment.Equipment;
import dungeonanddragons.equipment.*;

import java.util.ArrayList;
import java.util.List;

public abstract class Hero {
    private String pseudo;
    private String type;
    private int pv;
    private final int maxPV;
    private int atk;
    private Equipment equipment;
    private int position;

    public  Hero(String pseudo , String type, int maxPV, int atk, Equipment equipment, int position){
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


    public abstract void displayCombat();
        //message de guerre
        //attaque

   public void decreasePV (int damage){
       if (damage < this.getPv()){
           this.setPv(this.getPv()-damage);
       } else {
           this.setPv(0);
       }
    }

    public boolean isHeroAlive(){
       if (this.getPv()>0){
           return true;
       }return false;
    }

    public void displayVictoryCombat(){
        System.out.println("""
                Votre cri de victoire résonne dans toute la salle. 
                L'adversaire est à terre — et votre sang ne fait que chanter plus fort. 
                Vous avez gagné !
                """);
    }
    public void cure(int quantity){
        int newPV = this.getPv()+ quantity;

        if (newPV >= this.getMaxPV()){
            this.setPv(this.getMaxPV());
        } else {
            this.setPv(newPV);
        }
    }

    public int getAtkTotal(){
        if (this.getEquipment()==null){
            return this.getAtk();
        } else {
            return this.getAtk() + this.getEquipment().getAtk();
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

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }
}
