package dungeonanddragons.monster;


import dungeonanddragons.Color;

/**
 * Représente un sorcier ennemi dans le jeu Donjon et Dragons.
 * Le sorcier possède 2 points de vie et 9 points d'attaque.
 * Il a 30% de chances de fuir, sauf s'il peut tuer le héros en un coup.
 * @author Anne-Laure PLANO
 */
public class Witcher extends Monster {

    /**
     * Constructeur du sorcier.
     */
    public Witcher() {
        super( "Sorcier", 2, 9 );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void displayAttack() {
        System.out.println("Le Sorcier vous attaque ! ");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void displayDefense() {
        System.out.println("""
                Un rictus froid tord ses lèvres. 
                Ses doigts crispés se tendent, les veines noircissent sous la peau. 
                La magie qui en jaillit sent la brûlure et la haine.
                Il vous attaque !
                """);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void displayIsKilled() {
        System.out.println("""
                Le mage noir vacille, ses sortilèges se retournant contre lui.
                Il se dissout lentement dans les ténèbres dont il était issu.
                Il ne reste de lui qu'une odeur de soufre et un grimoire calciné.
                """
        );
    }

    /**
     * {@inheritDoc}
     * Le sorcier ne fuit jamais s'il peut tuer le héros en un coup,
     * sinon il a 30% de chances de fuir.
     */
    @Override
    public int percentageChanceToEscape(int pvHeros) {
        if (getAtk()>= pvHeros) {
            return 0;
        }else {
            return 30;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void displayEscape(){
        System.out.println("Sans prévenir, le sorcier disparait dans une évaporation.");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getColor() {
        return Color.GREY_LIGHT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String drawMonster() {
        return """
                                      _,-'|
                                   ,-'._  |
                         .||,      |####\\ |
                        \\.`',/     \\####| |
                        = ,. =      |###| |
                        / || \\    ,-'\\#/,'`.
                          ||     ,'   `,,. `.
                          ,|____,' , ,;' \\| |
                         (3|\\    _/|/'   _| |
                          ||/,-''  | >-'' _,\\\\
                          ||'      ==\\ ,-'  ,'
                          ||       |  V \\ ,|
                          ||       |    |` |
                          ||       |    |   \\
                          ||       |    \\    \\
                          ||       |     |    \\
                          ||       |      \\_,-'
                          ||       |___,,--")_\\
                          ||         |_|   ccc/
                          ||        ccc/
                          ||                
                """;
    }
}
