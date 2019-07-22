package nl.minetitan.modules.player.listener;
/*
Door: Maiky
Package: nl.minetitan.modules.player.listener in de class PrefixGUIClick.
*/

import nl.minetitan.handler.enums.MessageKey;
import nl.minetitan.modules.player.MinetopiaPlayerData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class PrefixGUIClick implements Listener {

    @EventHandler
    public void onInv(InventoryClickEvent e){
        if (e.getInventory().getName().equalsIgnoreCase(
                MessageKey.GUI_SELECT_PREFIX_TITLE.getMessage().replaceAll("&", "§")
        )){
            e.setCancelled(true);

            Player p = (Player)e.getWhoClicked();

            if (e.getCurrentItem().getEnchantments().size() != 0){
                MessageKey.send(p, MessageKey.ALREADY_CHOSE_PREFIX);
                return;
            }

            String prefix = e.getCurrentItem().getItemMeta().getDisplayName();
            MinetopiaPlayerData data = new MinetopiaPlayerData(p);

            data.setPrefixScope(prefix);
            MessageKey.send(p, MessageKey.PLAYER_CHOSE_PREFIX, prefix);

            p.closeInventory();
            return;
        }
    }

}
