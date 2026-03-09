package dungeonanddragons.monster;


import dungeonanddragons.hero.Hero;

public class Dragon extends Monster {


    public Dragon () {
        super("Dragon", 15, 4 );
    }

    @Override
    public void displayDefense() {
        System.out.println("""
                La douleur embrase ses écailles. 
                Un grondement sourd monte des profondeurs de sa gorge — et se transforme en rugissement de fureur. 
                Ses yeux s'illuminent d'un rouge incandescent. 
                Il ne souffre plus. Il détruit.
                """);
    }
}
