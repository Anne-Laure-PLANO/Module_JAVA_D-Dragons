package dungeonanddragons;

import dungeonanddragons.DatabaseConnection;
import dungeonanddragons.equipment.OffensiveEquipment;
import dungeonanddragons.hero.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class HeroDAO {



    public void saveHero(Hero hero) throws Exception {
        int EquipmentId = saveEquipment(hero.getEquipment());

        String sql = "INSERT INTO Hero (Pseudo, Type, PV, MaxPV, ATK, Position, EquipmentId) VALUES (?,?,?,?,?,?,?)";
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        try {
            stmt.setString(1, hero.getPseudo());
            stmt.setString(2, hero.getType());
            stmt.setInt(3, hero.getPv());
            stmt.setInt(4, hero.getMaxPV());
            stmt.setInt(5, hero.getAtk());
            stmt.setInt(6, hero.getPosition());
            stmt.setInt(7, equipmentId);
            stmt.executeUpdate();
            System.out.println("Héros sauvegardé !");
        } finally {
            stmt.close();
            conn.close();
        }
    }

    // Sauvegarder l'équipement et retourner son Id
    private int saveEquipment(OffensiveEquipment equipment) throws Exception {
        String sql = "INSERT INTO Equipment (Name, Type, ATK) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, equipment.getName());
            stmt.setString(2, equipment.getType());
            stmt.setInt(3, equipment.getAtk());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) return rs.getInt(1);
        }
        throw new Exception("Erreur lors de la sauvegarde de l'équipement");
    }


    public List<Hero> chargeAll() throws Exception {
        List<Hero> heroes = new ArrayList<>();
        String sql = "SELECT h.*, e.Name AS EqName, e.Type AS EqType, e.ATK AS EqATK " +
                "FROM Hero h LEFT JOIN Equipment e ON h.EquipmentId = e.Id";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                OffensiveEquipment equipment = new OffensiveEquipment(
                        rs.getString("EqType"),
                        rs.getInt("EqATK"),
                        rs.getString("EqName")
                );
                Hero hero = new Hero(
                        rs.getString("Pseudo"),
                        rs.getString("Type"),
                        rs.getInt("MaxPV"),
                        rs.getInt("ATK"),
                        equipment,
                        rs.getInt("Position")
                );
                heroes.add(hero);
            }
        }
        return heroes;
    }

    // Charger un héros par pseudo
    public Hero chargeHero(String pseudo) throws Exception {
        String sql = "SELECT h.*, e.Name AS EqName, e.Type AS EqType, e.ATK AS EqATK " +
                "FROM Hero h LEFT JOIN Equipment e ON h.EquipmentId = e.Id " +
                "WHERE h.Pseudo = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, pseudo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                OffensiveEquipment equipment = new OffensiveEquipment(
                        rs.getString("EqType"),
                        rs.getInt("EqATK"),
                        rs.getString("EqName")
                );
                return new Hero(
                        rs.getString("Pseudo"),
                        rs.getString("Type"),
                        rs.getInt("MaxPV"),
                        rs.getInt("ATK"),
                        equipment,
                        rs.getInt("Position")
                );
            }
        }
        return null;
    }



}
