package me.knvtva.advancedauctions;

import me.knvtva.advancedauctions.Commands.OpenAuctionGUI.AuctionCommand;
import me.knvtva.advancedauctions.ConfigManager.ConfigCreator;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import static me.knvtva.advancedauctions.ConfigManager.ConfigCreator.CreatePrimaryConfig;
import static me.knvtva.advancedauctions.ConfigManager.ConfigCreator.primaryConfigFile;


public final class AdvancedAuctions extends JavaPlugin {

    @Override
    public void onEnable() {
        Logger.LogInfo("Plugin Starting...");
        Logger.LogInfo("Reading config files...");
        try {
            ConfigCreator.initialize(this);
            CreatePrimaryConfig();
        } catch (Exception e) {
            Logger.LogError(e.getMessage());
        }

        this.getCommand("auction").setExecutor(new AuctionCommand());

        Logger.LogInfo("Loaded!");
    }

    @Override
    public void onDisable() {

    }
}
