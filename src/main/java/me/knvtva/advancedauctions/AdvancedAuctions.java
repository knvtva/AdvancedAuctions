package me.knvtva.advancedauctions;

import me.knvtva.advancedauctions.Commands.OpenAuctionGUI.AuctionCommand;
import me.knvtva.advancedauctions.Events.GUI.GUIManager;
import me.knvtva.advancedauctions.ConfigManager.ConfigCreator;
import me.knvtva.advancedauctions.Database.MySQLManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;

import static me.knvtva.advancedauctions.ConfigManager.ConfigCreator.CreatePrimaryConfig;


public final class AdvancedAuctions extends JavaPlugin {

    @Override
    public void onEnable() {
        Logger.LogInfo("Plugin Starting... v0.1");
        Logger.LogInfo("Reading config files...");
        try {
            ConfigCreator.initialize(this);
            CreatePrimaryConfig();
        } catch (Exception e) {
            Logger.LogError(e.getMessage());
        }

        try {
            MySQLManager.MySQLConnect();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // Build a better command registerer
        this.getCommand("auction").setExecutor(new AuctionCommand());

        // Build a better event registerer
        this.getServer().getPluginManager().registerEvents(new GUIManager(), this);

        Logger.LogInfo("Loaded!");
    }

    @Override
    public void onDisable() {

    }
}
