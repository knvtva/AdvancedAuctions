package me.knvtva.advancedauctions;

import me.knvtva.advancedauctions.Commands.OpenAuctionGUI.AuctionCommand;
import me.knvtva.advancedauctions.Commands.OpenAuctionGUI.Events.GUIManager;
import me.knvtva.advancedauctions.ConfigManager.ConfigCreator;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import static me.knvtva.advancedauctions.ConfigManager.ConfigCreator.CreatePrimaryConfig;
import static me.knvtva.advancedauctions.ConfigManager.ConfigCreator.primaryConfigFile;


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
