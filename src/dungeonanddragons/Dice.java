package dungeonanddragons;

import java.util.Random;

public class Dice {
    Random rand = new Random();


    public Dice(){

    }

    public int roll(){
       int result = rand.nextInt(6)+1 ;
        return result ;
    }

}
