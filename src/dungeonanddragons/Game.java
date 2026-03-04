package dungeonanddragons;

import dungeonanddragons.board.Board;
import dungeonanddragons.equipment.Equipment;
import dungeonanddragons.exception.OutOfBoardException;
import dungeonanddragons.hero.Hero;
import dungeonanddragons.hero.Warrior;
import dungeonanddragons.hero.Wizard;
import dungeonanddragons.monster.Dragon;
import dungeonanddragons.monster.Goblin;
import dungeonanddragons.monster.Monster;
import dungeonanddragons.monster.Witcher;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Game {
    private Menu menu = new Menu();
    private Dice dice = new Dice();
    private Board board ;
    private List<Hero> heroes = new ArrayList<>();
    private List<Monster> monsters = new ArrayList<>();
    private List<Equipment> equipments = new ArrayList<>();
    Random rand = new Random();

    public Game(int boardLength) {
        this.board = new Board(boardLength);
    }


    public void initMonster(){
        int nbMonster = 0 ;
        int monsterPosition;

        while(nbMonster <= 3){
            int typeOfMonster = rand.nextInt(3)+1;
            monsterPosition = rand.nextInt(board.getBoardLength()-3)+1;

            // on vérifie si la position est occupée
            boolean occupiedPosition = false;
            for (Monster monster : monsters) {
                if (monsterPosition == monster.getPosition()) {
                    occupiedPosition = true;
                    break;
                }
            }

            //si la position est libre :
            if (!occupiedPosition) {
                Monster newMonster;
                switch (typeOfMonster){
                    case 1:
                        newMonster = new Dragon(monsterPosition);
                        break;
                    case 2:
                        newMonster = new Goblin(monsterPosition);
                        break;
                    default:
                        newMonster = new Witcher(monsterPosition);
                        break;
                }
                monsters.add(newMonster);
                nbMonster += 1;
            }
        }
    }


    //---> tout commence ici
    public void start () throws OutOfBoardException {
        menu.welcome();
        this.startMenu();
    }


// méthode de modif de perso à créer
    //définit le choix de l'utilisateur.
    public void startMenu () throws OutOfBoardException {
        int answer = menu.startMenu();

        switch (answer) {
            case 1 :
                this.createNewPlayer();
                break;
            case 2 :
                System.out.println("méthode à créer"); //méthode de modification à créer.
                break;
            case 3 :
                if (heroes.isEmpty()){
                    menu.needPlayerToPlay();
                    this.startMenu();
                } else {
                    this.startGame();
                }
                break;
            case 4 :
                this.quitGame();
                break;
            default:
                this.startMenu();
        }
    }

    //lance les dés + affiche texte
    public int throwDice(String heroName, Dice dice){
            int resultDice = dice.roll();
            menu.displayThrowDice(heroName, resultDice);
            return resultDice;
        }


        //démarre le jeu
    public void startGame() throws OutOfBoardException {
        boolean isVictory = false;
        boolean isDefeat = false;
        while (!isVictory && !isDefeat) {
            for (Hero player : heroes) {
                String namePlayer = player.getPseudo();
                menu.displayPositionHero(player);

    //lancer de dés
                int resultDice = this.throwDice(namePlayer, dice);

    //Avancée du personnage
    //uniquement réalisé pour utiliser une exception manuelle (dans le cadre des cours).
                // Un simple if/else aurait parfaitement fait l'affaire.
                try {
                    walk(player, resultDice);
                } catch (OutOfBoardException e) {
                    System.out.println(e.getMessage());
                    player.setPosition(board.getBoardLength() - 1);
                    menu.displayHeroNewPosition(player.getPosition());
                    isVictory = true;
                }

    // on fait le tour du tableau pour savoir nature de la case.


    //
    //            for (Monster monster : monsters){
    //                if (player.getPosition() == monster.getPosition()){
    //                    this.beginCombat(); // ------------------------------à créer
    //                    break;
    //                }
    //            for (Equipment equipment : equipments){
    //                if (player.getPosition() == equipment.getPosition()){
    //                    this.modifyEquipment();// ---------------------------- à créer
    //                }
    //            }
    //            }
            }

        }
        this.endGame(isVictory);
    }

    public void walk(Hero player, int dice) throws OutOfBoardException {
        int newPlayerPosition = player.getPosition() + dice;

        if (newPlayerPosition >= board.getBoardLength()) {
            throw new OutOfBoardException();
        }
        player.setPosition(newPlayerPosition);
        menu.displayHeroNewPosition(player.getPosition());
    }



    // se sert des fonctions de Menu : chooseTypeOfHero() et choosePseudoOfHero()
    //pour générer un nouveau héros.
    public void createNewPlayer() throws OutOfBoardException {
        int typeChoice = menu.chooseTypeOfHero();
        String nameHero = menu.choosePseudoOfHero();
        Hero player;
        switch (typeChoice) {
            case 1:
                player = new Wizard(nameHero);
                this.heroes.add(player);
                break;
            case 2:
                player = new Warrior(nameHero);
                this.heroes.add(player);
                break;
            default:
                System.out.println("Mais comment tu es arrivé là !?! bug fonction Game/createNewPlayer");
        }
                menu.confirmCreationHero();
                this.startMenu();
    }


 // menu de fin de jeu
    public void endGame (boolean isVictory) throws OutOfBoardException {
        if (isVictory) {
            menu.displayVictory();
        } else {
            menu.displayGameOver();
        }
        this.restartMenu();
    }


    public void restartMenu() throws OutOfBoardException {
        int answer = menu.displayRestartMenu();
        switch (answer) {
            case 1 :
                this.startGame();
                break;
            case 2 :
                this.startMenu();
                break;
            case 3:
                this.quitGame();
        }
    }

    public void quitGame(){
        menu.displayGoodBye();
        System.exit(0);
    }
}
