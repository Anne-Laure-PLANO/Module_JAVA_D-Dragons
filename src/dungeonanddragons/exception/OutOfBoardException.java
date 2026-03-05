package dungeonanddragons.exception;

public class OutOfBoardException extends Exception {
    public OutOfBoardException() {
       super("Le joueur ne peut pas avancer d'autant de cases.");
    }
}
