package nl.minetitan.modules.banking.listeners;
/*
Door: Maiky
Package: nl.minetitan.modules.banking.listeners in de class BankAccountListener.
*/

import nl.minetitan.modules.banking.enums.AccountType;
import nl.minetitan.modules.banking.gui.BankingAccountGUI;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class BankAccountListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){
        if (e.getInventory().getName().equalsIgnoreCase("§3Kies het rekening §btype§3.")){
            if (e.getCurrentItem() != null){
                Material personal = AccountType.PERSONAL.getItem();
                Material buisness = AccountType.BUISNESS.getItem();
                Material savings = AccountType.SAVINGS.getItem();

                e.setCancelled(true);

                if (e.getCurrentItem().getType() == personal){
                    new BankingAccountGUI().open((Player)e.getWhoClicked(), AccountType.PERSONAL);
                }else if (e.getCurrentItem().getType() == buisness){
                    new BankingAccountGUI().open((Player)e.getWhoClicked(), AccountType.BUISNESS);
                }else if (e.getCurrentItem().getType() == savings){
                    new BankingAccountGUI().open((Player)e.getWhoClicked(), AccountType.SAVINGS);
                }
            }
        }
    }

}
