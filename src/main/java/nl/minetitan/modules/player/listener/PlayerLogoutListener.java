package nl.minetitan.modules.player.listener;
/*
Door: Maiky
Package: nl.minetitan.modules.player.listener in de class PlayerLogoutListener.
*/

import nl.minetitan.Core;
import nl.minetitan.modules.player.MinetopiaPlayer;
import nl.minetitan.modules.player.MinetopiaPlayerData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerLogoutListener implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        Player p = e.getPlayer();

        MinetopiaPlayerData data = new MinetopiaPlayerData(p.getUniqueId());
        data.saveInventory(p.getInventory());
    }

}
