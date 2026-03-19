package dungeonanddragons.monster;


import dungeonanddragons.Color;
import dungeonanddragons.hero.Hero;

/**
 * Représente un dragon dans le jeu Donjon et Dragons.
 * Le dragon possède 15 points de vie et 4 points d'attaque.
 * Il a peu de chances de fuir (10%) et ne fuit jamais s'il peut tuer le héros.
 * @author Anne-Laure PLANO
 */
public class Dragon extends Monster {

    /**
     * Constructeur du dragon.
     */
    public Dragon() {
        super("Dragon", 15, 4);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void displayAttack() {
        System.out.println("Le Dragon vous attaque ! ");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void displayDefense() {
        System.out.println("""
                Le dragon est blessé.
                La douleur embrase ses écailles, mais il n'en restera pas là :
                Un grondement sourd monte des profondeurs de sa gorge : il vous attaque !
                """);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void displayIsKilled() {
        System.out.println("""
                Le dragon pousse un dernier rugissement avant de s'effondrer, faisant trembler les murs du donjon.
                Ses écailles s'éteignent une à une, comme des braises mourantes.
                Le silence retombe.
                """
        );
    }

    /**
     * {@inheritDoc}
     * Le dragon ne fuit jamais s'il peut tuer le héros en un coup,
     * sinon il a 10% de chances de fuir.
     */
    @Override
    public int percentageChanceToEscape(int pvHeros) {
        if (getAtk()>= pvHeros) {
            return 0;
        }else {
            return 10;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void displayEscape() {
        System.out.println("Sans chercher à vous affronter, le dragon disparait dans les ténèbres du chemin.");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getColor() {
        return Color.RED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String drawMonster() {
        return """
                             ^                       ^
                             |\\   \\        /        /|
                            /  \\  |\\__  __/|       /  \\
                           / /\\ \\ \\ _ \\/ _ /      /    \\
                          / / /\\ \\ {*}\\/{*}      /  / \\ \\
                          | | | \\ \\( (00) )     /  // |\\ \\
                          | | | |\\ \\(V""V)\\    /  / | || \\|
                          | | | | \\ |^--^| \\  /  / || || ||
                         / / /  | |( WWWW__ \\/  /| || || ||
                        | | | | | |  \\______\\  / / || || ||
                        | | | / | | )|______\\ ) | / | || ||
                        / / /  / /  /______/   /| \\ \\ || ||
                       / / /  / /  /\\_____/  |/ /__\\ \\ \\ \\ \\
                       | | | / /  /\\______/    \\   \\__| \\ \\ \\
                       | | | | | |\\______ __    \\_    \\__|_| \\
                       | | ,___ /\\______ _  _     \\_       \\  |
                       | |/    /\\_____  /    \\      \\__     \\ |    /\\
                       |/ |   |\\______ |      |        \\___  \\ |__/  \\
                       v  |   |\\______ |      |            \\___/     |
                          |   |\\______ |      |                    __/
                           \\   \\________\\_    _\\               ____/
                         __/   /\\_____ __/   /   )\\_,      _____/
                        /  ___/  \\uuuu/  ___/___)    \\______/
                        VVV  V        VVV  V
                """;
    }

}