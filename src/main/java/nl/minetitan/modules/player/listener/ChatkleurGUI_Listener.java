package nl.minetitan.modules.player.listener;
/*
Door: Maiky
Package: nl.minetitan.modules.player.listener in de class ChatkleurGUI_Listener.
*/

import nl.minetitan.handler.enums.Chatkleur;
import nl.minetitan.handler.enums.MessageKey;
import nl.minetitan.modules.player.MinetopiaPlayerData;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ChatkleurGUI_Listener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e){ Player p = (Player)e.getWhoClicked();
        if (e.getInventory().getName().equalsIgnoreCase(MessageKey.getKey(MessageKey.GUI_TITLE_CHOOSE_CHATKLEUR).replaceAll("&", "§"))){
            if (e.getCurrentItem() != null && e.getCurrentItem().getType() != null){
                e.setCancelled(true);
                if (e.getCurrentItem().getType()== Material.STAINED_GLASS_PANE){

                    if (e.getCurrentItem().getEnchantments().size() > 0){
                        MessageKey.send(p, MessageKey.PLAYER_ALREADY_CHOSE_CHATCOLOR);
                        return;
                    }

                    String itemname = e.getCurrentItem().getItemMeta().getDisplayName();
                    itemname = itemname.toUpperCase();

                    if (itemname.contains(" ")){
                        itemname = itemname.replaceAll(" ", "_");
                    }

                    itemname = ChatColor.stripColor(itemname);

                    Chatkleur kleur = Chatkleur.valueOf(itemname);

                    String colorCode = kleur.getS().replace("&", "");

                    MinetopiaPlayerData data = new MinetopiaPlayerData(p);
                    data.setChatkleurScope(colorCode);

                    MessageKey.send(p, MessageKey.PLAYER_CHOSE_NEW_CHATCOLOR, colorCode);
                    p.closeInventory();
                    return;
                }
            }
        }
    }

}
