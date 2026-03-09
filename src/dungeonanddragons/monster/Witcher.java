package dungeonanddragons.monster;

import dungeonanddragons.hero.Hero;

public class Witcher extends Monster {


    public Witcher() {
        super( "Sorcier", 2, 9 );
    }

    @Override
    public void displayDefense() {
        System.out.println("""
                Un rictus froid tord ses lèvres. 
                La douleur... intéressante. 
                Ses doigts crispés se tendent, les veines noircissent sous la peau. 
                Il puise dans sa souffrance même pour alimenter le sort. 
                La magie qui jaillit sent la brûlure et la haine.
                """);
    }
}
