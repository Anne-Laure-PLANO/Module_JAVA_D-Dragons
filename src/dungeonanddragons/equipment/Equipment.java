package dungeonanddragons.equipment;

import dungeonanddragons.Color;
import dungeonanddragons.Menu;
import dungeonanddragons.hero.Hero;

public abstract class Equipment {
    private int equipmentId;
    private String name;
    private int atk = 0;
    private int pv =0;
    private String userType = "all";

    public Equipment(String name, int atk, int pv, String userType){
        this.equipmentId +=1;
        this.name = name;
        this.atk = atk;
        this.pv = pv;
        this.userType = userType;
    }


    public abstract String draw();

    public abstract String getColor();

    public abstract void interact(Hero heros, Menu menu);



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
