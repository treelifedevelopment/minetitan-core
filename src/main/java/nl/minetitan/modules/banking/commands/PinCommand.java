package nl.minetitan.modules.banking.commands;

import nl.minetitan.handler.BalanceWrapper;
import nl.minetitan.handler.enums.MessageKey;
import nl.minetitan.interfaces.MinetopiaCommand;
import nl.minetitan.modules.banking.enums.AccountType;
import nl.minetitan.modules.banking.listeners.PinListener;
import nl.minetitan.modules.banking.player.BankingAccount;
import nl.minetitan.modules.banking.player.BankingData;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class PinCommand extends MinetopiaCommand {

    public PinCommand(){
        super("pin", "minetopia.player.pin");
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        if (sender instanceof Player){
            Player p = (Player)sender;
            if (args.length == 0){
                MessageKey.send(p, MessageKey.USAGE_PIN, "pin", "set", "<speler>", "<bedrag>");
                return true;
            }

            if (args.length >= 1 && args.length <= 3) {
                if (args[0].equalsIgnoreCase("set")) {
                    if (args.length == 1 || args.length == 2) {
                        MessageKey.send(p, MessageKey.USAGE_PIN, "pin", "set", "<speler>", "<bedrag>");
                        return true;
                    }else{
                        // Variables
                        String player = args[1];
                        String bedrag = args[2];

                        if (player.toLowerCase().equalsIgnoreCase(p.getName().toLowerCase())){
                            MessageKey.send(p, MessageKey.PLAYER_CANNOT_PIN_SET_HIMSELF);
                            return true;
                        }

                        double amount;

                        try {
                            amount = Double.parseDouble(bedrag);
                        } catch (NumberFormatException e){
                            amount = 0.0;
                            MessageKey.send(p, MessageKey.INVALID_NUMBER);
                            return true;
                        }

                        OfflinePlayer tempOffline = Bukkit.getOfflinePlayer(player);
                        Player payer;
                        if (tempOffline.isOnline()){
                            payer = Bukkit.getPlayer(player);
                            tempOffline = null;
                        }else{
                            MessageKey.send(p, MessageKey.PLAYER_DOESNT_EXISTS);
                            payer = null;
                            return true;
                        }

                        BankingData data = new BankingData();
                        List<BankingAccount> accountList = new ArrayList<BankingAccount>();
                        int accounts = 0;

                        for (Map<String,Object> map : data.getAccountsIDs()){
                            for (Object object : map.keySet()) {
                                int rekeningID = Integer.parseInt(String.valueOf(map.get(object)));

                                BankingAccount account = new BankingAccount(rekeningID);

                                if (account.getAccountType() == AccountType.BUISNESS) {

                                    if (account.getHolders().contains(p.getUniqueId().toString())) {
                                        accounts++;

                                        accountList.add(account);
                                    }
                                }
                            }
                        }

                        if (accounts == 0){
                            MessageKey.send(p, MessageKey.PLAYER_DOESNT_HAVE_OR_ISNT_MEMBER_BUISNESS_ACCOUNT);
                            return true;
                        }

                        if (accounts == 1){
                            // Continue
                            HashMap<BankingAccount,Double> map = new HashMap<>();
                            map.put(accountList.get(0), amount);

                            PinListener.getAwaitingPayments().put(payer, map);
                            PinListener.getAwaitingPaymentsExtension().put(payer, p);

                            MessageKey.send(p, MessageKey.PLAYER_STARTED_PIN_PAYMENT_LINE1, "€" +
                                    new BalanceWrapper().convert(amount));
                            MessageKey.send(p, MessageKey.PLAYER_STARTED_PIN_PAYMENT_LINE2, payer.getName());

                            MessageKey.send(payer, MessageKey.PLAYER_RECEIVED_PIN_PAYMENT_LINE1, p.getName());
                            MessageKey.send(payer, MessageKey.PLAYER_RECEIVED_PIN_PAYMENT_LINE2, accountList.get(0).getIdentifier());
                            return true;
                        }

                        if (accounts > 1){

                        }

                    }
                }
            }
        }
        return false;
    }
}
