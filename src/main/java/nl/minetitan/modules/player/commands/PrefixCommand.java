package nl.minetitan.modules.player.commands;
/*
Door: Maiky
Package: nl.minetitan.modules.player.commands in de class PrefixCommand.
*/

import nl.minetitan.interfaces.MinetopiaCommand;
import nl.minetitan.modules.prefix.gui.PrefixSelectionGUI;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PrefixCommand extends MinetopiaCommand {

    public PrefixCommand(){
        super("prefix");
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        if (sender instanceof Player){
            new PrefixSelectionGUI().open((Player)sender);
            return true;
        }
        return false;
    }
}
