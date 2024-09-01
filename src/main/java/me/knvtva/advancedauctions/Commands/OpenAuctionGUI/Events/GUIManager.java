package me.knvtva.advancedauctions.Commands.OpenAuctionGUI.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class GUIManager implements Listener {

    @EventHandler
    public void onGUIClick(InventoryClickEvent e) {
        if (!(e.getWhoClicked() instanceof Player)) {
            Player player = (Player) e.getWhoClicked();
            Inventory clickedGUI = e.getClickedInventory();
            ItemStack clickedButton = e.getCurrentItem();

            if (e.getView().getTitle().equals())
        }
    }
}
