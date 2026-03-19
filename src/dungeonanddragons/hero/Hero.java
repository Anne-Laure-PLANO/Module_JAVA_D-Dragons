package dungeonanddragons.hero;

import dungeonanddragons.Bag;
import dungeonanddragons.Color;
import dungeonanddragons.Combat;
import dungeonanddragons.Menu;
import dungeonanddragons.equipment.Equipment;

import java.util.Random;

/**
 * Classe abstraite représentant un héros dans le jeu Donjon et Dragons.
 * Tout héros possède un pseudo, un type, des points de vie, une attaque,
 * un équipement et un sac. Il implémente l'interface {@link Combat}.
 * @author Anne-Laure PLANO
 */
public abstract class Hero implements Combat {



    /** Le nom du héros */
    private String pseudo;
    /** Le type du héros (guerrier, mage...) */
    private String type;
    /** Les points de vie actuels du héros */
    private int pv;
    /** Les points de vie maximum du héros */
    private final int maxPV;
    /** Les points d'attaque du héros */
    private int atk;
    /** L'équipement porté par le héros */
    private Equipment equipment;
    /** Le sac du héros, contenant jusqu'à 5 objets */
    private Bag bag = new Bag(5);
    /** La position actuelle du héros sur le plateau */
    private int position;
    /** Générateur de nombres aléatoires */
    private Random rand = new Random();


    /**
     * Constructeur d'un héros.
     * @param pseudo le nom du héros
     * @param type le type du héros (guerrier, mage...)
     * @param maxPV les points de vie maximum
     * @param atk les points d'attaque
     * @param equipment l'équipement de départ
     * @param position la position de départ sur le plateau
     */
    public  Hero(String pseudo , String type, int maxPV, int atk, Equipment equipment, int position){
        this.pseudo = pseudo;
        this.type = type;
        this.pv = maxPV;
        this.maxPV = maxPV;
        this.atk = atk;
        this.equipment = equipment;
        this.position = position;
    }
    @Override  //chez parent car méthode existe nativement dans classe Object
    public  String  toString() {
        String equipmentString = (getEquipment() != null) ? getEquipment().getName()  : "vide";
        String equipmentAtk =  (getEquipment() != null) ? String.valueOf(getEquipment().getAtk()) : "0";
        String info = """
        
        
        
        
        
               __________________________
                
                     %s --  %s  --%s
                      Type  %s
                      
              %s  Points d'attaque -> %d  %s
                %s   Points de vie -> %d  %s 
                   
                  %s Equipment -> %s  %s
                  ATK suppl. ->%s %s  %s
              
                     %s - Position %s - %s

               __________________________
            
        """.formatted(
                Color.CYAN , pseudo , Color.RESET,
                type,
                Color.RED , atk , Color.RESET,
                Color.GREEN, pv , Color.RESET,
                Color.SILVER_BRIGHT, equipmentString, Color.RESET,
                Color.RED, equipmentAtk, Color.RESET,
                Color.CYAN, position, Color.RESET
        );

        String[] draw = getDraw().split("\n");
        String[] details = info.split("\n");

        StringBuilder result = new StringBuilder();
        int maxLines = Math.max(draw.length, details.length);

        for (int i = 0; i < maxLines; i++) {
            String ligneDessin = (i < draw.length) ? draw[i] : "";
            String ligneTexte = (i < details.length) ? details[i] : "";
            result.append(String.format("%-40s %s%n", ligneDessin, ligneTexte));
        }
        return result.toString();
    }


    /**
     * Retourne le dessin ASCII propre à chaque héros.
     * @return le dessin sous forme de String
     */
    public abstract String getDraw();

    /**
     * Affiche le message d'attaque propre à chaque héros.
     */
    public abstract void displayAttack();

    /**
     * {@inheritDoc}
     */
    @Override
    public void decreasePV (int damage){
       if (damage < this.getPv()){
           this.setPv(this.getPv()-damage);
       } else {
           this.setPv(0);
       }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isAlive(){
       if (this.getPv()>0){
           return true;
       }return false;
    }

    /**
     * Affiche un message de victoire après un combat.
     */
    public void displayVictoryCombat(){
        System.out.println("""
                Votre cri de victoire résonne dans toute la salle. 
                L'adversaire est à terre — et votre sang ne fait que chanter plus fort. 
                Vous avez vaincu l'ennemi !
                """);
    }

    /**
     * Soigne le héros en ajoutant des points de vie.
     * @param quantity le nombre de points de vie restaurés
     */
    public void cure(int quantity){
        int newPV = this.getPv()+ quantity;

        if (newPV >= this.getMaxPV()){
            this.setPv(this.getMaxPV());

            System.out.println("Le héros a retrouvé tous ses points de vie.");
        } else {
            this.setPv(newPV);
            System.out.println("Le héros a retrouvé un peu de son énergie.");
        }
    }

    /**
     * Retourne l'attaque totale du héros, équipement inclus.
     * @return la somme de l'attaque de base et de l'attaque de l'équipement
     */
    public int getAtkTotal(){
        if (this.getEquipment()==null){
            return this.getAtk();
        } else {
            return this.getAtk() + this.getEquipment().getAtk();
        }
    }

    /**
     * Tente une fuite aléatoire (50% de chances de réussite).
     * @return true si la fuite réussit, false sinon
     */
    public boolean canHeroEscape(){
       int possibility = rand.nextInt(100)+1;
       if  (possibility >= 50){

           System.out.printf("Vous réussissez à fuir.");
           return true;
       } else {
           System.out.println("Votre adversaire vous barre le passage : vous n'avez pas réussi à vous échapper.");
           return false;
       }
    }

    /**
     * Fait reculer le héros d'un nombre aléatoire de cases (1 à 6).
     */
    public void backDown(){
       int goBack = rand.nextInt(6)+1;
       if (this.getPosition() >= goBack){
           this.setPosition(this.getPosition()-goBack);
            System.out.println("Vous reculez de "+ goBack +" cases.");
       } else {
           this.setPosition(0);
           System.out.println("Vous retournez à la case départ.");
       }
   }




    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public int getMaxPV() {
        return maxPV;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPv() {
        return pv;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public Bag getBag() {
        return bag;
    }

}
