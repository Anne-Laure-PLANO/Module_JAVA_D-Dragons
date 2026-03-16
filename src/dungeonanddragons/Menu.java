package dungeonanddragons;

import dungeonanddragons.equipment.Equipment;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Gère l'affichage des messages et la saisie utilisateur dans le jeu Donjon et Dragons.
 * Centralise toutes les interactions avec la console.
 * @author Anne-Laure PLANO
 */
public class Menu {

    /** Scanner pour la saisie utilisateur */
    private Scanner sc;

    /**
     * Constructeur du menu, initialise le scanner.
     */
    public Menu() {
        this.sc = new Scanner(System.in);
    }


//------------ message de début de jeu.
    // déclenché par Game.start()
    /**
     * Affiche le message de bienvenue du jeu.
     */
    public void welcome (){
        System.out.println(Color.CYAN +  """
                                      
                        ___             _                  \s
                       /   \\___  _ __  (_) ___  _ __       \s
                      / /\\ / _ \\| '_ \\ | |/ _ \\| '_ \\      \s
                     / /_// (_) | | | || | (_) | | | |     \s
                    /___,' \\___/|_| |_|/ |\\___/|_| |_|     \s
                                     |__/                  \s
                                  ___                                  \s
                                 ( _ )                                 \s
                                 / _ \\/\\                               \s
                                | (_>  <                               \s
                                 \\___/\\/                               \s
                    ___                                \s
                   /   \\_ __ __ _  __ _  ___  _ __  ___\s
                  / /\\ / '__/ _` |/ _` |/ _ \\| '_ \\/ __|
                 / /_//| | | (_| | (_| | (_) | | | \\__ \\
                /___,' |_|  \\__,_|\\__, |\\___/|_| |_|___/
                                  |___/                \s
                
                
                """ + Color.RESET);
    }

// -------------messages du menu du jeu ----------------
    // déclenché par Game.startMenu()

    /**
     * Affiche un message indiquant qu'un héros doit être créé avant de jouer.
     */
    public void needPlayer(){
        System.out.println("Vous devez d'abord créer un héros.");
    }



    /**
     * Affiche le menu principal et retourne le choix de l'utilisateur.
     * @return le choix de l'utilisateur (1 à 4)
     */
    public int startMenu (){
        boolean bug = true;
        int userChoice = 0;
        while (bug) {
            try{
                System.out.println("""
                    Indiquez votre choix :
                    1 - Nouveau personnage
                    2 - Afficher / Modifier les informations du personnage
                    3 - Lancer le jeu
                    4 - Quitter le jeu
                    """);
                userChoice = sc.nextInt();
                sc.nextLine();
                switch (userChoice){
                    case 1 :
                        System.out.println("C'est parti pour la création d'un nouveau personnage !");
                        bug = false;
                        break;
                    case 2 :
                        System.out.println("Allons modifier ton personnage");
                        bug = false;
                        break;
                    case 3:
                        System.out.println("Entrons dans la grotte alors.");
                        bug = false;
                        break;
                    case 4 :
                        System.out.println("Tu préfères abandonner maintenant ? Pas de soucis, reviens plus tard.");
                        bug = false;
                        break;
                    default :
                        System.out.println("Je n'ai pas compris ta réponse ; recommence");

                }
            } catch(InputMismatchException e) {
                System.out.println("Erreur, tu dois saisir un chiffre. ");
                sc.nextLine();
            }
        }
        return userChoice;
    }

    /**
     * Demande si l'utilisateur souhaite modifier son personnage.
     * @return 1 pour oui, 2 pour non
     */
    public int choiceToModifyOption(){
        boolean bug = true;
        int answer = 0;
        while (bug) {
            try {
                System.out.println("""
                        Souhaitez-vous modifier le personnage ?
                        1 - Oui  /  2 - Non
                        """);
                answer = sc.nextInt();
                sc.nextLine();
                if (answer == 1 || answer == 2) {
                    bug = false;
                    return answer;
                }
            } catch (InputMismatchException e) {
                System.out.println("Erreur, veuillez saisir un chiffre.");
                sc.nextLine();
            }
        }
        return answer;
    }

