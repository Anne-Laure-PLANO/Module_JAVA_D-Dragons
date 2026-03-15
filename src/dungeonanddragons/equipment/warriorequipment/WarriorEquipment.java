package dungeonanddragons.equipment.warriorequipment;

import dungeonanddragons.Menu;
import dungeonanddragons.equipment.Equipment;
import dungeonanddragons.hero.Hero;

public abstract class WarriorEquipment extends Equipment {


    public WarriorEquipment(String name, int atk, String userType){
        super(name, atk, 0, userType);
    }


    public abstract String draw();

    public abstract String getColor();


    @Override
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


}
