package dungeonanddragons.hero;

import dungeonanddragons.Color;
import dungeonanddragons.Menu;
import dungeonanddragons.equipment.Equipment;

import javax.management.modelmbean.RequiredModelMBean;
import java.util.Random;

public abstract class Hero {
    private String pseudo;
    private String type;
    private int pv;
    private final int maxPV;
    private int atk;
    private Equipment equipment;
    private Equipment[] bag = new Equipment[6];
    private int position;
    private Random rand = new Random();

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




    public abstract String getDraw();

    public abstract void displayAttack();

    public void decreasePV (int damage){
       if (damage < this.getPv()){
           this.setPv(this.getPv()-damage);
       } else {
           this.setPv(0);
       }
    }

    public boolean isHeroAlive(){
       if (this.getPv()>0){
           return true;
       }return false;
    }

    public void displayVictoryCombat(){
        System.out.println("""
                Votre cri de victoire résonne dans toute la salle. 
                L'adversaire est à terre — et votre sang ne fait que chanter plus fort. 
                Vous avez vaincu l'ennemi !
                """);
    }

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

    public int getAtkTotal(){
        if (this.getEquipment()==null){
            return this.getAtk();
        } else {
            return this.getAtk() + this.getEquipment().getAtk();
        }
    }

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

    public void keepObjectOnTheBag(Equipment object){
        int emptyPocket =99;
        for ( int i=0 ; i<bag.length ; i++){
            if (bag[i] == null){
                emptyPocket = i;
                break;
            }
        }
        if (emptyPocket !=99){
            bag[emptyPocket] = object;
        } else {
            System.out.println("Action impossible ; le sac est plein.");
        }
    }

    public void chooseObjectOnTheBag(Menu menu){
        int indexObject = menu.displayWhatObjectDoYouWantToUse(getBag());
        int chooseAction = menu.displayWhatDoYouWantToDoWithThisObject(getBag()[indexObject].getName());
        switch (chooseAction) {
            case 1:
                useObjectOnTheBag(indexObject);
                break;
            case 2:
                deleteObjectOnTheBag(indexObject, menu);
                break;
            default:
                menu.displayYouDoNothingWithBag();
                break;
        }
    }

    public void deleteObjectOnTheBag(int objectEmplacment, Menu menu){
        menu.displayObjectHasBeenDestroyed(getBag()[objectEmplacment].getName());
        getBag()[objectEmplacment] = null;
    }

    public void useObjectOnTheBag(int objectEmplacment){
        cure(getBag()[objectEmplacment].getPv());
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

    public Equipment[] getBag() {
        return bag;
    }

    public void setBag(Equipment[] bag) {
        this.bag = bag;
    }
}
