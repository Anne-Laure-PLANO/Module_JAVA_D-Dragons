package dungeonanddragons.monster;

import dungeonanddragons.hero.Hero;

public class Goblin extends Monster {

    public Goblin () {
        super("Gobelin", 1, 6);
    }

    @Override
    public void displayDefense() {
        System.out.println("""
                Il pousse un couinement aigu, mi-douleur mi-rage. 
                Ses petits yeux jaunes s'injectent de sang. 
                Il trépigne, bave, grogne — puis bondit en hurlant, griffes en avant, avec la frénésie désordonnée de celui qui n'a plus rien à perdre.
                """);
    }
}
