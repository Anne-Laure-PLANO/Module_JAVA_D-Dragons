package dungeonanddragons.entity.entityliving;

import dungeonanddragons.entity.Entity;

public class EntityLiving extends Entity {
    private String name;
    private int atk;
    private int pv;
    private boolean isAlive;


    public EntityLiving(int boardLength, String name, int atk, int pv, boolean isAlive) {
        super(boardLength);
        this.name = name;
        this.atk = atk;
        this.pv = pv;
        this.isAlive = isAlive;
    }

    public void decreasePV(int damage) {
        if (damage>this.pv){
            this.pv -= damage;
        } else {
            this.die();
        }
    }

    public void die () {
        this.pv = 0;
        this.isAlive = false;
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

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }



    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
