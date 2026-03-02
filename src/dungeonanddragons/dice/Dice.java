package dungeonanddragons.dice;

import java.util.Random;

public class Dice {
    private static final Random rand = new Random();

    public static int throwDice() {
        return rand.nextInt(6)+1 ;
    }
}
