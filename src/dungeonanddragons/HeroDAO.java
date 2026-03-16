//package dungeonanddragons;
//
//import dungeonanddragons.DatabaseConnection;
//import dungeonanddragons.equipment.OffensiveEquipment;
//import dungeonanddragons.hero.*;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Classe DAO (Data Access Object) gérant la persistance des héros en base de données.
// * Permet la sauvegarde et le chargement des héros depuis une base MariaDB.
// *
// * TODO : classe en cours de développement — la liaison BDD est à finaliser.
// * Le code est commenté dans l'attente d'une meilleure compréhension de la couche DAO.
// * @author Anne-Laure PLANO
// */
//public class HeroDAO {
//
//
//     /**
//     * Sauvegarde un héros et son équipement en base de données.
//     * @param hero le héros à sauvegarder
//     * @throws Exception si la connexion ou la requête échoue
//     */
//    public void saveHero(Hero hero) throws Exception {
//        int EquipmentId = saveEquipment(hero.getEquipment());
//
//        String sql = "INSERT INTO Hero (Pseudo, Type, PV, MaxPV, ATK, Position, EquipmentId) VALUES (?,?,?,?,?,?,?)";
//        Connection conn = DatabaseConnection.getConnection();
//        PreparedStatement stmt = conn.prepareStatement(sql);
//        try {
//            stmt.setString(1, hero.getPseudo());
//            stmt.setString(2, hero.getType());
//            stmt.setInt(3, hero.getPv());
//            stmt.setInt(4, hero.getMaxPV());
//            stmt.setInt(5, hero.getAtk());
//            stmt.setInt(6, hero.getPosition());
//            stmt.setInt(7, hero.getEquipment().getEquipmentId());
//            stmt.executeUpdate();
//            System.out.println("Héros sauvegardé !");
//        } finally {
//            stmt.close();
//            conn.close();
//        }
//    }
//
//    /**
//     * Sauvegarde un équipement en base de données et retourne son identifiant généré.
//     * @param equipment l'équipement à sauvegarder
//     * @return l'identifiant généré en base
//     * @throws Exception si la connexion ou la requête échoue
//     */
//    private int saveEquipment(OffensiveEquipment equipment) throws Exception {
//        String sql = "INSERT INTO Equipment (Name, Type, ATK) VALUES (?, ?, ?)";
//        try (Connection conn = DatabaseConnection.getConnection();
//             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
//            stmt.setString(1, equipment.getName());
//            stmt.setString(2, equipment.getUserType());
//            stmt.setInt(3, equipment.getAtk());
//            stmt.executeUpdate();
//            ResultSet rs = stmt.getGeneratedKeys();
//            if (rs.next()) return rs.getInt(1);
//        }
//        throw new Exception("Erreur lors de la sauvegarde de l'équipement");
//    }
//
// /**
//     * Charge tous les héros depuis la base de données.
//     * @return la liste de tous les héros
//     * @throws Exception si la connexion ou la requête échoue
//     */
//    public List<Hero> chargeAll() throws Exception {
//        List<Hero> heroes = new ArrayList<>();
//        String sql = "SELECT h.*, e.Name AS EqName, e.Type AS EqType, e.ATK AS EqATK " +
//                "FROM Hero h LEFT JOIN Equipment e ON h.EquipmentId = e.Id";
//        try (Connection conn = DatabaseConnection.getConnection();
//             PreparedStatement stmt = conn.prepareStatement(sql);
//             ResultSet rs = stmt.executeQuery()) {
//            while (rs.next()) {
//                OffensiveEquipment equipment = new OffensiveEquipment(
//                        rs.getString("EqType"),
//                        rs.getInt("EqATK"),
//                        rs.getString("EqName")
//                );
//                Hero hero = new Hero(
//                        rs.getString("Pseudo"),
//                        rs.getString("Type"),
//                        rs.getInt("MaxPV"),
//                        rs.getInt("ATK"),
//                        Equipment("equipment"),
//                        rs.getInt("Position")
//                );
//                heroes.add(hero);
//            }
//        }
//        return heroes;
//    }
//
//    /**
//     * Charge un héros depuis la base de données par son pseudo.
//     * @param pseudo le pseudo du héros à charger
//     * @return le héros correspondant, ou null s'il n'existe pas
//     * @throws Exception si la connexion ou la requête échoue
//     */
//    public Hero chargeHero(String pseudo) throws Exception {
//        String sql = "SELECT h.*, e.Name AS EqName, e.Type AS EqType, e.ATK AS EqATK " +
//                "FROM Hero h LEFT JOIN Equipment e ON h.EquipmentId = e.Id " +
//                "WHERE h.Pseudo = ?";
//        try (Connection conn = DatabaseConnection.getConnection();
//             PreparedStatement stmt = conn.prepareStatement(sql)) {
//            stmt.setString(1, pseudo);
//            ResultSet rs = stmt.executeQuery();
//            if (rs.next()) {
//                OffensiveEquipment equipment = new OffensiveEquipment(
//                        rs.getString("EqType"),
//                        rs.getInt("EqATK"),
//                        rs.getString("EqName")
//                );
//                return new Hero(
//                        rs.getString("Pseudo"),
//                        rs.getString("Type"),
//                        rs.getInt("MaxPV"),
//                        rs.getInt("ATK"),
//                        equipment,
//                        rs.getInt("Position")
//                );
//            }
//        }
//        return null;
//    }
//
//
//
//}
