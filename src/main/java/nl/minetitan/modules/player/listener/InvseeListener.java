package nl.minetitan.modules.player.listener;
/*
Door: Maiky
Package: nl.minetitan.modules.player.listener in de class InvseeListener.
*/

import nl.minetitan.handler.enums.MessageKey;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

public class InvseeListener implements Listener {

    @EventHandler
    public void onInventoryInteraction(InventoryClickEvent e){
        if (e.getInventory().getType() == InventoryType.PLAYER){
            if (e.getInventory().getName().contains("Inventory van ")){
                if (e.getCurrentItem().getType() != Material.AIR) {

                    MessageKey.send((Player) e.getWhoClicked(), MessageKey.INVSEE_CANT_EDIT_ITEMS);
                    e.setCancelled(true);
                }
            }
        }
    }

}
