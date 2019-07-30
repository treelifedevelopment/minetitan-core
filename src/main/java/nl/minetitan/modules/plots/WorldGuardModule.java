package nl.minetitan.modules.plots;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import nl.minetitan.handler.CommandHandler;
import nl.minetitan.modules.MinetopiaModule;
import nl.minetitan.modules.plots.commands.PlotInfoCommand;

public class WorldGuardModule implements MinetopiaModule {

    @Override
    public void start() {
        CommandHandler handler = new CommandHandler();
        handler.register("plotinfo", new PlotInfoCommand());
    }

    @Override
    public void stop() {

    }
}
