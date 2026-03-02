package dungeonanddragons.entity.entityliving.enemy;

public class Sorcier extends Enemy {
    private String name = "Sorcier";
    private int atk = 2;
    private int pv = 9;

    public Sorcier (int boardLength, String name, int atk, int pv, boolean isAlive) {
        super( boardLength, name, atk, pv, true );
    }
}
