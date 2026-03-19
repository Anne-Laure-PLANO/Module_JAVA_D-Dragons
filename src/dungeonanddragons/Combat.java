package dungeonanddragons;

/**
 * Contrat définissant les comportements communs à tout combattant.
 * Toute classe participant à un combat doit implémenter cette interface.
 * @author Anne-Laure PLANO
 */
public interface Combat {

    /**
     * Réduit les points de vie du combattant.
     * @param damage le nombre de dégâts reçus
     */
    void decreasePV(int damage);

    /**
     * Vérifie si le combattant est encore en vie.
     * @return true si les points de vie sont supérieurs à 0, false sinon
     */
    boolean isAlive();

}
