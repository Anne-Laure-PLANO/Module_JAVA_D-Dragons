package dungeonanddragons.monster;


import dungeonanddragons.Color;
import dungeonanddragons.Combat;

import java.util.Random;
/**
 * Classe abstraite représentant un monstre dans le jeu Donjon et Dragons.
 * Tout monstre implémente l'interface {@link Combat} et possède un type,
 * des points de vie et une puissance d'attaque.
 * @author Anne-Laure PLANO
 */
public abstract class Monster implements Combat {

    /** Le type du monstre */
    private String type;
    /** Les points de vie actuels du monstre */
    private int pv;
    /** Les points de vie maximum du monstre */
    private int maxPV;
    /** Les points d'attaque du monstre */
    private int atk;
    /** Générateur de nombres aléatoires */
    Random rand = new Random();

    /**
     * Constructeur d'un monstre.
     * @param type le type du monstre
     * @param pv les points de vie de départ
     * @param atk les points d'attaque
     */
    public Monster(String type, int pv, int atk) {
        this.type = type;
        this.pv = pv;
        this.maxPV = pv;
        this.atk = atk;
    }

    /**
     * Affiche le message d'attaque propre à chaque monstre.
     */
    public abstract void displayAttack ();

    /**
     * Affiche le message de défense propre à chaque monstre.
     */
    public abstract void displayDefense ();

    /**
     * Affiche le message de mort propre à chaque monstre.
     */
    public abstract void displayIsKilled();

    /**
     * Calcule le pourcentage de chance que le monstre fuie.
     * @param pvHeros les points de vie actuels du héros
     * @return le pourcentage de chance de fuite (0-100)
     */
    public abstract int percentageChanceToEscape(int pvHeros);

    /**
     * Affiche le message de fuite propre à chaque monstre.
     */
    public abstract void displayEscape();

    /**
     * Retourne la couleur associée au monstre pour l'affichage.
     * @return la couleur sous forme de String
     */
    public abstract String getColor();

    /**
     * Retourne le dessin ASCII propre à chaque monstre.
     * @return le dessin sous forme de String
     */
    public abstract String drawMonster();

    /**
     * {@inheritDoc}
     */
    @Override
    public void decreasePV (int damage ){
        if (this.getPv()> damage){
            this.pv -= damage;
        } else {
            this.setPv(0);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isAlive (){
        if (this.pv == 0){
            return false;
        } else {
            return true;
        }
    }

    /**
     * Détermine aléatoirement si le monstre tente de fuir le combat.
     * @param pvHeros les points de vie actuels du héros
     * @return true si le monstre fuit, false sinon
     */
    public boolean isMonsterEscape(int pvHeros) {
        int possibility = rand.nextInt(100)+1;
        if (possibility <= this.percentageChanceToEscape(pvHeros)) {
            this.displayEscape();
            return true;
        } else {
            return false;
        }
    }

    /**
     * {@inheritDoc}
     */
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
