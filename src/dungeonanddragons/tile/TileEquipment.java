package dungeonanddragons.tile;

import dungeonanddragons.Menu;
import dungeonanddragons.equipment.Equipment;
import dungeonanddragons.hero.Hero;


public class TileEquipment extends Tile {

        private Equipment content = null;

        public TileEquipment(Equipment content){
            super("equipment");
            this.content = content;
        }


    @Override
    public void interact(Hero heros, Menu menu) {

        Equipment actualEquipment = heros.getEquipment();
        menu.displayTileEquipment(this.content.toString());
        int answer = menu.makeYourChoiceWithThisObject();
                switch(answer){
                    case 1: //use
                        this.content.interact(heros, menu);
                        break;
                    case 2: //put on the bag
                        heros.keepObjectOnTheBag(this.content);
                        break;
                    default: // let in place
                        menu.youLetTheObject();
                        break;
                }

    }




    public Equipment getContent(){
            return this.content;
        }

        public void setContent(Equipment content) {
            this.content = content;
        }



    }
