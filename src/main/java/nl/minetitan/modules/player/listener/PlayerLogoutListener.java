package nl.minetitan.modules.player.listener;
/*
Door: Maiky
Package: nl.minetitan.modules.player.listener in de class PlayerLogoutListener.
*/

import nl.minetitan.Core;
import nl.minetitan.modules.player.MinetopiaPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerLogoutListener implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        Player p = e.getPlayer();

        MinetopiaPlayer mt = new MinetopiaPlayer(p);
        if (Core.getInstance().getTeams().getTeam(mt.getNaamkleur()).getEntries().contains(p.getName())){
            Core.getInstance().getTeams().getTeam(mt.getNaamkleur()).removeEntry(mt.getNaamkleur());
        }
    }

}
