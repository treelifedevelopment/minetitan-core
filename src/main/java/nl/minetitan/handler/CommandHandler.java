package nl.minetitan.handler;
/*
Door: Maiky
Package: nl.minetitan.handler in de class CommandHandler.
*/

import lombok.Getter;
import lombok.Setter;
import nl.minetitan.Core;
import nl.minetitan.interfaces.CommandInterface;
import nl.minetitan.interfaces.MinetopiaCommand;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.HashMap;

public class CommandHandler implements CommandExecutor, CommandInterface {

    @Getter
    Core core = Core.getInstance();

    // Command Map
    @Getter
    @Setter
    public HashMap<String, MinetopiaCommand> commandMap = new HashMap<>();

    @Override
    public void register(String command, MinetopiaCommand mt) {
        if (!commandMap.containsKey(command)){
            commandMap.put(command.toLowerCase(), mt);

            core.getCommand(command.toLowerCase()).setExecutor(this);
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (commandMap.containsKey(command.getName().toLowerCase())){
                if (commandMap.get(command.getName().toLowerCase()).getPermission() != null){
                    if (sender.hasPermission(commandMap.get(command.getName().toLowerCase()).getPermission())){
                        return commandMap.get(command.getName().toLowerCase()).execute(sender, args);
                    }else{
                        sender.sendMessage(ChatColor.RED + "Sorry you don't have the permission " + commandMap.get(command.getName().toLowerCase()).getPermission());
                        return true;
                    }
                }else{
                    return commandMap.get(command.getName().toLowerCase()).execute(sender, args);
                }
            }
        return false;
    }
}
