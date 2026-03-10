package dungeonanddragons.monster;


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


    public abstract void displayEscape();

    public void decreasePV (int damage ){
        if (this.getPv()> damage){
            this.pv -= damage;
        } else {
            this.isKilled();
        }
    }
    public abstract void displayIsKilled();

    @Override
    public  String toString(){
            return "\n"+
                    "__________________________ \n"+
                    "     Un " + type + " apparaît :\n" +
                    " puissance d'attaque : " + atk + "\n" +
                    "       Points de vie : " + pv + "\n" +
                    "__________________________\n";

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
