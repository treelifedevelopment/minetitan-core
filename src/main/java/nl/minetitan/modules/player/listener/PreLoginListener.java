package nl.minetitan.modules.player.listener;
/*
Door: Maiky
Package: nl.minetitan.modules.player.listener in de class PreLoginListener.
*/

import nl.minetitan.handler.Nametag;
import nl.minetitan.modules.player.MinetopiaPlayer;
import nl.minetitan.modules.player.MinetopiaPlayerData;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerPreLoginEvent;
import org.bukkit.scoreboard.Team;

public class PreLoginListener implements Listener {

    @EventHandler
    public void onLogin(PlayerLoginEvent e){
        Player p = (Player)e.getPlayer();


        MinetopiaPlayerData data = new MinetopiaPlayerData(p);
        data.createUser(false);
    }

}
