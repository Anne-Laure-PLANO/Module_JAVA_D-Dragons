import dungeonanddragons.Game;
import dungeonanddragons.exception.OutOfBoardException;
import dungeonanddragons.hero.Hero;
import dungeonanddragons.Menu;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws OutOfBoardException {
        int boardLength = 65;

        Game game = new Game(boardLength);
        game.start();





    }
}