package me.knvtva.advancedauctions;

import com.sun.tools.sjavac.Log;
import org.bukkit.Bukkit;

import java.util.logging.Level;

public class Logger {

    private static boolean Debugging = true;
    public static void LogDebug(String msg) {
        if (Debugging) {
            Bukkit.getLogger().log(Level.INFO, "[AdvancedAuctions] <DEBUG> " + msg);
        }
    }

    public static void LogInfo(String info) {
        if (Debugging) {
            Bukkit.getLogger().log(Level.INFO, "[AdvancedAuctions] <INFO> " + info);
        }
    }

    public static void LogWarning(String warning) {
        if (Debugging) {
            Bukkit.getLogger().log(Level.INFO, "[AdvancedAuctions] <WARNING> " + warning);
        }
    }

    public static void LogError(String error) {
        if (Debugging) {
            Bukkit.getLogger().log(Level.INFO, "[AdvancedAuctions] <ERROR> " + error);
        }
    }

}
