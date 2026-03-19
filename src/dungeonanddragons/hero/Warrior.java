package dungeonanddragons.hero;

/**
 * Représente un guerrier dans le jeu Donjon et Dragons.
 * Le guerrier possède 10 points de vie et 5 points d'attaque de base.
 * @author Anne-Laure PLANO
 */
public class Warrior extends Hero {

    /**
     * Constructeur du guerrier.
     * @param pseudo le nom du guerrier
     */
    public Warrior(String pseudo) {
        super(pseudo, "Warrior", 10, 5, null, 0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDraw() {
        return  """
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
                """;
    }

    /**
     * {@inheritDoc}
     */
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

}