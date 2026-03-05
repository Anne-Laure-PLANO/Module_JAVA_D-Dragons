package dungeonanddragons;

import dungeonanddragons.hero.Hero;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    //affiche messages
    // et récupère les saisies utilisateur
    private Scanner sc;

    public Menu() {
        this.sc = new Scanner(System.in);
    }


//------------ message de début de jeu.
    // déclenché par Game.start()

    public void welcome (){
        System.out.println("Bienvenue dans Donjon et Dragons !");
    }



// -------------messages du menu du jeu ----------------
    // déclenché par Game.startMenu()

    //condition du menu si option Jouer est choisie sans Player créé.
    public void needPlayer(){
        System.out.println("Vous devez d'abord créer un héros.");
    }



    // Menu d'accueil qui affiche les options et renvoie le choix de redirection
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

    //Définit les attributs du héros et renvoie le choix du type
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

    //Retourne le pseudo choisi par l'utilisateur
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

    // message de confirmation de création du Héros
    public void confirmCreationHero (){
        System.out.println("""
           Ton héros a bien été créé.
           Retour au menu pour commencer l'aventure !
           """);
    }



 // -------------Message de déroulement de la partie
    // utilisé par Game.startGame()

    //affiche les informations du joueur à qui c'est le tour
     public void displayPositionHero(Hero hero) {
         System.out.println("Le joueur avance. il s'agit de :");
         System.out.println(hero.toString());
         System.out.println();
     }

// --------------Messages d'avancée du personnage
    // utilisé par Game.heroWalk()

    //Affiche la nouvelle position du héros
    public void displayHeroNewPosition(int position){
        System.out.println("Le joueur est sur la case " + position + ".");
    }

//----------------- méthodes pour lancer de dés
    // utilisé par Game.throwDice()

    //affiche le texte d'annonce & résultat de l'action throwDice
    public void displayThrowDice(String heroName, int dice){
        System.out.println("Le joueur " + heroName + "lance les dés.");
        System.out.println("Les dés affichent " + dice + ".");
        System.out.println("");
    }


// ----------------- messages de fin : victoire / défaite


    /**
     *
     */
    //appelée par Game.isVictory()
     public void displayVictory(){
        System.out.println("""
            La lumière du trésor éclabousse vos yeux comme une aube après une nuit sans fin. Vos mains tremblent — non pas de peur, cette fois, mais de cette fierté brûlante qui monte du ventre et enflamme chaque fibre de votre être.
            Vous avez traversé les ténèbres. Vous avez affronté ses créatures, défié ses pièges, résisté à ses murmures. Et vous êtes toujours debout.
            Les échos de vos pas résonnent en triomphe dans la grotte silencieuse. Elle s'est inclinée devant vous, aventurier. Vous avez gagné ce qu'aucun autre n'a osé conquérir.
            Levez la tête. La victoire est vôtre.
                """);
    }

     public void displayGameOver(){
        System.out.println("""
            Le sol froid de la grotte accueille votre chute sans un bruit. Personne pour témoin. Personne pour se souvenir.
            Vous avez tout donné — votre sang, votre sueur, votre souffle. Chaque pas arraché à l'obscurité au prix d'une douleur que les mots ne peuvent contenir. Vous avez saigné pour chaque mètre conquis. Et pourtant...
            Ce n'était pas assez.
            La grotte ne célèbre pas sa victoire. Elle n'en a pas besoin. Elle attend, simplement, comme elle a toujours attendu — patiente, implacable, éternelle. Elle vous a consumé comme elle a consumé tous les autres avant vous, sans haine, sans gloire.
            Vous n'étiez qu'un de plus.
            L'obscurité se referme sur vous comme une main froide. Vos yeux cherchent une dernière fois la lumière...
            Elle n'est plus là.
            
            GAME OVER
            
            """);
    }

    // appelée par Game.restartMenu()
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

    public void displayGoodBye (){
        System.out.println("""
    Les ténèbres de la grotte se referment derrière vous comme une plaie ancienne. 
    Au loin, les rugissements des créatures résonnent en échos sourds, comme un dernier avertissement. 
    Vous pressez le pas, les yeux rivés vers la lumière, 
    mais quelque chose en vous sait déjà... la grotte n'a pas fini avec vous. 
    À bientôt, aventurier.
    """);
    }

//----------------------Pour la classe Hero -----//
    public void displayPvRestored(){
        System.out.println("Le héros a retrouvé un peu de son énergie.");
    }
    public void displayPvMax (){
        System.out.println("Le héros a retrouvé tous ses points de vie.");
    }
}
