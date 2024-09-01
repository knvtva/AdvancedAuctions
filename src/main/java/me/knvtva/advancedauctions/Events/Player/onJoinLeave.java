package me.knvtva.advancedauctions.Events.Player;

import me.knvtva.advancedauctions.Database.MySQLManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class onJoinLeave implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if (!e.getPlayer().hasPlayedBefore()) {
            // Using PreparedStatement for better security and performance
            String sql = "INSERT INTO Players (UUID, player_name, total_sold_items) VALUES (?, ?, ?)";
            try (Connection conn = MySQLManager.getConnection();  // Assuming getConnection() method returns a valid connection
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                // Setting the values for the PreparedStatement
                pstmt.setString(1, e.getPlayer().getUniqueId().toString());
                pstmt.setString(2, e.getPlayer().getName());
                pstmt.setInt(3, 0);

                // Executing the update
                pstmt.executeUpdate();

            } catch (SQLException ex) {
                ex.printStackTrace();
                // Optionally, log the error using your logger or take other actions
            }
        }
    }
}
