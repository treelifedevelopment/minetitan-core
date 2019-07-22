package nl.minetitan.modules.player.tasks;
/*
Door: Maiky
Package: nl.minetitan.modules.player.tasks in de class PlayerUpdater.
*/

import nl.minetitan.Core;
import nl.minetitan.modules.MinetopiaModule;
import org.bukkit.Bukkit;

public class PlayerUpdater implements MinetopiaModule {

    @Override
    public void start() {
        Bukkit.getScheduler().runTaskTimer(Core.getInstance(), new ScoreboardUpdateTask(), 0L, 20L*30L);
        Bukkit.getScheduler().runTaskTimerAsynchronously(Core.getInstance(), new ActionbarDataTask(), 0L, 20L);
        Bukkit.getScheduler().runTaskTimerAsynchronously(Core.getInstance(), new TimeInfoTask(), 0L, 20L);
    }

    @Override
    public void stop() {

    }
}
