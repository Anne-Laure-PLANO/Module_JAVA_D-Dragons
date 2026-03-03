package dungeonanddragons.equipment;

public class OffensiveEquipment {
    private String type ;
    private int atk;
    private String name;

    public OffensiveEquipment (String type, int atk, String name){
        this.type = type;
        this.atk = atk;
        this.name = name;
    }

    @Override
    public String toString() {
        return "OffensiveEquipment{" +
                "type='" + type + '\'' +
                ", atk=" + atk +
                ", name='" + name + '\'' +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
