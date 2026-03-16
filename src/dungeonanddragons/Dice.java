package dungeonanddragons;

import java.util.Random;

/**
 * Représente un dé à six faces dans le jeu Donjon et Dragons.
 * @author Anne-Laure PLANO
 */
public class Dice {

    /** Générateur de nombres aléatoires */
    Random rand = new Random();

    /**
     * Constructeur du dé.
     */
    public Dice(){    }

    /**
     * Lance le dé et retourne un résultat aléatoire.
     * @return un entier entre 1 et 6
     */
    public int roll(){
        int result = rand.nextInt(6)+1 ;
        return result ;
    }

}
