package dungeonanddragons.exception;

/**
 * Exception levée lorsqu'un héros tente de dépasser les limites du plateau.
 * @author Anne-Laure PLANO
 */
public class OutOfBoardException extends Exception {

    /**
     * Constructeur de l'exception avec un message par défaut.
     */
    public OutOfBoardException() {
       super("Le joueur ne peut pas avancer d'autant de cases.");
    }
}
