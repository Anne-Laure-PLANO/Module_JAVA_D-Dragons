package dungeonanddragons.equipment;

public class DefensiveEquipment {
    private String type ;
    private int pv;
    private String name;

    public DefensiveEquipment (String type, int pv, String name){
        this.type = type;
        this.pv = pv;
        this.name = name;
    }

    @Override
    public String toString() {
        return "DefensiveEquipment{" +
                "type='" + type + '\'' +
                ", pv=" + pv +
                ", name='" + name + '\'' +
                '}';
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

    public void setPv(int pv) {
        this.pv = pv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
