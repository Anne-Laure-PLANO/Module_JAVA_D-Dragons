package dungeonanddragons;

import dungeonanddragons.equipment.Equipment;
import dungeonanddragons.hero.Hero;

import java.util.ArrayList;
import java.util.List;

/**
 * Représente le sac d'un héros dans le jeu Donjon et Dragons.
 * Le sac contient un nombre limité d'emplacements pour stocker des équipements.
 * @author Anne-Laure PLANO
 */
public class Bag {

    /** Les emplacements du sac, chacun pouvant contenir un équipement */
    private Equipment[] slots;

    /**
     * Constructeur du sac.
     * @param bagLength le nombre d'emplacements du sac
     */
    public Bag(int bagLength){
        this.slots = new Equipment[bagLength];
    }

    /**
     * Ajoute un équipement dans le premier emplacement libre du sac.
     * Affiche un message si le sac est plein.
     * @param object l'équipement à ajouter
     */
    public void addItem(Equipment object, Menu menu){
        boolean hasEmptyPocket = false;
        int index = 0;
        for ( int i=0 ; i<slots.length ; i++){
            if (slots[i] == null){
                hasEmptyPocket = true;
                index = i;
                break;
            }
        }
        if (hasEmptyPocket){
            slots[index] = object;
        } else {
            System.out.println("Action impossible ; le sac est plein.");
        }
    }

    /**
     * Permet au héros de sélectionner et d'utiliser ou supprimer un objet du sac.
     * @param menu le menu du jeu
     * @param hero le héros qui utilise le sac
     */
    public void selectItem(Menu menu, Hero hero){
        int indexObject = menu.selectItem(slots);
        if  (indexObject == -1){
            menu.displayCloseBag();
        } else{
            int chooseAction = menu.selectItemAction(slots[indexObject].getName());
            switch (chooseAction) {
                case 1:
                    hero.cure(getSlots()[indexObject].getPv());
                    deleteObject(indexObject);
                    break;
                case 2:
                    menu.displayObjectHasBeenDestroyed(getSlots()[indexObject].getName());
                    deleteObject(indexObject);
                    break;
                default:
                    menu.displayYouDoNothingWithBag();
                    break;
            }
        }
    }

    /**
     * Vérifie si le sac est vide.
     * @return true si tous les emplacements sont vides, false sinon
     */
    public boolean isEmpty() {
        for (Equipment slot : slots) {
            if (slot != null) return false;
        }
        return true;
    }

    /**
     * Supprime un équipement du sac à l'index donné.
     * @param indexBag l'index de l'équipement à supprimer
     * @param menu le menu du jeu
     */
    public void deleteObjectOnTheBag(int indexBag, Menu menu) {
        menu.displayObjectHasBeenDestroyed(getBag()[indexBag].getName());

    }

    public void deleteObject(int indexBag){
            getBag()[indexBag] = null;
        }

    public Equipment[] getBag() {
        return slots;
    }

    public void setBag(Equipment[] bag) {
        this.slots = bag;
    }

    public Equipment[] getSlots() {
        return slots;
    }

    public void setSlots(Equipment[] slots) {
        this.slots = slots;
    }
}
