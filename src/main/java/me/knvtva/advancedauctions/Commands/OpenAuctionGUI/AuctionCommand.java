package me.knvtva.advancedauctions.Commands.OpenAuctionGUI;

import jdk.jpackage.internal.Log;
import me.knvtva.advancedauctions.Logger;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AuctionCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can execute this command.");
            return false;
        }

        Player player = (Player) sender;
        AuctionGUIHub.OpenGUI(player);
        return true;
    }

}
