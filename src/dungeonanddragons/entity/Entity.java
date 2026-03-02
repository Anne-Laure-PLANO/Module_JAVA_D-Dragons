package dungeonanddragons.entity;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class Entity {
    private int position ;
    private List <Entity> Entities = new ArrayList<>() ;

    public Entity (int boardLength){
    this.position = initPosition(boardLength);
    }

    public void initPosition(int boardLength){
        Random rand = new Random();

        int position = rand.nextInt(boardLength-2);
        for (Entity entity : Entities){
            int entityPosition = entity.getPosition();
            if (position == entityPosition){
                initPosition(boardLength);
            }
        this.setPosition(position);
        }
    }


    public int getPosition() {
        return this.position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
