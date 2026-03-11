package dungeonanddragons.monster;


import dungeonanddragons.Color;

public class Witcher extends Monster {


    public Witcher() {
        super( "Sorcier", 2, 9 );
    }

    public void displayAttack() {
        System.out.println("Le Sorcier vous attaque ! ");
    }

    @Override
    public void displayDefense() {
        System.out.println("""
                Un rictus froid tord ses lèvres. 
                Ses doigts crispés se tendent, les veines noircissent sous la peau. 
                La magie qui en jaillit sent la brûlure et la haine.
                Il vous attaque !
                """);
    }

    public void displayIsKilled() {
        System.out.println("""
                Le mage noir vacille, ses sortilèges se retournant contre lui.
                Il se dissout lentement dans les ténèbres dont il était issu.
                Il ne reste de lui qu'une odeur de soufre et un grimoire calciné.
                """
        );
    }

    public int percentageChanceToEscape(int pvHeros) {
        if (getAtk()>= pvHeros) {
            return 0;
        }else {
            return 30;
        }
    }

    public void displayEscape(){
        System.out.println("Sans prévenir, le sorcier disparait dans une évaporation.");
    }

    @Override
    public String getColor() {
        return Color.GREY_LIGHT;
    }

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
