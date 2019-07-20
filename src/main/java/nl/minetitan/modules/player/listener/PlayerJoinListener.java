package nl.minetitan.modules.player.listener;
/*
Door: Maiky
Package: nl.minetitan.modules.player.listener in de class PlayerJoinListener.
*/

import nl.minetitan.Core;
import nl.minetitan.modules.player.MinetopiaPlayer;
import nl.minetitan.modules.player.tasks.ScoreboardUpdateTask;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();

        MinetopiaPlayer mtPlayer = new MinetopiaPlayer(p);

        ScoreboardUpdateTask.loadScoreboard(p);
    }

}
