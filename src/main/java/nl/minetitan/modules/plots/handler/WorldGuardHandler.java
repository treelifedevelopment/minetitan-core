package nl.minetitan.modules.plots.handler;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class WorldGuardHandler {

    public WorldGuardPlugin getWorldGuard(){
        Plugin plugin = null;
        if (Bukkit.getPluginManager().isPluginEnabled("WorldGuard")){
            plugin = Bukkit.getPluginManager().getPlugin("WorldGuard");
        }else{
            return null;
        }

        return (WorldGuardPlugin)plugin;
    }

}
