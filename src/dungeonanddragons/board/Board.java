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

/**
 * Représente le plateau de jeu dans le jeu Donjon et Dragons.
 * Gère l'initialisation, le contenu des tuiles et les interactions du héros avec celles-ci.
 * @author Anne-Laure PLANO
 */
public class Board {

    /** Générateur de nombres aléatoires */
    private Random rand = new Random();
    /** La longueur du plateau */
    private int boardLength;
    /** Le tableau de tuiles constituant le plateau */
    private Tile[] board ;

    /**
     * Constructeur du plateau.
     * @param boardLength la longueur du plateau
     */
    public Board(int boardLength){
        this.boardLength = boardLength;
        this.board = new Tile[boardLength];
    }

    /**
     * Exécute l'interaction entre le héros et la tuile à sa position actuelle.
     * @param playerPosition la position actuelle du héros
     * @param player le héros
     * @param menu le menu du jeu
     */
    public void execTiles(int playerPosition, Hero player, Menu menu){
        Tile currentTile = this.getBoard()[playerPosition];

        if (currentTile instanceof TileMonster) {
            execTileMonster(menu, currentTile, player, playerPosition);

        }
        else if (currentTile instanceof TileEquipment){
            execTileEquipment(menu, currentTile, player, playerPosition);

        }
        else { // tileEmpty
            execTileEmpty(menu, currentTile, player);
        }
    }

    /**
     * Gère l'interaction avec une tuile monstre.
     * Le monstre peut fuir ou engager le combat avec le héros.
     * Si le monstre est vaincu, la tuile devient vide.
     * @param menu le menu du jeu
     * @param currentTile la tuile courante
     * @param player le héros
     * @param playerPosition la position du héros sur le plateau
     */
    public void execTileMonster(Menu menu, Tile currentTile, Hero player, int playerPosition){

        TileMonster monsterTile = (TileMonster) currentTile;
        menu.displayTileMonster(monsterTile.getContent().toString());

        boolean monsterIsEscaped = monsterTile.getContent().isMonsterEscape(player.getPv());
        boolean heroIsEscaped = false;
        if (monsterIsEscaped) {
            moveTileMonster(currentTile, playerPosition);
        } else {
            heroIsEscaped = monsterTile.executeCombat(menu, player);
            if (heroIsEscaped) {
                player.backDown();
            }
            if (!monsterTile.isMonsterAlive()) {
                board[playerPosition] = new TileEmpty();
            }
        }
    }

    /**
     * Gère l'interaction avec une tuile équipement.
     * Si le héros change d'équipement, l'ancien équipement reste sur la tuile
     * ou la tuile devient vide s'il n'en avait pas.
     * @param menu le menu du jeu
     * @param currentTile la tuile courante
     * @param player le héros
     * @param playerPosition la position du héros sur le plateau
     */
    public void execTileEquipment(Menu menu, Tile currentTile, Hero player, int playerPosition){
        Equipment initialPlayerEquipment = player.getEquipment();
        currentTile.interact( menu, player);

        if (player.getEquipment() != initialPlayerEquipment) {
            if (initialPlayerEquipment == null) {
                board[playerPosition] = new TileEmpty();
            } else {
                System.out.println("Vous laissez votre ancien équipement. ");
                board[playerPosition] = new TileEquipment(initialPlayerEquipment);
            }
        }
    }

    /**
     * Gère l'interaction avec une tuile vide.
     * Propose au héros d'ouvrir son sac s'il n'est pas vide.
     * @param menu le menu du jeu
     * @param currentTile la tuile courante
     * @param player le héros
     */
    public void execTileEmpty(Menu menu, Tile currentTile, Hero player){
        boolean readyToContinue = false;
        currentTile.interact(menu, player);

        do {
            if (player.getBag().isEmpty()){
                menu.bagEmpty();
                readyToContinue = true;
            } else {
                boolean wantToSeeBag = menu.askOpenBag(player.getBag().getSlots());
                if (wantToSeeBag) {
                    player.getBag().selectItem(menu, player);
                } else {
                    readyToContinue = true;
                }
            }
        }while (!readyToContinue);
    }

    /**
     * Déplace un monstre vers une tuile vide disponible devant le héros.
     * Si aucune tuile vide n'est disponible devant, cherche sur tout le plateau.
     * @param MonsterTile la tuile monstre à déplacer
     * @param heroPosition la position actuelle du héros
     */
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

    /**
     * Retourne la liste des index des tuiles vides disponibles après la position du héros.
     * @param heroPosition la position actuelle du héros
     * @return la liste des index des tuiles vides disponibles
     */
    public List<Integer> getAvailableEmptyTiles( int heroPosition){
        List<Integer> availableEmptyTiles = new ArrayList<>();

        for (int i= heroPosition + 1 ; i < this.getBoardLength()-1 ; i++){
            if (board[i] instanceof TileEmpty){
                availableEmptyTiles.add(i);
            }
        }
        return availableEmptyTiles;
    }

    /**
     * Initialise les tuiles du plateau aléatoirement.
     * La première et la dernière tuile sont toujours vides.
     * Les autres tuiles sont des monstres, des équipements ou des tuiles vides.
     */
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

    /**
     * Choisit aléatoirement un équipement pour une tuile équipement.
     * @return l'équipement choisi
     */
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

    /**
     * Choisit aléatoirement un monstre pour une tuile monstre.
     * @return le monstre choisi
     */
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
