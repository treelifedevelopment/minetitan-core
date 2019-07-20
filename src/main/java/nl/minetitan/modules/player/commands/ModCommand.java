package nl.minetitan.modules.player.commands;
/*
Door: Maiky
Package: nl.minetitan.modules.player.commands in de class ModCommand.
*/

import nl.minetitan.handler.enums.MessageKey;
import nl.minetitan.interfaces.MinetopiaCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ModCommand extends MinetopiaCommand {

    public ModCommand(){
        super("mod", "minetopia.command.moderation");
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;

            if (args.length == 0) {
                sender.sendMessage(ChatColor.RED + "Je moet wel een argument opgeven!");
                return true;
            } else if (args.length == 1) {
                switch (args[0].toLowerCase()) {
                    case "invsee":
                        sender.sendMessage(ChatColor.RED + "Vul een spelernaam in!");
                        sender.sendMessage(ChatColor.RED + "Voorbeeld: /mod invsee Maiky1304");
                        return true;
                    case "setprefix":
                        sender.sendMessage(ChatColor.RED + "Vul een spelernaam & prefix in!");
                        sender.sendMessage(ChatColor.RED + "Voorbeeld: /mod setprefix Maiky1304 Burger");
                        return true;
                    case "setlevel":
                        sender.sendMessage(ChatColor.RED + "Vul een spelernaam & level in!");
                        sender.sendMessage(ChatColor.RED + "Voorbeeld: /mod setlevel Maiky1304 1");
                        return true;
                    case "setfitness":
                        sender.sendMessage(ChatColor.RED + "Vul een spelernaam & fitheid in!");
                        sender.sendMessage(ChatColor.RED + "Voorbeeld: /mod setfitheid Maiky1304 20");
                        return true;
                    case "addlevelcolor":
                        sender.sendMessage(ChatColor.RED + "Vul een spelernaam & levelkleur in!");
                        sender.sendMessage(ChatColor.RED + "Voorbeeld: /mod addlevelkleur Maiky1304 GROEN");
                        return true;
                    case "addchatcolor":
                        sender.sendMessage(ChatColor.RED + "Vul een spelernaam & chatkleur in!");
                        sender.sendMessage(ChatColor.RED + "Voorbeeld: /mod addchatcolor Maiky1304 GROEN");
                        return true;
                }

                sender.sendMessage(ChatColor.RED + "Je hebt geen geldig sub-commando gebruikt.");
                return true;
            } else if (args.length == 2) {
                switch (args[0].toLowerCase()) {
                    case "invsee":
                        String player = args[1];

                        OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(player);

                        if (!offlinePlayer.isOnline()) {
                            sender.sendMessage(ChatColor.RED + "Deze speler is niet online!");
                            return true;
                        }

                        ItemStack[] contents = ((Player)offlinePlayer).getInventory().getContents();

                        Inventory invseeInventory = Bukkit.createInventory(null, InventoryType.PLAYER, "§3Inventory van §b" + offlinePlayer.getName() + "§3.");
                        invseeInventory.setContents(contents);

                        p.openInventory(invseeInventory);

                        MessageKey.send(p, MessageKey.MOD_OPENED_INVSEE_OPENED, offlinePlayer.getName());
                        break;
                }
            }
        }
        return false;
    }
}
