package dungeonanddragons.hero;


public class Wizard extends Hero {
    private String pseudo;

    public Wizard(String pseudo ){
        super( pseudo, "Sorcier",  6,  8,  null, 0);
    }

    @Override
    public void displayCombat() {

    }
}
