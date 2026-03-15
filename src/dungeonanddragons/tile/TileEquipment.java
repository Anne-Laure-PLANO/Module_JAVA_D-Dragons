package dungeonanddragons.tile;

import dungeonanddragons.Menu;
import dungeonanddragons.equipment.Equipment;
import dungeonanddragons.equipment.consumable.Consumable;
import dungeonanddragons.hero.Hero;


public class TileEquipment extends Tile {

        private Equipment content = null;

        public TileEquipment(Equipment content){
            super("equipment");
            this.content = content;
        }


    @Override
    public void interact( Menu menu, Hero heros) {

        menu.displayTileEquipment(this.content.toString());

        if (this.getContent() instanceof Consumable) {
            int answer = menu.askLootAction();
            switch (answer) {
                case 1: //use
                    this.content.interact(heros, menu);
                    break;
                case 2: //put on the bag
                    heros.getBag().addItem(this.content);
                    break;
                default: // let in place
                    menu.youLetTheObject();
                    break;
            }
        } else{
            getContent().interact(heros, menu);
        }
    }




    public Equipment getContent(){
            return this.content;
        }

        public void setContent(Equipment content) {
            this.content = content;
        }



    }
