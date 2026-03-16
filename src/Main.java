import dungeonanddragons.Game;
import dungeonanddragons.exception.OutOfBoardException;

/**
 * Classe principale du jeu Donjon et Dragons.
 * Point d'entrée de l'application.
 * @author Anne-Laure PLANO
 */
public class Main {
    /**
     * Lance le jeu avec un plateau de 65 cases.
     * @param args les arguments de la ligne de commande (non utilisés)
     * @throws OutOfBoardException si un héros dépasse les limites du plateau
     */
    public static void main(String[] args) throws OutOfBoardException {
        int boardLength = 65;

        Game game = new Game(boardLength);
        game.start();





    }
}