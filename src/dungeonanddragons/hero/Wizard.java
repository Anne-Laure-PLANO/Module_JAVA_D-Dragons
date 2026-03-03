package dungeonanddragons.hero;

public class Wizard extends Hero {
    private String pseudo;

    public Wizard(String pseudo ){
        super( "Sorcier",  6,  8,  null, 0);
        this.pseudo = pseudo;
    }
    @Override
    public String toString() {
        return "pseudo : " + pseudo + super.toString();
    }
}
