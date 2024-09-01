package me.knvtva.advancedauctions.Database;

import me.knvtva.advancedauctions.ConfigManager.ConfigCreator;
import me.knvtva.advancedauctions.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLManager {

    private static Statement statement;
    private static Connection con;

    public static void MySQLConnect() throws SQLException {

        String host = ConfigCreator.primaryConfigFile.getString("database.host");
        int port = ConfigCreator.primaryConfigFile.getInt("database.port");
        String database = ConfigCreator.primaryConfigFile.getString("database.name");
        String username = ConfigCreator.primaryConfigFile.getString("database.username");
        String password = ConfigCreator.primaryConfigFile.getString("database.password");

        try {
            con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username, password);

            // Creates Players table.
            statement = con.createStatement();
            String sql = "CREATE TABLE Players ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "UUID CHAR(36) NOT NULL, "
                    + "player_name VARCHAR(100) NOT NULL, "
                    + "total_sold_items INT DEFAULT 0, "
                    + "UNIQUE (UUID), "
                    + "INDEX (player_name)"
                    + ")";

            statement.executeUpdate(sql);
        }
        catch (Exception e) {
            Logger.LogError(e.getMessage());
        }
    }

    public static void ExecuteStatement(String SQL) throws SQLException {
        statement = con.createStatement();
        statement.executeUpdate(SQL);
    }
}
