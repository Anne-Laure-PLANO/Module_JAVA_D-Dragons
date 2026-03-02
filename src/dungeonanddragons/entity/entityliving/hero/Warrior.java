package dungeonanddragons.entity.entityliving.hero;

public class Warrior extends Hero {
    private int atk = 5 ;
    private int pv = 10 ;

    public Warrior(int boardLength, String name, int atk, int pv, boolean isAlive) {
        super(boardLength, name, atk, pv, isAlive);
    }
}
