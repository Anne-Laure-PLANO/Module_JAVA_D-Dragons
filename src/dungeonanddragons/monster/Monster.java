package dungeonanddragons.monster;

import dungeonanddragons.hero.Hero;

public class Monster {
    private String type;
    private int pv;
    private int atk;
    private int position;

    public Monster(String type, int pv, int atk, int position)
    {
        this.type = type;
        this.pv = pv;
        this.atk = atk;
        this.position = position;
    }

    public int decreasePV (int damage ){
        return this.pv -= damage;
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


    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int isKilled (){
        return this.pv = 0;
    }


}
