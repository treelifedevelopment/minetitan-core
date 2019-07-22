package nl.minetitan.modules.banking.gui;
/*
Door: Maiky
Package: nl.minetitan.modules.banking.gui in de class BankUseGUI.
*/

import nl.minetitan.handler.BalanceWrapper;
import nl.minetitan.handler.enums.MessageKey;
import nl.minetitan.modules.banking.player.BankingAccount;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class BankUseGUI {

    public void openBank(Player p, int accountID){
        BankingAccount account = new BankingAccount(accountID);
        Inventory inv = null;

        if (String.valueOf(account.getBalance()).contains(",")){
            inv = Bukkit.createInventory(null, 6*9, String.format(MessageKey.getKey(MessageKey.GUI_TITLE_BANK), new BalanceWrapper().convert(account.getBalance())) + "0");
        }else{
            inv = Bukkit.createInventory(null, 6*9, String.format(MessageKey.getKey(MessageKey.GUI_TITLE_BANK), new BalanceWrapper().convert(account.getBalance())));
        }

        ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)2);
        ItemMeta glassMeta = glass.getItemMeta();
        glassMeta.setDisplayName("§bRekening Informatie");
        glassMeta.setLore(Arrays.asList("§3ID: §b" + accountID, "§3Rekening Type: §b" + account.getAccountType().toString()));
        glass.setItemMeta(glassMeta);

        for (int i = 36; i < 45; i++){
            inv.setItem(i, glass);
        }

        // 500 EURO
        ItemStack item500 = new ItemStack(Material.GHAST_TEAR, 1, (short)0);
        ItemMeta meta = item500.getItemMeta();
        meta.setLore(Arrays.asList(" ", "§3Neem §b€500,00 §3op."));
        item500.setItemMeta(meta);

        double balance = account.getBalance();

        while(balance >= 500){
            inv.addItem(item500);
            balance -= 500;
        }

        // 200 EURO
        ItemStack item200 = new ItemStack(Material.DIAMOND, 1, (short)0);
        ItemMeta meta2 = item200.getItemMeta();
        meta2.setLore(Arrays.asList(" ", "§3Neem §b€200,00 §3op."));
        item200.setItemMeta(meta2);

        while(balance >= 200){
            inv.addItem(item200);
            balance -= 200;
        }

        // 100 EURO
        ItemStack item100 = new ItemStack(Material.REDSTONE, 1, (short)0);
        ItemMeta meta3 = item100.getItemMeta();
        meta3.setLore(Arrays.asList(" ", "§3Neem §b€100,00 §3op."));

        while(balance >= 100){
            inv.addItem(item100);
            balance -= 100;
        }

        // 50 euro
        ItemStack item50 = new ItemStack(Material.EMERALD, 1, (short)0);
        ItemMeta meta4 = item50.getItemMeta();
        meta4.setLore(Arrays.asList(" ", "§3Neem §b€50,00 §3op."));
        item50.setItemMeta(meta4);

        while(balance >= 50){
            inv.addItem(item50);
            balance -= 50;
        }

        // 20 euro
        ItemStack item20 = new ItemStack(Material.COAL, 1, (short)0);
        ItemMeta meta5 = item20.getItemMeta();
        meta5.setLore(Arrays.asList(" ", "§3Neem §b€20,00 §3op."));
        item20.setItemMeta(meta5);

        while(balance >= 20){
            inv.addItem(item20);
            balance -= 20;
        }

        // 10 euro
        ItemStack item10 = new ItemStack(Material.IRON_INGOT, 1, (short)0);
        ItemMeta meta6 = item10.getItemMeta();
        meta6.setLore(Arrays.asList(" ", "§3Neem §b€10,00 §3op."));
        item10.setItemMeta(meta6);

        while(balance >= 10){
            inv.addItem(item10);
            balance -= 10;
        }

        // 5 euro
        ItemStack item5 = new ItemStack(Material.QUARTZ, 1, (short)0);
        ItemMeta meta7 = item5.getItemMeta();
        meta7.setLore(Arrays.asList(" ", "§3Neem §b€5,00 §3op."));
        item5.setItemMeta(meta7);

        while(balance >= 5){
            inv.addItem(item5);
            balance -= 5;
        }

        // 1 euro
        ItemStack item1 = new ItemStack(Material.GOLD_INGOT, 1, (short)0);
        ItemMeta meta8 = item1.getItemMeta();
        meta8.setLore(Arrays.asList(" ", "§3Neem §b€1,00 §3op."));
        item1.setItemMeta(meta8);

        while(balance >= 1){
            inv.addItem(item1);
            balance -= 1;
        }

        // 1 euro
        ItemStack item010 = new ItemStack(Material.GOLD_NUGGET, 1, (short)0);
        ItemMeta meta9 = item010.getItemMeta();
        meta9.setLore(Arrays.asList(" ", "§3Neem §b€0,10 §3op."));
        item010.setItemMeta(meta9);

        double items = Math.round(balance / 0.10);

        balance -= items;
        for (int i = 0; i < (int)items; i++){
            inv.addItem(item010);
        }

        inv.setItem(45, item500);
        inv.setItem(46, item200);
        inv.setItem(47, item100);
        inv.setItem(48, item50);
        inv.setItem(49, item20);
        inv.setItem(50, item10);
        inv.setItem(51, item5);
        inv.setItem(52, item1);
        inv.setItem(53, item010);

        p.openInventory(inv);
    }

}
