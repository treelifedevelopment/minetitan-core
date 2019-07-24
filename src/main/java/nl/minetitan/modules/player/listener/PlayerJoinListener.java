package nl.minetitan.modules.player.listener;
/*
Door: Maiky
Package: nl.minetitan.modules.player.listener in de class PlayerJoinListener.
*/

import lombok.Getter;
import nl.minetitan.Core;
import nl.minetitan.handler.Nametag;
import nl.minetitan.modules.player.MinetopiaPlayer;
import nl.minetitan.modules.player.tasks.ScoreboardUpdateTask;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PlayerJoinListener implements Listener {

    @Getter
    private static List<UUID> loadingPlayers = new ArrayList<>();

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();

        MinetopiaPlayer mtPlayer = new MinetopiaPlayer(p);

        p.setWalkSpeed(0.4F);

        ScoreboardUpdateTask.loadScoreboard(p);

        long start = System.currentTimeMillis();

        p.sendMessage(ChatColor.translateAlternateColorCodes('&',
                "&cJe inventory wordt ingeladen..."));

        loadingPlayers.add(p.getUniqueId());

        Bukkit.getScheduler().runTaskLaterAsynchronously(Core.getInstance(), new BukkitRunnable() {
            @Override
            public void run() {
                mtPlayer.loadInventory();
                p.sendMessage(ChatColor.GREEN + "Je inventory is succesvol ingeladen in " + ((System.currentTimeMillis()-start)) + "ms.");
                loadingPlayers.remove(p.getUniqueId());
            }
        },20L);
    }

}
