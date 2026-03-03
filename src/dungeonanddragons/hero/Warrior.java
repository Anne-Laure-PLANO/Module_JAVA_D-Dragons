package dungeonanddragons.hero;

public class Warrior extends Hero {
    private String pseudo ;

    public Warrior(String pseudo){
        super( "Guerrier",  10,  5,  null, 0);
        this.pseudo = pseudo;
    }

    @Override
    public String toString() {
        return "pseudo : " + pseudo + super.toString();
    }
}
