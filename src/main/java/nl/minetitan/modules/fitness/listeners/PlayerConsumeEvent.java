package nl.minetitan.modules.fitness.listeners;
/*
Door: Maiky
Package: nl.minetitan.modules.fitness.listeners in de class PlayerConsumeEvent.
*/

import nl.minetitan.Core;
import nl.minetitan.handler.enums.MessageKey;
import nl.minetitan.modules.fitness.handler.FitnessHandler;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerConsumeEvent implements Listener {

    @EventHandler
    public void onEat(PlayerItemConsumeEvent e){
        if (e.getItem().getType() == Material.GOLDEN_APPLE){
            if (e.getItem().getDurability() == (short)1){
                MessageKey.send(e.getPlayer(), MessageKey.PLAYER_EAT_ITEM, "Golden Apple");

                FitnessHandler handler = new FitnessHandler();
                handler.grantPoint(e.getPlayer(), 20000);
                handler.checkFitness(e.getPlayer(), true);

                e.getPlayer().remove();
            }else{
                MessageKey.send(e.getPlayer(), MessageKey.PLAYER_EAT_ITEM, "Golden Apple");
            }
        }
        }

}
