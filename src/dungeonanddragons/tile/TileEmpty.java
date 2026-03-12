package dungeonanddragons.tile;

import dungeonanddragons.Color;
import dungeonanddragons.Menu;
import dungeonanddragons.hero.Hero;

public class TileEmpty extends  Tile{

    public TileEmpty (){
        super("empty");
    }

    @Override
    public void interact(Hero heros, Menu menu) {
        menu.displayTileEmpty();
        System.out.println(fireCamp());
        boolean readyToContinue = false;
        do {
            boolean wantToSeeBag = menu.chooseWhatDoYouWantToDo();
            if (wantToSeeBag) {
                boolean takeAnObject = menu.displayBag(heros.getBag());
                if (takeAnObject) {
                    heros.chooseObjectOnTheBag(menu);
                } else {
                    readyToContinue = true;
                }
            } else{
                readyToContinue = true;
            }
        }while (!readyToContinue);
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
