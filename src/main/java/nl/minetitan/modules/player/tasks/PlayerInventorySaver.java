package nl.minetitan.modules.player.tasks;
/*
Door: Maiky
Package: nl.minetitan.modules.player.tasks in de class PlayerInventorySaver.
*/

import nl.minetitan.modules.player.MinetopiaPlayerData;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class PlayerInventorySaver implements Runnable{

    @Override
    public void run() {
        for (Player p : Bukkit.getOnlinePlayers()){
            MinetopiaPlayerData data = new MinetopiaPlayerData(p);
            data.saveInventory(p.getInventory());
            for (ItemStack item : data.getInventoryInner()){
                System.out.println(item);
            }
        }
    }
}
