package dungeonanddragons.monster;


public class Witcher extends Monster {


    public Witcher() {
        super( "Sorcier", 2, 9 );
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
    public void displayEscape(){
        System.out.println("Le sorcier disparait dans une évaporation.");
    }

    public void displayIsKilled() {
        System.out.println("""
                Le mage noir vacille, ses sortilèges se retournant contre lui.
                Il se dissout lentement dans les ténèbres dont il était issu.
                Il ne reste de lui qu'une odeur de soufre et un grimoire calciné.
                """
        );
    }

    @Override
    public String toString() {
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
                
                
                """+ super.toString();
    }
}
