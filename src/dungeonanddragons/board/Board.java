package dungeonanddragons.board;


import dungeonanddragons.equipment.Equipment;
import dungeonanddragons.equipment.consumable.BigPotion;
import dungeonanddragons.equipment.consumable.LittlePotion;
import dungeonanddragons.equipment.warrior.Club;
import dungeonanddragons.equipment.warrior.Sword;
import dungeonanddragons.equipment.wizard.Fireball;
import dungeonanddragons.equipment.wizard.Flash;
import dungeonanddragons.monster.Dragon;
import dungeonanddragons.monster.Goblin;
import dungeonanddragons.monster.Monster;
import dungeonanddragons.monster.Witcher;
import dungeonanddragons.tile.*;

import java.util.Random;

public class Board {
    private Random rand = new Random();
    private int boardLength;
    private Tile[] board ;

    public Board(int boardLength){
        this.boardLength = boardLength;
        this.board = new Tile[boardLength];
    }



    public void initTiles(){
        board[0] = new TileEmpty();
        board[this.getBoardLength()-1] = new TileEmpty();

        for (int i=1; i<boardLength-1 ; i++){
            Tile newTile;
            int typeOfTile = rand.nextInt(3)+1;
            switch (typeOfTile){
                case 1:
                    newTile = new TileMonster(chooseMonsterForTileMonster());
                    break;
                case 2:
                    newTile = new TileEquipment(chooseEquipmentForTileEquipment());
                    break;
                default:
                    newTile = new TileEmpty();
            }
            board[i] = newTile;
        }
    }

    public Equipment chooseEquipmentForTileEquipment(){

        int typeOfEquipment = rand.nextInt(6)+1;
        Equipment newEquipment;
        switch (typeOfEquipment){
            case 1:
                newEquipment = new BigPotion();
                break;
            case 2:
                newEquipment = new LittlePotion();
                break;
            case 3:
                newEquipment = new Club();
                break;
            case 4:
                newEquipment = new Sword();
                break;
            case 5:
                newEquipment = new Fireball();
                break;
            default:
                newEquipment = new Flash();
                break;
        }
        return newEquipment;
    }

    public Monster chooseMonsterForTileMonster(){

        int typeOfMonster = rand.nextInt(3)+1;
        Monster newMonster;
        switch (typeOfMonster){
            case 1:
                newMonster = new Dragon();
                break;
            case 2:
                newMonster = new Goblin();
                break;
            default:
                newMonster = new Witcher();
                break;
        }
        return newMonster;
    }




    public int getBoardLength() {
        return boardLength;
    }

    public void setBoardLength(int boardLength) {
        this.boardLength = boardLength;
    }

}
