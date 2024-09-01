package me.knvtva.advancedauctions.ConfigManager;

import me.knvtva.advancedauctions.Logger;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class ConfigCreator {

    public static YamlConfiguration primaryConfigFile;
    private static File pluginDirectory;


    public static void initialize(JavaPlugin plugin) {
        pluginDirectory = plugin.getDataFolder();
    }


    public static void CreatePrimaryConfig() {
        if (!pluginDirectory.exists()) {
            pluginDirectory.mkdirs();
        }


        File primaryConfig = new File(pluginDirectory + "/config.yml");
        try {
            if(primaryConfig.createNewFile()) {
                Logger.LogInfo("Created Primary Config...");
                primaryConfigFile = YamlConfiguration.loadConfiguration(primaryConfig);
                primaryConfigFile.set("database.host", "");
                primaryConfigFile.set("database.port", 3306);
                primaryConfigFile.set("database.name", "");
                primaryConfigFile.set("database.username", "");
                primaryConfigFile.set("database.password", "");
                primaryConfigFile.set("auctions.max-auctions", 5);
                primaryConfigFile.save(primaryConfig);
            } else {
                Logger.LogInfo("Reading Primary Config Data...");
            }
        } catch (Exception e) {
            Logger.LogError("An error occurred trying to create primary config.");
            Logger.LogError(e.getMessage());
        }
    }
}
