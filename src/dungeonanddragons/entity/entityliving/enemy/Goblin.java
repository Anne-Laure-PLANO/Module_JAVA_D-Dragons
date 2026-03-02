package dungeonanddragons.entity.entityliving.enemy;

public class Goblin extends Enemy {
    public Goblin(String name, int atk, int pv, int position, boolean isAlive) {
        super("Gobelin", 1, 6, initPosition(board.getBoardLength()), true);
    }
}
