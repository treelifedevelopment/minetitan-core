package nl.minetitan.modules.player.gui;
/*
Door: Maiky
Package: nl.minetitan.modules.player.gui in de class ChatkleurGUI.
*/

import nl.minetitan.handler.enums.Chatkleur;
import nl.minetitan.handler.enums.MessageKey;
import nl.minetitan.modules.player.MinetopiaPlayerData;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class ChatkleurGUI {

    public void open(Player p){
        MinetopiaPlayerData data = new MinetopiaPlayerData(p);
        Inventory inventory = Bukkit.createInventory(null, 3*9,
                MessageKey.getKey(MessageKey.GUI_TITLE_CHOOSE_CHATKLEUR).replaceAll("&", "§"));

        for (Chatkleur kleur : Chatkleur.values()){
            if (data.getChatcolors().contains(kleur.getS().replace("&", ""))) {
                ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) kleur.getDurability());

                ItemMeta meta = item.getItemMeta();
                String kleurName = kleur.toString().toLowerCase().replaceAll("_", " ");

                char[] chars = kleurName.toCharArray();
                String newString = String.valueOf(chars[0]).toUpperCase();

                for (int i = 1; i != chars.length; i++) {
                    newString += String.valueOf(chars[i]);
                }

                meta.setDisplayName(ChatColor.translateAlternateColorCodes('&',
                        kleur.getS() + newString));
                meta.setLore(Arrays.asList("Kies om deze kleur te selecteren."));

                if (data.getChatkleurScope().equalsIgnoreCase(kleur.getS().replace("&", ""))) {
                    meta.addEnchant(Enchantment.DURABILITY, 1, true);
                    meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                }

                item.setItemMeta(meta);

                inventory.addItem(item);
            }
        }

        p.openInventory(inventory);
    }

}
