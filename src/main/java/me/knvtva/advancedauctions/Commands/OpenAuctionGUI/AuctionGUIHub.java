package me.knvtva.advancedauctions.Commands.OpenAuctionGUI;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class AuctionGUIHub {

    public static void OpenGUI(Player player) {
        Inventory gui = Bukkit.createInventory(null, 9, ChatColor.DARK_GREEN + "Auction House");
        ItemStack example_button = new ItemStack(Material.DIAMOND);
        ItemMeta meta = example_button.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(ChatColor.AQUA + "Diamond");
            example_button.setItemMeta(meta);
        }

        gui.setItem(4, example_button);
        player.openInventory(gui);
    }
}
