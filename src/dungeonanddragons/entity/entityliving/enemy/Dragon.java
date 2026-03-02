package dungeonanddragons.entity.entityliving.enemy;

import dungeonanddragons.board.Board;

public class Dragon extends Enemy {
    private String name = "Dragon";
    private int atk = 4;
    private int pv = 15;

    public Dragon (int boardLength, String name, int atk, int pv, boolean isAlive) {
        super( boardLength, name, atk, pv, true );
    }


}
