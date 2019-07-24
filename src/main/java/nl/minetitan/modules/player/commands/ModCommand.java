package nl.minetitan.modules.player.commands;
/*
Door: Maiky
Package: nl.minetitan.modules.player.commands in de class ModCommand.
*/

import nl.minetitan.handler.enums.Chatkleur;
import nl.minetitan.handler.enums.MessageKey;
import nl.minetitan.interfaces.MinetopiaCommand;
import nl.minetitan.modules.player.MinetopiaPlayerData;
import nl.minetitan.modules.player.tasks.ScoreboardUpdateTask;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

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
                    case "addprefix":
                        sender.sendMessage(ChatColor.RED + "Vul een spelernaam & prefix in!");
                        sender.sendMessage(ChatColor.RED + "Voorbeeld: /mod addprefix Maiky1304 Burger");
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
                        return true;
                    case "getprefixes" :
                        player = args[1];
                        offlinePlayer = Bukkit.getOfflinePlayer(player);

                        MinetopiaPlayerData data = new MinetopiaPlayerData(Bukkit.getOfflinePlayer(player).getUniqueId());

                        if (!data.existsInDatabase()){
                            MessageKey.send(p, MessageKey.PLAYER_DOESNT_EXISTS);
                            return true;
                        }

                        if (!data.existsInPrefixDatabase()){
                            MessageKey.send(p, MessageKey.PLAYER_DOESNT_EXISTS);
                            return true;
                        }

                        List<String> prefixList = data.getPrefixes();

                        MessageKey.send(p, MessageKey.PERSONAL_HEADER_MESSAGE, "Prefixen", player);

                        for (String prefix : prefixList){
                            MessageKey.send(p, MessageKey.COUNT_UP_MESSAGE, prefix);
                        }
                        return true;
                }

                sender.sendMessage(ChatColor.RED + "Je hebt geen geldig sub-commando gebruikt.");
                return true;
            } else if (args.length >= 3){
                switch (args[0].toLowerCase()){
                    case "addprefix" :
                        String player = args[1];
                        String prefix = "";
                        if (args.length == 3){
                            prefix = args[2];
                        }else if (args.length > 3){
                            for (int i = 2; i != args.length; i++){
                                prefix += args[i] + " ";
                            }

                            prefix = prefix.substring(0, prefix.length()-1);
                        }

                        MinetopiaPlayerData data = new MinetopiaPlayerData(Bukkit.getOfflinePlayer(player).getUniqueId());

                        if (!data.existsInPrefixDatabase()){
                            MessageKey.send(p, MessageKey.PLAYER_DOESNT_EXISTS);
                            return true;
                        }

                        List<String> currentPrefixes = data.getPrefixes();

                        if (currentPrefixes.contains(prefix)){
                            MessageKey.send(p, MessageKey.PLAYER_ALREADY_HAS_PREFIX_PROVIDED);
                            return true;
                        }

                        data.setPrefixes(data.getPrefixesRaw() + ";" + prefix);
                        MessageKey.send(p, MessageKey.PLAYER_ADDED_PREFIX_OF_PLAYER, prefix, player);
                        return true;
                    case "setlevel" :
                        player = args[1];
                        String level = args[2];

                        int levelAsInt = 0;

                        try {
                            levelAsInt= Integer.parseInt(level);
                        } catch (NumberFormatException e){
                            MessageKey.send(p, MessageKey.NUMBER_FORMAT_ERROR);
                            return true;
                        }

                        data = new MinetopiaPlayerData(Bukkit.getOfflinePlayer(player).getUniqueId());

                        if (!data.existsInDatabase()){
                            MessageKey.send(p, MessageKey.PLAYER_DOESNT_EXISTS);
                            return true;
                        }

                        data.setLevel(levelAsInt);

                        MessageKey.send(p, MessageKey.PLAYER_CHANGED_LEVEL_OF_PLAYER, player, level);

                        if (Bukkit.getOfflinePlayer(player).isOnline()){
                            Player playerWhoGotLevelChange = Bukkit.getPlayer(player);
                            ScoreboardUpdateTask.loadScoreboard(playerWhoGotLevelChange);
                        }
                        return true;
                    case "setnaamkleur" :
                        player = args[1];
                        String kleur = args[2];

                        data = new MinetopiaPlayerData(Bukkit.getOfflinePlayer(player).getUniqueId());

                        if (!data.existsInDatabase()){
                            MessageKey.send(p, MessageKey.PLAYER_DOESNT_EXISTS);
                            return true;
                        }

                        data.setNaamkleur(kleur);

                        if (kleur.endsWith("&l")) kleur = kleur.replace("&l", " (Dikgedrukt)");

                        MessageKey.send(p, MessageKey.PLAYER_CHANGED_NAMECOLOR_OF_PLAYER, player, kleur);

                        if (Bukkit.getOfflinePlayer(player).isOnline()){
                            Player playerWhoGotLevelChange = Bukkit.getPlayer(player);
                            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "ne player " + playerWhoGotLevelChange.getName() + " prefix &" + data.getNaamkleur());
                        }
                        return true;
                    case "addchatkleur" :
                        player = args[1];
                        kleur = args[2];

                        if (kleur.equalsIgnoreCase("*")){
                            data = new MinetopiaPlayerData(Bukkit.getOfflinePlayer(player).getUniqueId());

                            if (!data.existsInDatabase()){
                                MessageKey.send(p, MessageKey.PLAYER_DOESNT_EXISTS);
                                return true;
                            }

                            data.setChatkleuren("");

                            for (Chatkleur kleur2 : Chatkleur.values()){
                                data.addChatkleur(kleur2.getS().replace("&", ""));
                            }

                            MessageKey.send(p, MessageKey.PLAYER_ADDED_CHATCOLOR_TO_PLAYER, player, kleur);
                            return true;
                        }else {

                            data = new MinetopiaPlayerData(Bukkit.getOfflinePlayer(player).getUniqueId());

                            if (!data.existsInDatabase()) {
                                MessageKey.send(p, MessageKey.PLAYER_DOESNT_EXISTS);
                                return true;
                            }

                            if (data.getChatcolors().contains(kleur)) {
                                MessageKey.send(p, MessageKey.PLAYER_ALREADY_HAS_CHATCOLOR);
                                return true;
                            }

                            List<String> colors = new ArrayList<String>();

                            for (ChatColor c : ChatColor.values()) {
                                colors.add(String.valueOf(c.getChar()));
                            }

                            if (!colors.contains(kleur)) {
                                MessageKey.send(p, MessageKey.COLOR_DOESNT_EXISTS);
                                return true;
                            }

                            data.addChatkleur(kleur);

                            MessageKey.send(p, MessageKey.PLAYER_ADDED_CHATCOLOR_TO_PLAYER, player, kleur);
                            return true;
                        }

                }
            }
        }
        return false;
    }
}
