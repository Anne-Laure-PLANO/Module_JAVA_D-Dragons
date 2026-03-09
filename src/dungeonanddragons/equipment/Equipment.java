package dungeonanddragons.equipment;

public class Equipment {
    private int equipmentId;
    private String name;
    private int atk =0;
    private String userType = "all";

    public Equipment(String name, int atk, String userType){
        this.equipmentId +=1;
        this.name = name;
        this.atk = atk;
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "OffensiveEquipment{" +
                "type='" + userType + '\'' +
                ", atk=" + atk +
                ", name='" + name + '\'' +
                '}';
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
}
