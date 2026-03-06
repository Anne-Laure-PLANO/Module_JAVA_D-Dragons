package dungeonanddragons;

import java.sql.Connection;
import java.sql.DriverManager;


public class DatabaseConnection {
    private static final String URL = "jdbc:mariadb://localhost:3306/donjon_et_dragon";
    private static final String USER = "anne-laure.plano";
    private static final String PASSWORD = "dev";

    public static Connection getConnection() throws Exception{
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }


}
