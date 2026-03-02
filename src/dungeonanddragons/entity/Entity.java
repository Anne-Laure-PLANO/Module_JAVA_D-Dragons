package dungeonanddragons.entity;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import dungeonanddragons.board.Board;
import dungeonanddragons.game.Game;

public class Entity {
    private int position ;
    private static final Random rand = new Random();

    public Entity (int boardLength){
    this.position = initPosition(boardLength);
    }

    public int initPosition(int boardLength) {
        int position = rand.nextInt(boardLength - 4) + 2;
        for (Entity entity : Game.getEntities()) {
            if (entity.getPosition() == (position)) {
                position = initPosition(boardLength);
            }
        }
        return position;
    }



    public int getPosition() {
        return this.position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
