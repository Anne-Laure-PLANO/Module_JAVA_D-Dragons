package dungeonanddragons;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Exemple de configuration de connexion à la base de données MariaDB.
 * Remplacer les valeurs fictives par les vraies credentials en local.
 * Ne pas committer le fichier contenant les vraies credentials sur GitHub.
 * @author Anne-Laure PLANO
 */
public class DatabaseConnectionExample {

    /** URL de connexion à la base de données */
    private static final String URL = "jdbc:mariadb://localhost:3306/NOM_BDD";
    /** Nom d'utilisateur de la base de données */
    private static final String USER = "Ton_USER";
    /** Mot de passe de la base de données */
    private static final String PASSWORD = "TON_PASSWORD";

    /**
     * Retourne une connexion active à la base de données.
     * @return une instance de {@link Connection}
     * @throws Exception si la connexion échoue
     */
    public static Connection getConnection() throws Exception{
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }


}