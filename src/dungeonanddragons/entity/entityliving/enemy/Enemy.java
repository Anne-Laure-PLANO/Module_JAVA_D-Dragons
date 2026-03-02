package dungeonanddragons.entity.entityliving.enemy;

import dungeonanddragons.entity.entityliving.EntityLiving;

import java.util.Random;

public class Enemy extends EntityLiving {

    //constructeur de la classe Enemy :
    public Enemy (String name, int atk, int pv, int position, boolean isAlive) {
        super(name, atk, pv, position, isAlive);
    }


    public void runAway (int boardLength){
        Random rand = new Random();
        System.out.println(this.getName() + " prend la fuite !");

        int newPosition ;
        if (this.getPosition()>=boardLength-1) {
            newPosition = this.getPosition() + (rand.nextInt(boardLength - this.getPosition() - 1));
        } else {
            newPosition = rand.nextInt(boardLength - 1);
        }
        this.setPosition(newPosition);
    }


}
