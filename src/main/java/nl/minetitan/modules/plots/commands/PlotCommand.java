package nl.minetitan.modules.plots.commands;

import nl.minetitan.interfaces.MinetopiaCommand;
import nl.minetitan.modules.plots.handler.WorldGuardHandler;
import org.bukkit.command.CommandSender;

public class PlotCommand extends MinetopiaCommand {

    WorldGuardHandler wgHandler = new WorldGuardHandler();

    public PlotCommand(){
        super("plot", "minetopia.player");
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        if (args.length == 0){

        }
        return false;
    }
}
