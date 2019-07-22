package nl.minetitan.modules.banking.gui;
/*
Door: Maiky
Package: nl.minetitan.modules.banking.gui in de class BankingAccountTypeGUI.
*/

import nl.minetitan.modules.banking.enums.AccountType;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BankingAccountTypeGUI {

    public void open(Player player){
        Inventory inventory = Bukkit.createInventory(null, 3*9, "§3Kies het rekening §btype§3.");

        ItemStack personal = new ItemStack(AccountType.PERSONAL.getItem(), 1, (short)0);
        ItemStack buissness = new ItemStack(AccountType.BUISNESS.getItem(), 1, (short)0);
        ItemStack savings = new ItemStack(AccountType.SAVINGS.getItem(), 1, (short)0);

        ItemMeta personalMeta = personal.getItemMeta();
        ItemMeta buisnessMeta = buissness.getItemMeta();
        ItemMeta savingsMeta = savings.getItemMeta();

        personalMeta.setDisplayName(ChatColor.GOLD + "Persoonlijke rekeningen");
        buisnessMeta.setDisplayName(ChatColor.AQUA + "Bedrijfs rekeningen");
        savingsMeta.setDisplayName(ChatColor.RED + "Spaar rekeningen");

        personal.setItemMeta(personalMeta);
        buissness.setItemMeta(buisnessMeta);
        savings.setItemMeta(savingsMeta);

        inventory.setItem(11, personal);
        inventory.setItem(13, buissness);
        inventory.setItem(15, savings);

        player.openInventory(inventory);
    }

}
