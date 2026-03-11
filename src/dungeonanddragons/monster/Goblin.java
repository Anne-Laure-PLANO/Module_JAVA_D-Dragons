package dungeonanddragons.monster;

import dungeonanddragons.Color;

public class Goblin extends Monster {

    public Goblin () {
        super("Gobelin", 1, 6);
    }

    @Override
    public void displayAttack() {
        System.out.println("Le Gobelin vous attaque ! ");
    }

    @Override
    public void displayDefense() {
        System.out.println("""
                Il pousse un couinement aigu, mi-douleur mi-rage. 
                Ses petits yeux jaunes s'injectent de sang. 
                Il trépigne, bave, grogne — puis bondit en hurlant, griffes en avant.
                """);
    }

    public void displayIsKilled() {
        System.out.println("""
Le gobelin émet un couinement pitoyable avant de s'effondrer, ses petites mains crispées sur le sol humide.
Il ne volera plus jamais la moindre pièce d'or.                       
"""
        );
    }

    @Override
    public int percentageChanceToEscape(int pvHeros) {
        if (getAtk()>= pvHeros) {
            return 0;
        }else {
            return 50;
        }
    }

    public void displayEscape(){
        System.out.println("Avant de vous affronter, le gobelin disparait dans un cri aigü.");
    }

    public String getColor() {
        return Color.GREEN;
    }

    public String drawMonster() {
        return """
                       __.--|~|--.__           
                     /~     | |    ;~\\          
                    /|      | |    ;~\\\\                      
                   |/|      \\_/   ;;;|\\                    
                   |/ \\          ;;;/  )                 
               ___ | ______     ;_____ |___....__      
              \\ \\\\(| \\  \\.\\ \\__/ /./ /:|)      
             ~\\    |  ~-.     |   .-~: |//  _.-~
                \\.'|    | /-.__.-\\|::::| //~     
                  \\|   /          `\\:: |/      
                   |   |  /V""\""V\\ |:  |     
                    \\  |  ~`^~~^'~ |  /    
                      \\|`\\._____./'|/    
        """;
    }
}
