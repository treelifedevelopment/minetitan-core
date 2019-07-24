package nl.minetitan.modules.player.listener;
/*
Door: Maiky
Package: nl.minetitan.modules.player.listener in de class BlockBecauseLoading.
*/

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class BlockBecauseLoading implements Listener {

    String MESSAGE = "§4Je inventory is nog niet ingeladen dit kun je niet doen.";

    @EventHandler
    public void onInteract(PlayerInteractEvent e){
        if (PlayerJoinListener.getLoadingPlayers().contains(e.getPlayer().getUniqueId())){
            e.setCancelled(true);
            e.getPlayer().sendMessage(MESSAGE);
        }
    }

    @EventHandler
    public void onInteract(PlayerInteractAtEntityEvent e){
        if (PlayerJoinListener.getLoadingPlayers().contains(e.getPlayer().getUniqueId())){
            e.setCancelled(true);
            e.getPlayer().sendMessage(MESSAGE);
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent e){
        if (PlayerJoinListener.getLoadingPlayers().contains(e.getWhoClicked().getUniqueId())){
            e.setCancelled(true);
            e.getWhoClicked().sendMessage(MESSAGE);
        }
    }

    @EventHandler
    public void onConsume(PlayerItemConsumeEvent e){
        if (PlayerJoinListener.getLoadingPlayers().contains(e.getPlayer().getUniqueId())){
            e.setCancelled(true);
            e.getPlayer().sendMessage(MESSAGE);
        }
    }

}
