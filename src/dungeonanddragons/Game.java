package dungeonanddragons;

import dungeonanddragons.board.Board;
import dungeonanddragons.exception.OutOfBoardException;
import dungeonanddragons.hero.*;


import java.util.ArrayList;
import java.util.List;


public class Game {
    private Menu menu = new Menu();
    private Dice dice = new Dice();
    private Board board ;
    private List<Hero> heroes = new ArrayList<>();

    public Game(int boardLength) {
        this.board = new Board(boardLength);
    }


    //---> tout commence ici
    public void start () throws OutOfBoardException {
        menu.welcome();
        board.initTiles();
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
                this.startMenu();
                break;
            case 3 :
                boolean hasPlayer = verifyIfHasAPlayer();
                if (hasPlayer){
                    this.startGame();
                } else {
                    this.startMenu();
                }
                break;
            case 4 :
                this.quitGame();
                break;
            default:
                this.startMenu();
        }
    }


    /// /---------> méthode à reprendre ; non finie

    public void optionModifyCharacter() throws OutOfBoardException {
        boolean hasPlayer = verifyIfHasAPlayer();
        if (hasPlayer) {
            displayInfoHeroes();
            // il faut choisir quel personnage on veut modifier et récupérer son emplacement dans la liste.

            int userChoice = menu.choiceToModifyOption();
            if (userChoice == 1) { // on veut modifier le perso
                int optionToModify = menu.choiceOptionToModify();
                if (optionToModify == 1) { // on veut modifier le pseudo
                    String newPseudo = menu.choosePseudoOfHero();

                } else { // modifier le type de perso
                    int changeType = menu.chooseTypeOfHero();

                }
            }
        }else {
            //retour au menu
            startMenu();
        }

    }

    public void displayInfoHeroes(){
        for (Hero hero : heroes){
            System.out.println(hero.toString());
            System.out.println("");
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
        String status = "onGame";

        do {
            for (Hero player : heroes) {
                String namePlayer = player.getPseudo();

                menu.displayPositionHero(player.toString());
                //lancer de dés
                int resultDice = this.throwDice(namePlayer, dice);

                //Avancée du personnage
                //OutOfBoardException -> uniquement réalisé pour utiliser une exception manuelle (dans le cadre des cours).
                // Un simple if/else aurait parfaitement fait l'affaire.
                try {
                    int playerPosition = walk(player, resultDice);

                    board.execTiles(playerPosition, player, menu);

                    if (player.isAlive() == false) {
                        status = "dead";
                    }
                    if (playerPosition == board.getBoardLength()-1){
                        status = "win";
                    }

                    menu.waitForNextTurn();
                } catch (OutOfBoardException e) {
                    System.out.println(e.getMessage());
                    player.setPosition(board.getBoardLength() - 1);
                    menu.displayHeroNewPosition(player.getPosition());
                    status = "win";
                }
            }
        }while (status == "onGame") ;

        this.endGame(status);
    }

    public int walk(Hero player, int dice) throws OutOfBoardException {
        int newPlayerPosition = player.getPosition() + dice;

        if (newPlayerPosition >= board.getBoardLength()) {
            throw new OutOfBoardException();
        }
        player.setPosition(newPlayerPosition);
        menu.displayHeroNewPosition(player.getPosition());
        return newPlayerPosition;
    }


    public boolean verifyIfHasAPlayer(){
        if (heroes.isEmpty()) {
            menu.needPlayer();
            return false;
        }else{
            return true;
        }
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
                System.out.println(player.toString());
                this.heroes.add(player);

                break;
            case 2:
                player = new Warrior(nameHero);
                this.heroes.add(player);
                System.out.println(player.toString());
                break;
            default:
                System.out.println("Mais comment tu es arrivé là !?! bug fonction Game/createNewPlayer");
        }
                menu.confirmCreationHero();
                this.startMenu();
    }


 // menu de fin de jeu
    public void endGame (String status) throws OutOfBoardException {
        if (status.equals("win")) {
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
                for (Hero hero : heroes){
                    hero.setPosition(0);
                    hero.setPv(hero.getMaxPV());
                    hero.setEquipment(null);
                }
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
