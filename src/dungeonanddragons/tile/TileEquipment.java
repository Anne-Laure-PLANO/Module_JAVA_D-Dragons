package dungeonanddragons.tile;

import dungeonanddragons.equipment.Equipment;
import dungeonanddragons.monster.Monster;

public class TileEquipment extends Tile {

        private Equipment content = null;

        public TileEquipment(Equipment content){
            this.content = content;
        }



        public Equipment getContent(){
            return this.content;
        }

        public void setContent(Equipment content) {
            this.content = content;
        }

        public void deleteContent(){
            this.content = null;
        }


    }
