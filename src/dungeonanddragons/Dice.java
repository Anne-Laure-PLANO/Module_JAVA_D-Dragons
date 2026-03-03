package dungeonanddragons;

import java.util.Random;

public class Dice {
    Random rand = new Random();


    public Dice(){

    }

    public int roll(int diceFaces){
        return rand.nextInt(diceFaces)+1;
    }

}
