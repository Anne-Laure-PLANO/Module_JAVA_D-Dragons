package dungeonanddragons;

import dungeonanddragons.hero.Hero;
import dungeonanddragons.hero.Warrior;
import dungeonanddragons.hero.Wizard;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    //affiche messages
    // et récupère saisies utilisateur
    private Scanner sc;

    public Menu() {
        this.sc = new Scanner(System.in);
    }

    //condition du menu si option Jouer est choisie sans Player créé.
    public void needPlayerToPlay (){
        System.out.println("Pour jouer, vous devez d'abord créer un héros.");
    }

    public void optionQuitGame (){
        System.out.println("Vous quittez la grotte comme le lâche que vous êtes. Au revoir.");
    }

// Menu d'accueil qui affiche les options et redirige en fonction
    // déclenché par Game.startMenu()
    public int startMenu (){
        boolean bug = true;
        int userChoice = 0;
        while (bug) {
            try{
                System.out.println("""
                    Bienvenue.
                    Indiquez votre choix :
                    1 - Nouveau personnage
                    2 - Modifier les informations du personnage
                    3 - Lancer le jeu
                    4 - Quitter le jeu
                    
                    """);
                userChoice = sc.nextInt();
                sc.nextLine();
                switch (userChoice){
                    case 1 :
                        System.out.println("C'est parti pour la création d'un nouveau personnage !");
                        bug = false;
                    case 2 :
                        System.out.println("Allons modifier ton personnage");
                        bug = false;
                    case 3:
                        System.out.println("Entrons dans la grotte alors.");
                        bug = false;
                    case 4 :
                        System.out.println("Tu préfères abandonner maintenant ? Pas de soucis, reviens plus tard.");
                        bug = false;
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


//Définit les attributs du héros et renvoie vers la méthode de création d'un personnage
//utilisé par Game. createNewPlayer()
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
                }
                System.out.println("Erreur, merci de saisir un des chiffre mentionnés.");
            } catch (InputMismatchException e) {
                System.out.println("Erreur : merci de sélectionner un chiffre uniquement ");
                sc.nextLine();
            } catch (NullPointerException e) {
                System.out.println("Erreur : t'es sensé faire un choix, l'ami !");
                sc.nextLine();
            }
        }
        return typeCharacter;
    }


//utilisé par Game. createNewPlayer()
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






}
