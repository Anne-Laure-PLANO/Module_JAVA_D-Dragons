package dungeonanddragons.monster;


import dungeonanddragons.Color;
import dungeonanddragons.hero.Hero;

public class Dragon extends Monster {


    public Dragon() {
        super("Dragon", 15, 4);
    }


    public void displayAttack() {
        System.out.println("Le Dragon vous attaque ! ");
    }

    @Override
    public void displayDefense() {
        System.out.println("""
                Le dragon est blessé.
                La douleur embrase ses écailles, mais il n'en restera pas là :
                Un grondement sourd monte des profondeurs de sa gorge : il vous attaque !
                """);
    }

    public void displayIsKilled() {
        System.out.println("""
                Le dragon pousse un dernier rugissement avant de s'effondrer, faisant trembler les murs du donjon.
                Ses écailles s'éteignent une à une, comme des braises mourantes.
                Le silence retombe.
                """
        );
    }

    @Override
    public int percentageChanceToEscape(int pvHeros) {
        if (getAtk()>= pvHeros) {
            return 0;
        }else {
            return 10;
        }
    }

    public void displayEscape() {
        System.out.println("Sans chercher à vous affronter, le dragon disparait dans les ténèbres du chemin.");
    }

    public String getColor() {
        return Color.RED;
    }

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