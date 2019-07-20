package nl.minetitan.modules.player.listener;
/*
Door: Maiky
Package: nl.minetitan.modules.player.listener in de class PreLoginListener.
*/

import nl.minetitan.modules.player.MinetopiaPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerPreLoginEvent;

public class PreLoginListener implements Listener {

    @EventHandler
    public void onLogin(PlayerLoginEvent e){
        Player p = (Player)e.getPlayer();

        MinetopiaPlayer player = new MinetopiaPlayer(p);
        player.createUser(false);
    }

}
