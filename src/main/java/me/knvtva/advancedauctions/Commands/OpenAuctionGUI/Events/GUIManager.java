package me.knvtva.advancedauctions.Commands.OpenAuctionGUI.Events;

import me.knvtva.advancedauctions.Logger;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class GUIManager implements Listener {

    @EventHandler
    public void onGUIClick(InventoryClickEvent e) {
        Logger.LogDebug("GUI: " + e.getView().getTitle());
        if (e.getWhoClicked() instanceof Player) {
            Player player = (Player) e.getWhoClicked();
            Inventory clickedGUI = e.getClickedInventory();
            ItemStack clickedButton = e.getCurrentItem();

            // Make this a lot better in future for multiple GUI's
            if (e.getView().getTitle().equals(ChatColor.DARK_GREEN + "Auction House")) {
                Logger.LogDebug("We are here.");
                e.setCancelled(true); // Prevents buttons / items from being taken out of the GUI.

                if (clickedButton == null || clickedButton.getType() == Material.AIR) {
                    return;
                }

                if (clickedButton.getType() == Material.DIAMOND) {
                    // Implement a GUI function for ... Material
                }
            }
        }
    }
}
