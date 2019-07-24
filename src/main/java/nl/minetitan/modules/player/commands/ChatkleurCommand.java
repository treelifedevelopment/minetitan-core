package nl.minetitan.modules.player.commands;
/*
Door: Maiky
Package: nl.minetitan.modules.player.commands in de class ChatkleurCommand.
*/

import nl.minetitan.interfaces.MinetopiaCommand;
import nl.minetitan.modules.player.gui.ChatkleurGUI;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChatkleurCommand extends MinetopiaCommand {

    public ChatkleurCommand(){
        super("chatkleur", "minetopia.player");
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        if (sender instanceof Player){
            Player p = (Player)sender;

            new ChatkleurGUI().open(p);
        }
        return false;
    }
}
