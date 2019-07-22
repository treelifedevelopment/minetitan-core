package nl.minetitan.modules.player.listener;
/*
Door: Maiky
Package: nl.minetitan.modules.player.listener in de class InteractWithSDB.
*/

import nl.minetitan.handler.enums.MessageKey;
import nl.minetitan.modules.banking.gui.BankingAccountGUI;
import nl.minetitan.modules.banking.gui.BankingAccountTypeGUI;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

public class InteractWithSDB implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e){
        if (e.getHand() == EquipmentSlot.HAND && e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (e.getClickedBlock().getType() == Material.RED_SANDSTONE_STAIRS) {
                Player p = e.getPlayer();

                new BankingAccountTypeGUI().open(p);
                MessageKey.send(p, MessageKey.PLAYER_OPENED_SDB);
            }
        }
    }

}
