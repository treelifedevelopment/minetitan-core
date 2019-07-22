package nl.minetitan.modules.prefix.gui;
/*
Door: Maiky
Package: nl.minetitan.modules.prefix.gui in de class PrefixSelectionGUI.
*/

import nl.minetitan.handler.enums.MessageKey;
import nl.minetitan.modules.player.MinetopiaPlayerData;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

public class PrefixSelectionGUI {

    public void open(Player p){
        MinetopiaPlayerData data = new MinetopiaPlayerData(p);
        List<String> prefixes = data.getPrefixes();

        Inventory inventory = Bukkit.createInventory(null, 3*9,
                MessageKey.GUI_SELECT_PREFIX_TITLE.getMessage().replaceAll("&", "§"));

        for (String prefix : prefixes){
            ItemStack item = new ItemStack(Material.PAPER);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(prefix);

            if (prefix.equalsIgnoreCase("Zwerver")){
                meta.setLore(Arrays.asList("Standaard prefix"));
            }

            if (data.getPrefixScope().equalsIgnoreCase(prefix)){
                meta.addEnchant(Enchantment.DURABILITY, 1, true);
                meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            }

            item.setItemMeta(meta);
            inventory.addItem(item);
        }

        p.openInventory(inventory);
    }

}
