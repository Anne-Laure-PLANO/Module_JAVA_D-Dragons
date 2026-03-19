package dungeonanddragons.tile;

import dungeonanddragons.Color;
import dungeonanddragons.Menu;
import dungeonanddragons.hero.Hero;

/**
 * Représente une tuile vide dans le jeu Donjon et Dragons.
 * Affiche un feu de camp lorsque le héros y arrive.
 * @author Anne-Laure PLANO
 */
public class TileEmpty extends Tile{

    /**
     * Constructeur de la tuile vide.
     */
    public TileEmpty (){
        super("empty");
    }

    /**
     * {@inheritDoc}
     * Affiche le message de tuile vide et le dessin du feu de camp.
     */
    @Override
    public void interact(Menu menu, Hero heros) {
        menu.displayTileEmpty();
        System.out.println(fireCamp());

    }

    /**
     * Retourne le dessin ASCII coloré d'un feu de camp.
     * @return le dessin du feu de camp sous forme de String
     */
    public String fireCamp(){
        return """
                           
                       %s    (     %s  
                       %s     )          %s
                       %s    (  (      %s 
                       %s        )   %s          
                       %s  (    (  %s
                       %s   ) /\\ %s
                     %s   ( %s // |%s (  %s 
                    %s  _ -%s.;_%s/ \\%s\\-%s-._%s  
                   %s  (_;%s-//%s | \\%s \\%s-'.\\%s 
                   %s  ( `.__ _  ___,') %s
                     %s `'(_ )_)(_)_)' %s
                
                """.formatted(
                        Color.YELLOW , Color.RESET,
                        Color.YELLOW , Color.RESET,
                        Color.YELLOW , Color.RESET,
                        Color.YELLOW , Color.RESET,
                        Color.YELLOW , Color.RESET,
                        Color.YELLOW , Color.RESET,
                        Color.YELLOW, Color.ORANGE, Color.YELLOW, Color.RESET,
                        Color.GREY, Color.ORANGE, Color.BROWN_WOOD, Color.ORANGE, Color.GREY, Color.RESET,
                        Color.GREY, Color.ORANGE, Color.BROWN_WOOD, Color.ORANGE, Color.GREY, Color.RESET,
                        Color.GREY, Color.RESET,
                        Color.GREY, Color.RESET
                );
    }

}
