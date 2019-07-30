package nl.minetitan.modules.banking.listeners;

import nl.minetitan.handler.BalanceWrapper;
import nl.minetitan.handler.enums.MessageKey;
import nl.minetitan.modules.banking.player.BankingAccount;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PinpasListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e){
        if (e.getAction() == Action.LEFT_CLICK_BLOCK || e.getAction() == Action.LEFT_CLICK_AIR){
            if (e.getPlayer().getItemInHand().getType() == Material.INK_SACK
                    && e.getPlayer().getItemInHand().getDurability() == (short)10){
                if (e.getPlayer().getItemInHand().getItemMeta().getLore() != null) {
                    String accountID = e.getPlayer().getItemInHand().getItemMeta().getLore().get(0).replace("Rekening ID: ", "");
                    int id = Integer.parseInt(accountID);

                    BankingAccount account = new BankingAccount(id);
                    if (account.getAccountType() != null){
                        MessageKey.send(e.getPlayer(), MessageKey.PLAYER_HAS_AMOUNT_ON_BANK_ACCOUNT,
                               "€" +  new BalanceWrapper().convert(account.getBalance()));
                        return;
                    }
                }
            }
        }
    }

}
