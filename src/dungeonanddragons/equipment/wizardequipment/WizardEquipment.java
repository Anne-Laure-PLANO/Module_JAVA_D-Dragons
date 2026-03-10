package dungeonanddragons.equipment.wizardequipment;

import dungeonanddragons.Menu;
import dungeonanddragons.equipment.Equipment;
import dungeonanddragons.hero.Hero;

public abstract class WizardEquipment extends Equipment {

    public WizardEquipment(String name, int atk, String userType){
        super(name, atk, userType);
    }

    @Override
    public void interact(Hero heros, Menu menu){
        if (isCompatible(heros.getType())){
            String answer = menu.displayChoiceToChangeEquipment();

            if (answer.equals("change")){
                heros.setEquipment(this);
            }
        } else {
            menu.displayEquipmentIsIncompatible();
        }
    }


    public abstract String toString();


}
