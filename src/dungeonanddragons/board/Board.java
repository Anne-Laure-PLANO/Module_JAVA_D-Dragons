package dungeonanddragons.board;


import dungeonanddragons.Menu;
import dungeonanddragons.equipment.Equipment;
import dungeonanddragons.equipment.consumable.*;
import dungeonanddragons.equipment.warriorequipment.*;
import dungeonanddragons.equipment.wizardequipment.*;
import dungeonanddragons.hero.Hero;
import dungeonanddragons.monster.*;
import dungeonanddragons.tile.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board {
    private Random rand = new Random();
    private int boardLength;
    private Tile[] board ;

    public Board(int boardLength){
        this.boardLength = boardLength;
        this.board = new Tile[boardLength];
    }

    public void execTiles(int playerPosition, Hero player, Menu menu){
        Equipment initialPlayerEquipment = player.getEquipment();
        Tile currentTile = this.getBoard()[playerPosition];

        currentTile.interact(player, menu);

        if (currentTile instanceof TileEquipment){
            if (player.getEquipment() != initialPlayerEquipment){
                if (initialPlayerEquipment == null) {
                    board[playerPosition] = new TileEmpty();
                } else {
                    System.out.println("Vous laissez votre ancien équipement ");
                    board[playerPosition] = new TileEquipment(initialPlayerEquipment);
                }
            }
        }
        if (currentTile instanceof TileMonster){
            TileMonster monsterTile = (TileMonster) currentTile;
            if (monsterTile.isMonsterAlive()){
                moveTileMonster(currentTile, playerPosition);
            } else {
                board[playerPosition] = new TileEmpty();
            }
        }
    }




    public void moveTileMonster(Tile MonsterTile, int heroPosition){
        List<Integer> listOfPossibility = getAvailableEmptyTiles(heroPosition);
        if (!listOfPossibility.isEmpty()){
            int newPosition = rand.nextInt(listOfPossibility.size());
            board[listOfPossibility.get(newPosition)] = MonsterTile ;
        } else {
            List<Integer> listOfAllPossibility = getAvailableEmptyTiles(1);
            int newPosition = rand.nextInt(listOfAllPossibility.size());
            board[listOfAllPossibility.get(newPosition)] = MonsterTile;
        }
    }


    public List<Integer> getAvailableEmptyTiles( int heroPosition){
        List<Integer> availableEmptyTiles = new ArrayList<>();

        for (int i= heroPosition + 1 ; i < this.getBoardLength()-1 ; i++){
            if (board[i] instanceof TileEmpty){
                availableEmptyTiles.add(i);
            }
        }
        return availableEmptyTiles;
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


    public Tile[] getBoard() {
        return board;
    }

    public void setBoard(Tile[] board) {
        this.board = board;
    }

    public int getBoardLength() {
        return boardLength;
    }

    public void setBoardLength(int boardLength) {
        this.boardLength = boardLength;
    }

}
