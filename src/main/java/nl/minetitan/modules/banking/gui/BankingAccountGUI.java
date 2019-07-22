package nl.minetitan.modules.banking.gui;
/*
Door: Maiky
Package: nl.minetitan.modules.banking.gui in de class BankingAccountGUI.
*/

import nl.minetitan.handler.enums.MessageKey;
import nl.minetitan.modules.banking.enums.AccountType;
import nl.minetitan.modules.banking.player.BankingAccount;
import nl.minetitan.modules.banking.player.BankingData;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class BankingAccountGUI {

    public void open(Player player, AccountType type){
        Inventory inventory = Bukkit.createInventory(null, 3*9, MessageKey.getKey(MessageKey.CHOOSE_AN_ACCOUNT_SDB));

        BankingData data = new BankingData();

        int accounts = 0;

        for (Map<String,Object> map : data.getAccountsIDs()){
            for (Object object : map.keySet()) {
                int rekeningID = Integer.parseInt(String.valueOf(map.get(object)));

                BankingAccount account = new BankingAccount(rekeningID);

                if (account.getAccountType() == type) {

                    if (account.getHolder().equalsIgnoreCase(player.getUniqueId().toString())) {

                        ItemStack item = new ItemStack(account.getAccountType().getItem(), 1, (short) 0);
                        ItemMeta meta = item.getItemMeta();
                        if (account.isPersonal(rekeningID)) {
                            meta.setDisplayName(player.getName());
                        } else {
                            meta.setDisplayName(account.getIdentifier());
                        }

                        meta.setLore(Arrays.asList("§5ID: " + rekeningID));

                        item.setItemMeta(meta);
                        inventory.addItem(item);
                        accounts++;
                    }
                }
            }
        }

        if (accounts == 0){
            if (type == AccountType.PERSONAL){
                player.sendMessage("§cJe hebt §4geen §cpersoonlijke rekeningen.");
            }else if (type == AccountType.BUISNESS){
                player.sendMessage("§cJe hebt §4geen §cbedrijfs rekeningen.");
            }else if (type == AccountType.SAVINGS){
                player.sendMessage("§cJe hebt §4geen §cspaar rekeningen.");
            }
            return;
        }

        player.openInventory(inventory);
    }

}
