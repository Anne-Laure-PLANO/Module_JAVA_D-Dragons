package dungeonanddragons;

import dungeonanddragons.board.Board;
import dungeonanddragons.exception.OutOfBoardException;
import dungeonanddragons.hero.*;


import java.util.ArrayList;
import java.util.List;

/**
 * Classe principale gérant le déroulement du jeu Donjon et Dragons.
 * Orchestre les interactions entre le héros, le plateau, les dés et le menu.
 * @author Anne-Laure PLANO
 */
public class Game {

    /** Le menu du jeu, gère l'affichage et les saisies */
    private Menu menu = new Menu();
    /** Le dé utilisé pour les déplacements */
    private Dice dice = new Dice();
    /** Le plateau de jeu */
    private Board board ;
    /** La liste des héros participants */
    private List<Hero> heroes = new ArrayList<>();

    /**
     * Constructeur du jeu.
     * @param boardLength la longueur du plateau de jeu
     */
    public Game(int boardLength) {
        this.board = new Board(boardLength);
    }


    //---> tout commence ici
    /**
     * Point d'entrée du jeu. Affiche le message de bienvenue,
     * initialise le plateau et lance le menu principal.
     * @throws OutOfBoardException si un héros dépasse les limites du plateau
     */
    public void start () throws OutOfBoardException {
        menu.welcome();
        board.initTiles();
        this.startMenu();
    }

// méthode de modif de perso à créer
    /**
     * Affiche le menu principal et redirige vers l'action choisie.
     * @throws OutOfBoardException si un héros dépasse les limites du plateau
     */
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

    /**
     * Permet de modifier les informations d'un héros existant.
     * Méthode en cours de développement.
     * @throws OutOfBoardException si un héros dépasse les limites du plateau
     */
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

    /**
     * Affiche les informations de tous les héros de la liste.
     */
    public void displayInfoHeroes(){
        for (Hero hero : heroes){
            System.out.println(hero.toString());
            System.out.println("");
        }
    }

    /**
     * Lance le dé et affiche le résultat.
     * @param heroName le nom du héros qui lance les dés
     * @param dice le dé à lancer
     * @return le résultat du lancer de dés
     */
    public int throwDice(String heroName, Dice dice){
        int resultDice = dice.roll();
        menu.displayThrowDice(heroName, resultDice);
        return resultDice;
    }

    /**
     * Lance une partie. Les héros avancent tour par tour jusqu'à
     * la victoire, la défaite ou la sortie du plateau.
     * @throws OutOfBoardException si un héros dépasse les limites du plateau
     */
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
        }while (status.equals("onGame")) ;

        this.endGame(status);
    }

    /**
     * Déplace le héros sur le plateau selon le résultat du dé.
     * @param player le héros à déplacer
     * @param dice le nombre de cases à avancer
     * @return la nouvelle position du héros
     * @throws OutOfBoardException si la nouvelle position dépasse les limites du plateau
     */
    public int walk(Hero player, int dice) throws OutOfBoardException {
        int newPlayerPosition = player.getPosition() + dice;

        if (newPlayerPosition >= board.getBoardLength()) {
            throw new OutOfBoardException();
        }
        player.setPosition(newPlayerPosition);
        menu.displayHeroNewPosition(player.getPosition());
        return newPlayerPosition;
    }

    /**
     * Vérifie si au moins un héros a été créé.
     * Affiche un message si la liste est vide.
     * @return true si la liste contient au moins un héros, false sinon
     */
    public boolean verifyIfHasAPlayer(){
        if (heroes.isEmpty()) {
            menu.needPlayer();
            return false;
        }else{
            return true;
        }
    }

    /**
     * Crée un nouveau héros selon les choix de l'utilisateur
     * et l'ajoute à la liste des héros.
     * @throws OutOfBoardException si un héros dépasse les limites du plateau
     */
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

    /**
     * Gère la fin de partie selon le statut de la partie.
     * @param status "win" pour une victoire, "dead" pour une défaite
     * @throws OutOfBoardException si un héros dépasse les limites du plateau
     */
    public void endGame (String status) throws OutOfBoardException {
        if (status.equals("win")) {
            menu.displayVictory();
        } else {
            menu.displayGameOver();
        }
        this.restartMenu();
    }

    /**
     * Affiche le menu de fin de partie et redirige selon le choix.
     * Réinitialise les héros en cas de nouvelle partie.
     * @throws OutOfBoardException si un héros dépasse les limites du plateau
     */
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

    /**
     * Affiche le message d'au revoir et quitte le jeu.
     */
    public void quitGame(){
        menu.displayGoodBye();
        System.exit(0);
    }
}