    /**
     * Demande quelle information du personnage modifier.
     * @return 1 pour le nom, 2 pour le type
     */
    public int choiceOptionToModify(){
        boolean bug = true;
        int userChoice =0;
        while (bug){
            try{
            System.out.println("""
                    Sélectionner l'information que vous souhaitez modifier :
                    1 - Nom du héros
                    2 - Type de héros
                    """);
            userChoice = sc.nextInt();
            sc.nextLine();
            if (userChoice==1 || userChoice ==2){
                bug = false;
                return userChoice;
            }else {
                System.out.println("Veuillez choisir entre 1 et 2");
            }
                } catch (InputMismatchException e){
                System.out.println("Erreur, veuillez saisir un chiffre.");
                sc.nextLine();
            }
        }
        return userChoice;
    }



// ---------- Création du personnage -------------
    //utilisé par Game. createNewPlayer()

    /**
     * Demande à l'utilisateur de choisir le type de son héros.
     * @return 1 pour Sorcier, 2 pour Guerrier
     */
    public int chooseTypeOfHero(){
        boolean bug = true;
        int typeCharacter = 0 ;
        while (bug) {
            try {
                System.out.println("Quel type de personnage souhaitez-vous ? 1 pour Sorcier ; 2 pour guerrier ");
                typeCharacter = sc.nextInt();
                sc.nextLine();
                if (typeCharacter == 1 || typeCharacter ==2) {
                    bug = false;
                } else {
                    System.out.println("Erreur, merci de saisir un des chiffre mentionnés.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erreur : merci de sélectionner un chiffre uniquement ");
                sc.nextLine();
            }
        }
        return typeCharacter;
    }

    /**
     * Demande à l'utilisateur de saisir le pseudo de son héros.
     * Le pseudo doit contenir entre 3 et 20 caractères alphanumériques.
     * @return le pseudo choisi
     */
    public String choosePseudoOfHero(){
        boolean bug = true;
        String playerName = "" ;
        while (bug) {
            System.out.println("Entrez le nom de votre héros :");
            playerName = sc.nextLine();
             if (playerName.length()>20 || playerName.length() <3){
                 System.out.println("Erreur : le nom doit contenir entre 3 et 20 caractères.");
             } else if (!playerName.matches("[a-zA-Z0-9]+")) {
                 System.out.println("Le nom ne doit contenir que des lettres et des chiffres.");
            } else {
                 bug = false;
            }
        }
        return playerName;
    }

    /**
     * Affiche un message de confirmation de création du héros.
     */
    public void confirmCreationHero (){
        System.out.println("""
           Ton héros a bien été créé.
           Appuie sur Entrer pour retourner au menu.""");
        sc.nextLine();
    }



 // -------------Message de déroulement de la partie
    // utilisé par Game.startGame()

    /**
     * Affiche la position et les informations du héros en cours de jeu.
     * @param infoHero les informations du héros à afficher
     */
    public void displayPositionHero(String infoHero) {
         System.out.println("""
         Le joueur avance. il s'agit de :
         """ + infoHero );

     }

// --------------Messages d'avancée du personnage
    // utilisé par Game.heroWalk()

    /**
     * Affiche la nouvelle position du héros sur le plateau.
     * @param position la nouvelle position du héros
     */
    public void displayHeroNewPosition(int position){
        System.out.println("Le joueur est sur la case " + position + ".");
    }

//----------------- méthodes pour lancer de dés
    // utilisé par Game.throwDice()

    /**
     * Affiche le résultat du lancer de dés.
     * @param heroName le nom du héros
     * @param dice le résultat du lancer de dés
     */
    public void displayThrowDice(String heroName, int dice){
        System.out.println("Appuyer sur Entrer pour lancer les dés.");
        sc.nextLine();
        System.out.println(Color.YELLOW + "Le joueur " + heroName + " lance les dés." + Color.RESET);
        System.out.println("Les dés affichent " + Color.PURPLE + dice + Color.RESET + ".\n");
    }

    /**
     * Attend que l'utilisateur appuie sur Entrée pour continuer.
     */
    public void waitForNextTurn() {
        System.out.println("Appuyez sur Entrée pour continuer...");
        sc.nextLine();
        System.out.println("___________________________________________________________________");
    }
// ----------------- messages de fin : victoire / défaite


    /**
     * Affiche le message de victoire.
     */
     public void displayVictory(){
        System.out.println("""
                La lumière du trésor éclabousse vos yeux. Vos mains tremblent — non pas de peur, mais de cette fierté brûlante qui enflamme chaque fibre de votre être.
                 Vous avez traversé les ténèbres, affronté ses créatures, défié ses pièges.
                 Et vous êtes toujours debout.
                 Levez la tête. La victoire est vôtre !
                """);
    }

    /**
     * Affiche le message de Game Over.
     */
     public void displayGameOver(){
        System.out.println("""
                Le sol froid accueille votre chute sans un bruit. Personne pour témoin. Personne pour se souvenir.
                Vous avez tout donné. Ce n'était pas assez.
                La grotte vous a consumé comme elle a consumé tous les autres — sans haine, sans gloire.
                Vous n'étiez qu'un de plus.
                L'obscurité se referme. Vos yeux cherchent une dernière fois la lumière...
                Elle n'est plus là.
                
               %s GAME OVER %s
            """.formatted(Color.RED, Color.RESET));
    }

    /**
     * Affiche le menu de fin de partie et retourne le choix de l'utilisateur.
     * @return 1 pour rejouer, 2 pour le menu principal, 3 pour quitter
     */
    public int displayRestartMenu(){
        boolean bug = true;
        int answer =0;
        while(bug) {
             try{
            System.out.println("""
                    Souhaitez-vous relancer une partie ?
                    1 - oui
                    2 - retourner au menu principal
                    3 - quitter le jeu
                    """);
                answer = sc.nextInt();
                sc.nextLine();
                if (answer == 1 || answer ==2 || answer ==3){
                    bug = false;
                } else {
                    System.out.println("Merci de saisir un chiffre entre 1 et 3.");
                }

            } catch(InputMismatchException e){
                System.out.println("Réponse incorrecte ; merci de ne saisir que des chiffres");
                sc.nextLine();
             }
        }
        return answer;
    }

    /**
     * Affiche le message d'au revoir.
     */
    public void displayGoodBye (){
        System.out.println("""
    Les ténèbres de la grotte se referment derrière vous comme une plaie ancienne. 
    Au loin, les rugissements des créatures résonnent en échos sourds, comme un dernier avertissement. 
    Vous pressez le pas, les yeux rivés vers la lumière, 
    mais quelque chose en vous sait déjà... la grotte n'a pas fini avec vous. 
    À bientôt, aventurier.
    """);
    }


     //-------------------------------Classe Tile -------------------


    // -----------------------Tile Monster--------------------------

    /**
     * Affiche le monstre rencontré sur la tuile.
     * @param monster la description du monstre
     */
    public void displayTileMonster(String monster){
        System.out.println("""
                Une ombre inquiétante vous barre le passage... 
                Il s'agit de :
                """ + monster);
    }

    /**
     * Affiche les points de vie actuels du héros après avoir subi des dégâts.
     * @param actualPV les points de vie actuels
     * @param totalPV les points de vie maximum
     */
    public void displayHeroPV(int actualPV, int totalPV){
                System.out.println("""
                        Vous avez été blessé.
                        Il vous reste : %s %d %s / %s %d %s PV.
                        """.formatted(Color.RED , actualPV, Color.RESET ,
                        Color.GREEN ,  totalPV, Color.RESET));
            }

    /**
     * Affiche les dégâts infligés au monstre et ses points de vie restants.
     * @param colorMonster la couleur d'affichage du monstre
     * @param nameMonster le nom du monstre
     * @param degats les dégâts infligés
     * @param actualPV les points de vie actuels du monstre
     * @param totalPV les points de vie maximum du monstre
     */
    public void displayMonsterPV( String colorMonster , String nameMonster, int degats, int actualPV, int totalPV){
        System.out.println("""
                        Le %s%s%s a été touché ! 
                        Vous lui avez fait %s%d%s de dégats.
                        Quantité de PV restant : %s%d / %d%s PV.
                        """.formatted(
                                colorMonster, nameMonster, Color.RESET,
                Color.RED , degats, Color.RESET,
                Color.RED, actualPV, totalPV, Color.RESET));

    }

    /**
     * Demande au héros ce qu'il souhaite faire face au monstre.
     * @return 1 pour combattre, 2 pour fuir, 3 pour utiliser une potion
     */
    public int displayIsWantToBattle(){
        int answer = 0;
        List<Integer> possibilities = List.of(1, 2, 3);
        do {
            try {
                System.out.println("""
                    Que souhaitez-vous faire ? 
                    1 - Combattre
                    2 - Fuir
                    3 - Utiliser une potion
                    """);
                answer = sc.nextInt();
                sc.nextLine();
                if (!possibilities.contains(answer)) {
                    System.out.println("Merci de saisir un chiffre entre 1 et 3");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erreur : merci de saisir un chiffre.");
                sc.nextLine();
            }
        } while (!possibilities.contains(answer));
        return answer;
    }

    /**
     * Affiche un message indiquant que le sac est vide.
     */
    public void bagEmpty(){
        System.out.println("Votre sac est vide.");
    }

    //-----------------------Tile Equipment-------------------------

    /**
     * Affiche l'équipement trouvé sur la tuile.
     * @param equipment la description de l'équipement
     */
    public void displayTileEquipment (String equipment){
        System.out.println("""
                Vous avez trouvé un coffre ! 
                Vous faites sauter le cadenas sans hésiter et ouvrez le couvercle d'un grand geste joyeux, 
                impatient de voir ce qui se cache à l'intérieur... 
                Il contient :
                """ + equipment);

    }

    /**
     * Affiche un message d'incompatibilité d'équipement.
     */
    public void displayEquipmentIsIncompatible(){
        System.out.println("""
                Cet équipement n'est pas compatible avec votre personnage.
                Vous refermez le coffre, déçu..
                """);

    }

    /**
     * Propose au héros de prendre un équipement quand il n'en possède pas.
     * @return "change" si le héros prend l'équipement, "keep" sinon
     */
    public String displayChoiceToTakeEquipment(){
        boolean bug = true;
        int answer =0;
        String choice = null;
        while (bug){
            try   {
                System.out.println("""
                         Souhaitez-vous récupérer cet équipement ?
                         1 - Je prends !
                         2 - Je préfère rester les mains vides.
                         """);
                answer = sc.nextInt();
                sc.nextLine();
                if (answer == 1){
                    choice = "change";
                    System.out.println("Vous avez récupéré l'équipement.");
                    bug = false;

                } else if (answer==2){
                    choice = "keep";
                    System.out.println("Vous conservez votre équipement.");
                    bug = false;
                } else {
                    System.out.println("Merci de choisir entre 1 et 2.");
                }

            } catch (InputMismatchException e){
                System.out.println("Merci de saisir un chiffre.");
                sc.nextLine();
            }
        }
        return choice;
    }

    /**
     * Propose au héros de remplacer son équipement actuel.
     * @return "change" si le héros change d'équipement, "keep" sinon
     */
    public String displayChoiceToChangeEquipment(){
         boolean bug = true;
         int answer =0;
         String choice = null;
         while (bug){
             try   {
                 System.out.println("""
                         Souhaitez-vous récupérer cet équipement ?
                         Attention : votre ancien équipement sera perdu.
                         1 - Je change !
                         2 - Je préfère conserver mon équipement actuel.
                         """);
                 answer = sc.nextInt();
                 sc.nextLine();
                 if (answer == 1){
                     choice = "change";
                     System.out.println("Votre équipement a bien été changé. Vous laissez votre ancien équipement derrière vous.");
                     bug = false;

                 } else if (answer==2){
                    choice = "keep";
                    System.out.println("Vous conservez votre équipement.");
                     bug = false;
                 } else {
                     System.out.println("Merci de choisir entre 1 et 2.");
                 }

             } catch (InputMismatchException e){
                 System.out.println("Merci de saisir un chiffre.");
                 sc.nextLine();
             }
         }
         return choice;
    }

    /**
     * Demande au héros ce qu'il souhaite faire avec un objet trouvé.
     * @return 1 pour utiliser, 2 pour mettre dans le sac, 3 pour laisser
     */
    public int askLootAction(){
    int answer = 0;
            do {
                try {
                    System.out.println("""
                            Que souhaitez-vous faire ?
                            1 - Utiliser
                            2 - Mettre dans le sac
                            3 - Laisser
                            """);
                    answer = sc.nextInt();
                    sc.nextLine();
                    if (answer >= 1 && answer <= 3) {
                        return answer;
                    } else {
                        System.out.println("Merci de saisir un chiffre entre 1 et 3.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Merci de saisir un chiffre.");
                    sc.nextLine();
                }
            } while (true);
    }

    /**
     * Affiche un message indiquant que le héros laisse l'objet.
     */
    public void youLetTheObject(){
        System.out.println("Vous laissez l'objet dans le coffre où vous l'avez trouvé.");
    }

    // ---------------------Tile Empty -----------------------------

    /**
     * Affiche le message de la tuile vide.
     */
    public void displayTileEmpty(){
        System.out.println("""
                La case est vide. Vous laissez échapper un soupir de soulagement...
                """);
    }

    /**
     * Demande au héros s'il souhaite regarder dans son sac.
     * @return true s'il souhaite regarder, false sinon
     */
    public boolean IsWantToSeeBag(){
        int answer = 0;
        do{
            try{
             System.out.println("""
                    Que souhaitez-vous faire ?
                    1 - Regarder dans votre sac
                    2 - Rien
                    """);
             answer = sc.nextInt();
             sc.nextLine();
             if (answer ==1){
                 return true;
             } else if (answer ==2) {
                 return false;
             }else {
                 System.out.println("Merci de choisir entre 1 ou 2.");
             }
            } catch (InputMismatchException e) {
                System.out.println("Merci de ne saisir que des chiffres.");
                sc.nextLine();
            }
        } while (answer != 1 && answer !=2);
        return false;
    }

    /**
     * Affiche le contenu du sac.
     * @param items le tableau d'équipements du sac
     */
    public void displayBag(Equipment[] items){
        System.out.println("Votre sac contient :");
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null){
                System.out.println(i + 1 + " - " + items[i].getName() + " - restaure " + items[i].getPv() + " points de vie.");

            } else {
                System.out.println(i + 1 + " - Vide");
            }
        }
    }

    /**
     * Affiche le sac et demande si le héros souhaite prendre un objet.
     * @param bag le tableau d'équipements du sac
     * @return true si le héros souhaite prendre un objet, false sinon
     */
    public boolean askOpenBag(Equipment[] bag){
        int answer = 0;
        if (bag !=null) {
            do {
                try {
                    displayBag(bag);
                    System.out.println("""
                            Souhaitez-vous prendre un objet ?
                            1 - oui
                            2 - non
                            """);
                    answer = sc.nextInt();
                    sc.nextLine();
                    if (answer == 1) {
                        return true;
                    } else if (answer == 2) {
                        return false;
                    } else {
                        System.out.println("Erreur : Merci de sélectionner un chiffre compris entre 1 et 2.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Merci de saisir uniquement un chiffre.");
                    sc.nextLine();
                }
            } while (answer < 1 || answer > 2);
        } else {
            System.out.println("Votre sac est vide.");
        }
            return false;
    }

    /**
     * Affiche le sac et retourne l'index de l'objet sélectionné.
     * @param items le tableau d'équipements du sac
     * @return l'index de l'objet sélectionné, -1 si annulé
     */
    public int selectItem(Equipment[] items){
         int answer = -1;
         do {
             try {
                 displayBag(items);
                 System.out.println("Veuillez sélectionner un objet. " +
                         " 0 - annuler.");
                 answer = sc.nextInt();
                 sc.nextLine();
                 if (answer == 0) {
                     System.out.println("Action annulée");
                     return -1;
                 } else if (answer >= 1 && answer <= items.length && items[answer-1] != null) {
                     System.out.println("Vous avez sélectionné : " + items[answer - 1] + ".");
                     return answer - 1;
                 } else {
                     System.out.println("Erreur : Merci de sélectionner un chiffre compris entre 0 et " + items.length + " et n'étant pas un emplacement vide.");
                 }
             } catch (InputMismatchException e) {
                 System.out.println("Merci de saisir uniquement un chiffre.");
                 sc.nextLine();
             }
         } while (true);
    }

    /**
     * Demande quelle action effectuer sur un objet du sac.
     * @param objectName le nom de l'objet sélectionné
     * @return 1 pour utiliser, 2 pour jeter, 3 pour rien
     */
    public int selectItemAction(String objectName){
        int answer = 0;
        do{
            try{
                System.out.println("""
                    Que souhaitez- vous faire avec %s ?
                    1 - L'utiliser
                    2 - Le jeter
                    3 - Rien 
                    """.formatted(objectName));
                answer = sc.nextInt();
                sc.nextLine();
                if (answer>=1 && answer<=3){
                    return answer;
                } else{
                    System.out.println("Erreur : Merci de sélectionner un chiffre compris entre 1 et 3.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Merci de saisir uniquement un chiffre.");
                sc.nextLine();
            }
        } while (true);
    }

    /**
     * Affiche un message de confirmation de destruction d'un objet.
     * @param objectName le nom de l'objet détruit
     */
    public void displayObjectHasBeenDestroyed(String objectName){
        System.out.println(objectName + " a bien été détruit. J'espère que vous n'en aurez pas besoin !");
    }

    /**
     * Affiche un message indiquant que le héros ne fait rien avec l'objet.
     */
    public void displayYouDoNothingWithBag(){
        System.out.println("Vous remettez l'objet à sa place et trouvez une autre occupation.");
    }

    /**
     * Affiche un message indiquant que le héros referme son sac.
     */
    public void displayCloseBag(){
        System.out.println("Vous refermez le sac.");
    }
}
