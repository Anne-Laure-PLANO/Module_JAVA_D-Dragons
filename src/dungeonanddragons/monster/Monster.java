package dungeonanddragons.monster;

import dungeonanddragons.hero.Hero;

public abstract class Monster {
    private String type;
    private int pv;
    private int atk;

    public Monster(String type, int pv, int atk)
    {
        this.type = type;
        this.pv = pv;
        this.atk = atk;
    }

    public abstract void displayDefense ();
     //message de souffrance
    //message de contre-attaque
     //contre-attaque
         //message de fuite



    public void decreasePV (int damage ){
        if (this.getPv()> damage){
            this.pv -= damage;
        } else {
            this.isKilled();
        }
    }

    @Override
    public String toString() {
        return "Monster{" +
                "type='" + type + '\'' +
                ", pv=" + pv +
                ", atk=" + atk +
                '}';
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

    public void isKilled (){
        this.pv = 0;
    }


}
