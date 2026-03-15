package dungeonanddragons.tile;

import dungeonanddragons.Color;
import dungeonanddragons.Menu;
import dungeonanddragons.hero.Hero;

public class TileEmpty extends Tile{

    public TileEmpty (){
        super("empty");
    }

    public void interact(Menu menu, Hero heros) {
        menu.displayTileEmpty();
        System.out.println(fireCamp());

    }


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
