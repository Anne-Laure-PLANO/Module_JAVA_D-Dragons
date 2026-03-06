package dungeonanddragons;

import java.sql.Connection;
import java.sql.DriverManager;


public class DatabaseConnectionExample {
    private static final String URL = "jdbc:mariadb://localhost:3306/NOM_BDD";
    private static final String USER = "Ton_USER";
    private static final String PASSWORD = "TON_PASSWORD";

    public static Connection getConnection() throws Exception{
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }


}