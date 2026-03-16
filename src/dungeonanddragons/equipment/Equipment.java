package dungeonanddragons.equipment;

import dungeonanddragons.Color;
import dungeonanddragons.Menu;
import dungeonanddragons.hero.Hero;

/**
 * Classe abstraite représentant un équipement dans le jeu Donjon et Dragons.
 * Un équipement peut augmenter l'attaque ou restaurer des points de vie du héros.
 * Il peut être réservé à un type de héros spécifique ou utilisable par tous.
 * @author Anne-Laure PLANO
 */
public abstract class Equipment {

    /** L'identifiant unique de l'équipement */
    private int equipmentId;
    /** Le nom de l'équipement */
    private String name;
    /** Les points d'attaque supplémentaires apportés par l'équipement */
    private int atk = 0;
    /** Les points de vie restaurés par l'équipement */
    private int pv =0;
    /** Le type de héros autorisé à utiliser l'équipement ("all" par défaut) */
    private String userType = "all";

    /**
     * Constructeur d'un équipement.
     * @param name le nom de l'équipement
     * @param atk les points d'attaque supplémentaires
     * @param pv les points de vie restaurés
     * @param userType le type de héros autorisé à utiliser l'équipement
     */
    public Equipment(String name, int atk, int pv, String userType){
        this.equipmentId +=1;
        this.name = name;
        this.atk = atk;
        this.pv = pv;
        this.userType = userType;
    }

    /**
     * Retourne le dessin ASCII propre à chaque équipement.
     * @return le dessin sous forme de String
     */
    public abstract String draw();

    /**
     * Retourne la couleur associée à l'équipement pour l'affichage.
     * @return la couleur sous forme de String
     */
    public abstract String getColor();

    /**
     * Définit l'interaction par défaut avec le héros.
     * Vérifie la compatibilité, propose d'équiper ou de remplacer l'équipement actuel.
     * @param heros le héros qui interagit avec l'équipement
     * @param menu le menu du jeu
     */
    public void interact(Hero heros, Menu menu){
        Equipment actualEquipment = heros.getEquipment();
        String answer;
        if (isCompatible(heros.getType())){
            if (actualEquipment ==null){
                answer = menu.displayChoiceToTakeEquipment();
            } else{
                answer = menu.displayChoiceToChangeEquipment();
            }
            // option change
            if (answer.equals("change")){
                heros.setEquipment(this);
            }
        } else {
            menu.displayEquipmentIsIncompatible();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString(){

        String effect ="";
        int resultEffect;
        if (getAtk()==0){
            effect = "Restauration de PV de ";
            resultEffect = getPv();
        } else  {
            effect = "Augmentation de l'ATK de ";
            resultEffect = getAtk();
        }

        String info = """
                    __________________________________________
                     
                         %s Vous avez trouvé : %s  ! %s
                           
                           Effet :
                          %s  %s  : %d  %s
                         
                            Utilisable par %s %s %s
                         
                    __________________________________________    
                    """.formatted(
                        Color.YELLOW, getName(),Color.RESET,
                Color.RED, effect, resultEffect, Color.RESET,
                Color.BLUE, getUserType(), Color.RESET
        );

        String[] details = info.split("\n");
        String[] draw = draw().split("\n");

        StringBuilder result = new StringBuilder();
        int maxLines = Math.max(details.length, draw.length);

        for (int i=0 ; i<maxLines ; i++){
            String lineDraw = (i< draw.length)? getColor() + draw[i] + Color.RESET : "";
            String lineInfo = (i< details.length)? details[i] : "";
            result.append(String.format("%-60s %s%n", lineDraw, lineInfo));
        }
        return result.toString();
    }


    /**
     * Vérifie si l'équipement est compatible avec le type du héros.
     * @param typeHeros le type du héros
     * @return true si compatible, false sinon
     */
    public boolean isCompatible(String typeHeros){
        if (this.getUserType().equals(typeHeros) || this.getUserType().equals("all")){
            return true;
        }
        return false;
    }


    public int getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(int equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

}
