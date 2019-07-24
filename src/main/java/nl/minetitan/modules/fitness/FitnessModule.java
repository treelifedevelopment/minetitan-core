package nl.minetitan.modules.fitness;
/*
Door: Maiky
Package: nl.minetitan.modules.fitness in de class FitnessModule.
*/

import nl.minetitan.Core;
import nl.minetitan.modules.MinetopiaModule;
import nl.minetitan.modules.fitness.listeners.PlayerConsumeEvent;
import nl.minetitan.modules.fitness.listeners.PlayerWalkEvent;
import org.bukkit.Bukkit;

public class FitnessModule implements MinetopiaModule {

    @Override
    public void start() {
        Bukkit.getPluginManager().registerEvents(new PlayerConsumeEvent(), Core.getInstance());
    }

    @Override
    public void stop() {

    }
}
