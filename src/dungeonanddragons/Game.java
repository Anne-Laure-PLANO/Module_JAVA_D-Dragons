package dungeonanddragons;

import dungeonanddragons.equipment.Equipment;
import dungeonanddragons.hero.Hero;
import dungeonanddragons.hero.Warrior;
import dungeonanddragons.hero.Wizard;
import dungeonanddragons.monster.Monster;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Menu menu = new Menu();
    private Dice dice = new Dice();
    private Board board ;
    private List<Hero> heroes = new ArrayList<>();
    private List<Monster> monsters = new ArrayList<>();
    private List<Equipment> equipments = new ArrayList<>();

    public Game(int boardLength) {
        this.board = new Board(boardLength);
    }


    // logique interne du jeu (joueurs / avancement)
    public void initGame(int boardLength){
        Board board = new Board(boardLength);

    }

    //définit le choix de l'utilisateur.
    public void startMenu (){
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
                menu.optionQuitGame();
                System.exit(0);
                break;
            default:
                this.startMenu();
        }
    }

    //enclenche le jeu
    public void startGame(){
        for (Hero player : heroes){
            Menu.positionPlayer(player); // ----------------------à créer
            int dice = dice.roll(6);
            if ((player.getPosition()+dice) >= board.getBoardLength()){
                player.setPosition(board.getBoardLength());
                this.victory(); // --------------------------------à créer
            }
            player.setPosition(dice);
            for (Monster monster : monsters){
                if (player.getPosition() == monster.getPosition()){
                    this.beginCombat(); // ------------------------------à créer
                    break;
                }
            for (Equipment equipment : equipments){
                if (player.getPosition() == equipment.getPosition()){
                    this.modifyEquipment();// ---------------------------- à créer
                }
            }
            }

        }
    }

    public void addHero(Hero hero){
        this.heroes.add(hero);
    }


    // se sert des fonctions de Menu : chooseTypeOfHero() et choosePseudoOfHero()
    //pour générer un nouveau héros.
    public Hero createNewPlayer(){
        int typeChoice = menu.chooseTypeOfHero();
        String nameHero = menu.choosePseudoOfHero();
        Hero player;
        switch (typeChoice) {
            case 1:
                player = new Wizard(nameHero);
                this.heroes.add(player);
                return player;
            case 2:
                player = new Warrior(nameHero);
                this.heroes.add(player);
                return player;
            default:
                System.out.println("Mais comment tu es arrivé là !?! bug fonction Game/createNewPlayer");
                return null;
        }
    }

}
