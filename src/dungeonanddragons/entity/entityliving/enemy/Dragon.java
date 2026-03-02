package dungeonanddragons.entity.entityliving.enemy;

public class Dragon extends Enemy {
    public Dragon (String name, int atk, int pv, int position, boolean isAlive) {
        super( "Dragon", 4, 15, initPosition(board.getBoardLength()), true );
    }


}
