package dungeonanddragons.hero;

/**
 * Représente un mage dans le jeu Donjon et Dragons.
 * Le mage possède 6 points de vie et 8 points d'attaque de base.
 * @author Anne-Laure PLANO
 */
public class Wizard extends Hero {

    /**
     * Constructeur du mage.
     * @param pseudo le nom du mage
     */
    public Wizard(String pseudo ){
        super( pseudo, "Wizard",  6,  8,  null, 0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDraw() {
        return """
                                    ____\s
                                  .'* *.'
                               __/_*_*(_
                              / _______ \\
                             _\\_)/___\\(_/_\s
                            / _((\\- -/))_ \\
                            \\ \\())(-)(()/ /
                             ' \\(((()))/ '
                            / ' \\)).))/ ' \\
                           / _ \\ - | - /_  \\
                          (   ( .;''';. .'  )
                          _\\"__ /    )\\ __"/_
                            \\/  \\   ' /  \\/
                             .'  '...' ' )
                              / /  |  \\ \\
                             / .   .   . \\
                            /   .     .   \\
                           /   /   |   \\   \\
                         .'   /    b    '.  '.
                     _.-'    /     Bb     '-. '-._\s
                 _.-'       |      BBb       '-.  '-.\s
                (___________\\____.dBBBb.________)____)
                """;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void displayAttack() {
        System.out.println("""
                Vous attaquez :
                Vos doigts tracent des signes anciens, une lueur violette pulse entre vos paumes.
                L'obscurité obéit.
                """);
    }

}
