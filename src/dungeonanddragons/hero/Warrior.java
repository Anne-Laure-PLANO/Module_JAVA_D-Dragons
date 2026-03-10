package dungeonanddragons.hero;


public class Warrior extends Hero {

    public Warrior(String pseudo) {
        super(pseudo, "Warrior", 10, 5, null, 0);
    }


    @Override
    public void displayAttack() {
        System.out.println("""
                 Vous attaquez : 
                 Le sol tremble sous ses pas. 
                 Les muscles bandés, la mâchoire serrée, il lève son arme vers le ciel — un cri de guerre déchire le silence. 
                 Le sang lui pulse dans les tempes. Il charge.
                 """

        );


    }
    public String displayHero() {
        return """
                 /\\
                 ||
                 ||
                 ||
                 ||           {}
                 ||          .--.
                 ||         /.--.\\
                 ||         |====|
                 ||         |`::`|
                _||_    .-;`\\..../`;_.-^-._
                 /\\\\   /  |...::..|`   :   `|
                 |:'\\ |   /'''::''|   .:.   |
                  \\ /\\;-,/\\   ::  |..:::::..|
                   \\ <` >  >._::_.| ':::::' |
                    `""`  /   ^^  |   ':'   |
                          |       \\    :    /
                          |        \\   :   /
                          |___/\\___|`-.:.-`
                           \\_ || _/    `
                           <_ >< _>
                           |  ||  |
                           |  ||  |
                          _\\.:||:./_
                         /____/\\____\\
                
                """
                +super.toString();
    }
}