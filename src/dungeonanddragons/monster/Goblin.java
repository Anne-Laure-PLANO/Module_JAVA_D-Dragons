package dungeonanddragons.monster;

import dungeonanddragons.Color;

/**
 * Représente un gobelin dans le jeu Donjon et Dragons.
 * Le gobelin possède 1 point de vie et 6 points d'attaque.
 * Il a 50% de chances de fuir, sauf s'il peut tuer le héros en un coup.
 * @author Anne-Laure PLANO
 */
public class Goblin extends Monster {

    /**
     * Constructeur du gobelin.
     */
    public Goblin () {
        super("Gobelin", 1, 6);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void displayAttack() {
        System.out.println("Le Gobelin vous attaque ! ");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void displayDefense() {
        System.out.println("""
                Il pousse un couinement aigu, mi-douleur mi-rage. 
                Ses petits yeux jaunes s'injectent de sang. 
                Il trépigne, bave, grogne — puis bondit en hurlant, griffes en avant.
                """);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void displayIsKilled() {
        System.out.println("""
Le gobelin émet un couinement pitoyable avant de s'effondrer, ses petites mains crispées sur le sol humide.
Il ne volera plus jamais la moindre pièce d'or.
"""
        );
    }

    /**
     * {@inheritDoc}
     * Le gobelin ne fuit jamais s'il peut tuer le héros en un coup,
     * sinon il a 50% de chances de fuir.
     */
    @Override
    public int percentageChanceToEscape(int pvHeros) {
        if (getAtk()>= pvHeros) {
            return 0;
        }else {
            return 50;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void displayEscape(){
        System.out.println("Avant de vous affronter, le gobelin disparait dans un cri aigü.");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getColor() {
        return Color.GREEN;
    }

    /**
     * {@inheritDoc}
     */
    @Override
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
