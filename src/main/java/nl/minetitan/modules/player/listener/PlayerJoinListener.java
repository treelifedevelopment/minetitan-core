package nl.minetitan.modules.player.listener;
/*
Door: Maiky
Package: nl.minetitan.modules.player.listener in de class PlayerJoinListener.
*/

import nl.minetitan.Core;
import nl.minetitan.modules.player.MinetopiaPlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.Scoreboard;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();

        MinetopiaPlayer mt = new MinetopiaPlayer(p);

        Core.getInstance().getTeams().getTeam(mt.getNaamkleur()).addEntry(p.getName());
        p.setScoreboard(Core.getInstance().getTeams());
    }

}
