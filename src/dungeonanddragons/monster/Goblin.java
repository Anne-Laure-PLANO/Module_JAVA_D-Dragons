package dungeonanddragons.monster;

import dungeonanddragons.Color;

public class Goblin extends Monster {

    public Goblin () {
        super("Gobelin", 1, 6);
    }

    @Override
    public void displayDefense() {
        System.out.println("""
                Il pousse un couinement aigu, mi-douleur mi-rage. 
                Ses petits yeux jaunes s'injectent de sang. 
                Il trépigne, bave, grogne — puis bondit en hurlant, griffes en avant.
                """);
    }
    public void displayEscape(){
        System.out.println("Le gobelin disparait dans un cri aigü.");
    }

    public void displayIsKilled() {
        System.out.println("""
Le gobelin émet un couinement pitoyable avant de s'effondrer, ses petites mains crispées sur le sol humide.
Il ne volera plus jamais la moindre pièce d'or.                       
"""
        );
    }

    @Override
    public String toString() {
        return Color.GREEN +  """
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
                                              
     
                
                
                """ + Color.RESET +  super.toString();
    }
}
