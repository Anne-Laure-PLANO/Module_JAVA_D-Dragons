package dungeonanddragons.monster;


import dungeonanddragons.Color;
import dungeonanddragons.Combat;

import java.util.Random;

public abstract class Monster implements Combat {
    private String type;
    private int pv;
    private int maxPV;
    private int atk;
    Random rand = new Random();

    public Monster(String type, int pv, int atk) {
        this.type = type;
        this.pv = pv;
        this.maxPV = pv;
        this.atk = atk;
    }

    public abstract void displayAttack ();

    public abstract void displayDefense ();

    public abstract void displayIsKilled();

    public abstract int percentageChanceToEscape(int pvHeros);

    public abstract void displayEscape();

    public abstract String getColor();

    public abstract String drawMonster();

    public boolean isMonsterEscape(int pvHeros) {
        int possibility = rand.nextInt(100)+1;
        if (possibility <= this.percentageChanceToEscape(pvHeros)) {
            this.displayEscape();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString(){
        String info = """
                __________________________
                
                 %s Un %s apparaît ! %s
                
                  Puissance d'attaque ->%s %d %s
                  Points de vie -> %s %d %s
                                    
                __________________________
                """.formatted(
                        getColor() , type , Color.RESET,
                Color.RED , atk , Color.RESET,
                Color.RED , pv, Color.RESET);

        String[] draw = drawMonster().split("\n");
        String[] details = info.split("\n");

        StringBuilder result = new StringBuilder();
        int maxLines = Math.max(draw.length, details.length);

        for (int i=0 ; i< maxLines ; i++){
            String ligneDessin = (i < draw.length) ? getColor() + draw[i] + Color.RESET : "";
            String ligneTexte = (i < details.length) ? details[i] : "";
            result.append(String.format("%-60s %s%n", ligneDessin, ligneTexte));
        }
        return result.toString();
    }

    @Override
    public void decreasePV (int damage ){
        if (this.getPv()> damage){
            this.pv -= damage;
        } else {
            this.setPv(0);
        }
    }
    @Override
    public boolean isAlive (){
        if (this.pv == 0){
            return false;
        } else {
            return true;
        }
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

    public int getMaxPV() {
        return maxPV;
    }

    public void setMaxPV(int maxPV) {
        this.maxPV = maxPV;
    }
}
