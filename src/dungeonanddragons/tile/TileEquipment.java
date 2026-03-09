package dungeonanddragons.tile;

import dungeonanddragons.Menu;
import dungeonanddragons.equipment.Equipment;
import dungeonanddragons.hero.Hero;


public class TileEquipment extends Tile {

        private Equipment content = null;

        public TileEquipment(Equipment content){
            this.content = content;
        }


    @Override
    public int interaction(Hero heros, Menu menu) {
        menu.displayTileEquipment(this.content.toString());

        if (isCompatible(heros.getType())){
            String answer = menu.displayChoiceToChangeEquipment();

            // option change
            if (answer.equals("change")){
                Equipment actualEquipment = heros.getEquipment();
                heros.setEquipment(this.getContent());
                this.setContent(actualEquipment);
            }
        } else {
            menu.displayEquipmentIsIncompatible();
        }
    return 0;
    }

    public boolean isCompatible(String typeHeros){
        if (this.getContent().getUserType().equals(typeHeros)){
            return true;
        }
        return false;
    }

    public Equipment getContent(){
            return this.content;
        }

        public void setContent(Equipment content) {
            this.content = content;
        }



    }
