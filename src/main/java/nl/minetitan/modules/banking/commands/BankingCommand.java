package nl.minetitan.modules.banking.commands;
/*
Door: Maiky
Package: nl.minetitan.modules.banking.commands in de class BankingCommand.
*/

import nl.minetitan.handler.enums.MessageKey;
import nl.minetitan.interfaces.MinetopiaCommand;
import nl.minetitan.modules.banking.enums.AccountType;
import nl.minetitan.modules.banking.gui.BankUseGUI;
import nl.minetitan.modules.banking.player.BankingAccount;
import nl.minetitan.modules.banking.player.BankingData;
import nl.minetitan.modules.player.MinetopiaPlayer;
import nl.minetitan.modules.player.MinetopiaPlayerData;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class BankingCommand extends MinetopiaCommand {

    public BankingCommand(){
        super("banking", "minetopia.command.moderation.banking");
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        if (!(sender instanceof Player)){
            return true;
        }
        Player p = (Player)sender;

        if (args.length == 0){
            MessageKey.send(p, MessageKey.FORGOT_ARGUMENT);
            return true;
        }else if (args.length == 1){
            switch (args[0].toLowerCase()){
                case "createaccount" :
                    MessageKey.send(p, MessageKey.USE_FOLLOWING_COMMAND_BANKING, "banking", "createaccount", "<personal/buisness/savings>", "<user>", "<identifier>");
                    return true;
                case "openbank" :
                    MessageKey.send(p, MessageKey.USE_FOLLOWING_COMMAND_BANKING_2, "banking", "openbank", "<id>");
                    return true;
                case "getpinpas" :
                    MessageKey.send(p, MessageKey.USE_FOLLOWING_COMMAND_BANKING_2, "banking", "getpinpas", "<id>");
                    return true;
            }

            MessageKey.send(p, MessageKey.WRONG_SUB_COMMAND);
            return true;
        }else if (args.length == 2 || args.length == 3){
            if (args[0].equalsIgnoreCase("getpinpas")){
                String id = args[1];
                int accountID;

                try {
                    accountID = Integer.parseInt(id);
                } catch (NumberFormatException e){
                    MessageKey.send(p, MessageKey.INVALID_NUMBER, id);
                    accountID = -1;
                    return true;
                }

                ItemStack pinpas = new ItemStack(Material.INK_SACK, 1, (short)10);
                ItemMeta meta = pinpas.getItemMeta();
                meta.setLore(Arrays.asList("Rekening ID: " + accountID));
                pinpas.setItemMeta(meta);

                p.getInventory().addItem(pinpas);

                MessageKey.send(p, MessageKey.ADMIN_CREATED_PINPAS, id);
                return true;
            }

            if (args[0].equalsIgnoreCase("openbank")){
                String id = args[1];
                int idParsed;

                try {
                    idParsed = Integer.parseInt(id);
                }catch(NumberFormatException e){
                    MessageKey.send(p, MessageKey.INVALID_NUMBER, id);
                    idParsed = 0;
                    return true;
                }

                BankingData data = new BankingData();

                if (!data.doesAccountExist(idParsed)){
                    MessageKey.send(p, MessageKey.INVALID_BANK_ID);
                    return true;
                }

                new BankUseGUI().openBank(p, idParsed);
                MessageKey.send(p, MessageKey.PLAYER_OPENED_BANK_ADMIN, id);
                return true;
            }else if (args[0].equalsIgnoreCase("createaccount")){
                MessageKey.send(p, MessageKey.USE_FOLLOWING_COMMAND_BANKING, "banking", "createaccount", "<personal/buisness/savings>", "<user>", "<identifier>");
                return true;
            }else{
                MessageKey.send(p, MessageKey.WRONG_SUB_COMMAND);
                return true;
            }
        }else if (args.length == 4){
            if (args[0].equalsIgnoreCase("createaccount")){
                BankingData data = new BankingData();

                String type = args[1];
                String user = args[2];

                List<String> types = new ArrayList<>();

                for (AccountType accountType : AccountType.values()){
                    types.add(accountType.toString().toLowerCase());
                }

                if (!types.contains(type.toLowerCase())){
                    MessageKey.send(p, MessageKey.INVALID_ACCOUNT_TYPE);
                    return true;
                }

                OfflinePlayer of = Bukkit.getOfflinePlayer(user);

                MinetopiaPlayerData mtPlayer = new MinetopiaPlayerData(of.getUniqueId());
                if (mtPlayer.existsInDatabase() && mtPlayer.existsInBankingDatabase()){
                    BankingData bankingData = new BankingData();

                    BankingAccount account = bankingData.createAccount(AccountType.valueOf(type.toUpperCase()), of.getUniqueId(), 0.0, args[3]);

                    if (account != null){
                        MessageKey.send(p, MessageKey.ACCOUNT_CREATED, String.valueOf(account.getID()), of.getUniqueId().toString());
                        return true;
                    }else{
                        p.sendMessage(ChatColor.RED + "Er is iets fout gegaan bij het maken van een account!");
                        return true;
                    }
                }else{
                    MessageKey.send(p, MessageKey.PLAYER_DOESNT_EXISTS);
                    return true;
                }
            }
        }
        return false;
    }
}
