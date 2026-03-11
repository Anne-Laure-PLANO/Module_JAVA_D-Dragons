package dungeonanddragons.equipment.warriorequipment;

import dungeonanddragons.Menu;
import dungeonanddragons.equipment.Equipment;
import dungeonanddragons.hero.Hero;

public abstract class WarriorEquipment extends Equipment {


    public WarriorEquipment(String name, int atk, String userType){
        super(name, atk, userType);
    }

    @Override
    public void interact(Hero heros, Menu menu){
        Equipment actualEquipment = heros.getEquipment();
        if (isCompatible(heros.getType())){
            String answer = menu.displayChoiceToChangeEquipment();

            // option change
            if (answer.equals("change")){
                heros.setEquipment(this);
            }
        } else {
            menu.displayEquipmentIsIncompatible();
        }
    }


    public  String toString(){
        return "\n"+
                "__________________________________________\n"+
                "            Objet trouvé : " + getName() + "\n" +
                " Effet : PV augmentés de : " + getAtk() + "\n" +
                "          Héros concerné : " + getUserType() + "\n" +
                "__________________________________________\n";
    }
}
