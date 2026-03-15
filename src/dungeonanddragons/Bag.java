package dungeonanddragons;

import dungeonanddragons.equipment.Equipment;
import dungeonanddragons.hero.Hero;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private Equipment[] slots;

    public Bag(int bagLength){
        this.slots = new Equipment[bagLength];
    }

    public void addItem(Equipment object){
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

    public void selectItem(Menu menu, Hero hero){
        int indexObject = menu.selectItem(slots);
        if  (indexObject == -1){
            menu.displayCloseBag();
        } else{
            int chooseAction = menu.selectItemAction(slots[indexObject].getName());
            switch (chooseAction) {
                case 1:
                    hero.useObjectOnTheBag(indexObject);
                    break;
                case 2:
                    deleteObjectOnTheBag(indexObject, menu);
                    break;
                default:
                    menu.displayYouDoNothingWithBag();
                    break;
            }

        }
    }



    public boolean isEmpty() {
        for (Equipment slot : slots) {
            if (slot != null) return false;
        }
        return true;
    }


    public void deleteObjectOnTheBag(int indexBag, Menu menu){
        menu.displayObjectHasBeenDestroyed(getBag()[indexBag].getName());
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
