package nl.minetitan.modules.banking.listeners;
/*
Door: Maiky
Package: nl.minetitan.modules.banking.listeners in de class BankListener.
*/

import nl.minetitan.handler.BalanceWrapper;
import nl.minetitan.handler.enums.MessageKey;
import nl.minetitan.modules.banking.gui.BankUseGUI;
import nl.minetitan.modules.banking.player.BankingAccount;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class BankListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){
            if (e.getInventory().getName().equalsIgnoreCase(MessageKey.getKey(MessageKey.CHOOSE_AN_ACCOUNT_SDB))) {
                if (e.getClick() == ClickType.RIGHT || e.getClick() == ClickType.LEFT) {
                    String ID;
                    if (e.getCurrentItem() != null){
                        if (e.getCurrentItem().getItemMeta() == null){
                            e.setCancelled(true);
                            return;
                        }
                        ID = ChatColor.stripColor(e.getCurrentItem().getItemMeta().getLore().get(0)).replace("ID: ", "");
                    }else{
                        e.setCancelled(true);
                        return;
                    }
                    int accountID = Integer.parseInt(ID);

                    new BankUseGUI().openBank((Player) e.getWhoClicked(), accountID);
                    e.setCancelled(true);
                    return;
                } else{
                    e.setCancelled(true);
                }
            }
    }

    @EventHandler
    public void onInvClick(InventoryClickEvent e){
        if (e.getInventory().getName().contains("Totale waarde:")){
            String accountID = ChatColor.stripColor(e.getInventory().getItem(36).getItemMeta().getLore().get(0)).replace("ID: ", "");
            BankingAccount account = new BankingAccount(Integer.parseInt(accountID));

            e.setCancelled(true);

            int i = e.getRawSlot();

            if (i >= 45 && i <= 53){
                //TODO: Withdraw 1 of the items
                if (e.getWhoClicked().getInventory().firstEmpty() == -1){
                    MessageKey.send((Player)e.getWhoClicked(), MessageKey.NOT_ENOUGH_INVENTORY_SPACE);
                    e.setCancelled(true);
                    return;
                }

                if (e.getCurrentItem().getType() == Material.GHAST_TEAR){
                    if (!account.has(500.00)){
                        MessageKey.send((Player)e.getWhoClicked(), MessageKey.NOT_ENOUGH_BALANCE);
                        return;
                    }
                    account.take(500.00);
                    e.getWhoClicked().getInventory().addItem(new ItemStack(e.getCurrentItem().getType(), 1));
                    MessageKey.send((Player)e.getWhoClicked(), MessageKey.WITHRAW_MONEY, new BalanceWrapper().convert(500));
                }else if (e.getCurrentItem().getType() == Material.DIAMOND){
                    if (!account.has(200.00)){
                        MessageKey.send((Player)e.getWhoClicked(), MessageKey.NOT_ENOUGH_BALANCE);
                        return;
                    }
                    account.take(200.00);
                    e.getWhoClicked().getInventory().addItem(new ItemStack(e.getCurrentItem().getType(), 1));
                    MessageKey.send((Player)e.getWhoClicked(), MessageKey.WITHRAW_MONEY, new BalanceWrapper().convert(200));
                }else if (e.getCurrentItem().getType() == Material.REDSTONE){
                    if (!account.has(100.00)){
                        MessageKey.send((Player)e.getWhoClicked(), MessageKey.NOT_ENOUGH_BALANCE);
                        return;
                    }
                    account.take(100.00);
                    e.getWhoClicked().getInventory().addItem(new ItemStack(e.getCurrentItem().getType(), 1));
                    MessageKey.send((Player)e.getWhoClicked(), MessageKey.WITHRAW_MONEY, new BalanceWrapper().convert(100));
                }else if (e.getCurrentItem().getType() == Material.EMERALD){
                    if (!account.has(50.00)){
                        MessageKey.send((Player)e.getWhoClicked(), MessageKey.NOT_ENOUGH_BALANCE);
                        return;
                    }
                    account.take(50.00);
                    e.getWhoClicked().getInventory().addItem(new ItemStack(e.getCurrentItem().getType(), 1));
                    MessageKey.send((Player)e.getWhoClicked(), MessageKey.WITHRAW_MONEY,new BalanceWrapper().convert(50));
                }else if (e.getCurrentItem().getType() == Material.COAL){
                    if (!account.has(20.00)){
                        MessageKey.send((Player)e.getWhoClicked(), MessageKey.NOT_ENOUGH_BALANCE);
                        return;
                    }
                    account.take(20.00);
                    e.getWhoClicked().getInventory().addItem(new ItemStack(e.getCurrentItem().getType(), 1));
                    MessageKey.send((Player)e.getWhoClicked(), MessageKey.WITHRAW_MONEY, new BalanceWrapper().convert(20));
                }else if (e.getCurrentItem().getType() == Material.IRON_INGOT){
                    if (!account.has(10.00)){
                        MessageKey.send((Player)e.getWhoClicked(), MessageKey.NOT_ENOUGH_BALANCE);
                        return;
                    }
                    account.take(10.00);
                    e.getWhoClicked().getInventory().addItem(new ItemStack(e.getCurrentItem().getType(), 1));
                    MessageKey.send((Player)e.getWhoClicked(), MessageKey.WITHRAW_MONEY, new BalanceWrapper().convert(10));
                }else if (e.getCurrentItem().getType() == Material.QUARTZ){
                    if (!account.has(5.00)){
                        MessageKey.send((Player)e.getWhoClicked(), MessageKey.NOT_ENOUGH_BALANCE);
                        return;
                    }
                    account.take(5.00);
                    e.getWhoClicked().getInventory().addItem(new ItemStack(e.getCurrentItem().getType(), 1));
                    MessageKey.send((Player)e.getWhoClicked(), MessageKey.WITHRAW_MONEY, new BalanceWrapper().convert(5));
                }else if (e.getCurrentItem().getType() == Material.GOLD_INGOT){
                    if (!account.has(1.00)){
                        MessageKey.send((Player)e.getWhoClicked(), MessageKey.NOT_ENOUGH_BALANCE);
                        return;
                    }
                    account.take(1.00);
                    e.getWhoClicked().getInventory().addItem(new ItemStack(e.getCurrentItem().getType(), 1));
                    MessageKey.send((Player)e.getWhoClicked(), MessageKey.WITHRAW_MONEY, new BalanceWrapper().convert(1));
                }else if (e.getCurrentItem().getType() == Material.GOLD_NUGGET){
                    if (!account.has(0.10)){
                        MessageKey.send((Player)e.getWhoClicked(), MessageKey.NOT_ENOUGH_BALANCE);
                        return;
                    }
                    account.take(0.10);
                    e.getWhoClicked().getInventory().addItem(new ItemStack(e.getCurrentItem().getType(), 1));
                    MessageKey.send((Player)e.getWhoClicked(), MessageKey.WITHRAW_MONEY, new BalanceWrapper().convert(0.10) + "0");
                }else{
                    e.setCancelled(true);
                }

                new BankUseGUI().openBank((Player) e.getWhoClicked(), account.getID());
            }

            if (i >= 0 && i <= 35){
                //TODO: Take the stack

                if (e.getWhoClicked().getInventory().firstEmpty() == -1){
                    MessageKey.send((Player)e.getWhoClicked(), MessageKey.NOT_ENOUGH_INVENTORY_SPACE);
                    e.setCancelled(true);
                    return;
                }
                if (e.getCurrentItem().getType() == Material.GHAST_TEAR){
                    account.take(500.00 * e.getCurrentItem().getAmount());
                    MessageKey.send((Player)e.getWhoClicked(), MessageKey.WITHRAW_MONEY, new BalanceWrapper().convert(500 * e.getCurrentItem().getAmount()));
                }else if (e.getCurrentItem().getType() == Material.DIAMOND){
                    account.take(200.00 * e.getCurrentItem().getAmount());
                    MessageKey.send((Player)e.getWhoClicked(), MessageKey.WITHRAW_MONEY, new BalanceWrapper().convert(200 * e.getCurrentItem().getAmount()));
                }else if (e.getCurrentItem().getType() == Material.REDSTONE){
                    account.take(100.00 * e.getCurrentItem().getAmount());
                    MessageKey.send((Player)e.getWhoClicked(), MessageKey.WITHRAW_MONEY, new BalanceWrapper().convert(100 * e.getCurrentItem().getAmount()));
                }else if (e.getCurrentItem().getType() == Material.EMERALD){
                    account.take(50.00 * e.getCurrentItem().getAmount());
                    MessageKey.send((Player)e.getWhoClicked(), MessageKey.WITHRAW_MONEY, new BalanceWrapper().convert(50 * e.getCurrentItem().getAmount()));
                }else if (e.getCurrentItem().getType() == Material.COAL){
                    account.take(20.00 * e.getCurrentItem().getAmount());
                    MessageKey.send((Player)e.getWhoClicked(), MessageKey.WITHRAW_MONEY, new BalanceWrapper().convert(20 * e.getCurrentItem().getAmount()));
                }else if (e.getCurrentItem().getType() == Material.IRON_INGOT){
                    account.take(10.00 * e.getCurrentItem().getAmount());
                    MessageKey.send((Player)e.getWhoClicked(), MessageKey.WITHRAW_MONEY, new BalanceWrapper().convert(10 * e.getCurrentItem().getAmount()));
                }else if (e.getCurrentItem().getType() == Material.QUARTZ){
                    account.take(5.00 * e.getCurrentItem().getAmount());
                    MessageKey.send((Player)e.getWhoClicked(), MessageKey.WITHRAW_MONEY, new BalanceWrapper().convert(5 * e.getCurrentItem().getAmount()));
                }else if (e.getCurrentItem().getType() == Material.GOLD_INGOT){
                    account.take(1.00 * e.getCurrentItem().getAmount());
                    MessageKey.send((Player)e.getWhoClicked(), MessageKey.WITHRAW_MONEY, new BalanceWrapper().convert(1 * e.getCurrentItem().getAmount()));
                }else if (e.getCurrentItem().getType() == Material.GOLD_NUGGET){
                    account.take(0.10 * e.getCurrentItem().getAmount());
                    MessageKey.send((Player)e.getWhoClicked(), MessageKey.WITHRAW_MONEY, new BalanceWrapper().convert(0.10 * e.getCurrentItem().getAmount()) + "0");
                }else{
                    e.setCancelled(true);
                }

                e.getWhoClicked().getInventory().addItem(new ItemStack(e.getCurrentItem().getType(), e.getCurrentItem().getAmount(), e.getCurrentItem().getDurability()));
                new BankUseGUI().openBank((Player) e.getWhoClicked(), account.getID());
            }

            if (i >= 54 && i <= 89){
                //TODO: Deposit the stack

                boolean valid = false;

                if (e.getCurrentItem().getType() == Material.GHAST_TEAR){ valid = true;
                    account.deposit(500.00 * e.getCurrentItem().getAmount());
                    MessageKey.send((Player)e.getWhoClicked(), MessageKey.DEPOSIT_MONEY, new BalanceWrapper().convert(500 * e.getCurrentItem().getAmount()));
                }else if (e.getCurrentItem().getType() == Material.DIAMOND){valid = true;
                    account.deposit(200.00 * e.getCurrentItem().getAmount());
                    MessageKey.send((Player)e.getWhoClicked(), MessageKey.DEPOSIT_MONEY, new BalanceWrapper().convert(200 * e.getCurrentItem().getAmount()));
                }else if (e.getCurrentItem().getType() == Material.REDSTONE){valid = true;
                    account.deposit(100.00 * e.getCurrentItem().getAmount());
                    MessageKey.send((Player)e.getWhoClicked(), MessageKey.DEPOSIT_MONEY, new BalanceWrapper().convert(100 * e.getCurrentItem().getAmount()));
                }else if (e.getCurrentItem().getType() == Material.EMERALD){valid = true;
                    account.deposit(50.00 * e.getCurrentItem().getAmount());
                    MessageKey.send((Player)e.getWhoClicked(), MessageKey.DEPOSIT_MONEY, new BalanceWrapper().convert(50 * e.getCurrentItem().getAmount()));
                }else if (e.getCurrentItem().getType() == Material.COAL){valid = true;
                    account.deposit(20.00 * e.getCurrentItem().getAmount());
                    MessageKey.send((Player)e.getWhoClicked(), MessageKey.DEPOSIT_MONEY, new BalanceWrapper().convert(20 * e.getCurrentItem().getAmount()));
                }else if (e.getCurrentItem().getType() == Material.IRON_INGOT){valid = true;
                    account.deposit(10.00 * e.getCurrentItem().getAmount());
                    MessageKey.send((Player)e.getWhoClicked(), MessageKey.DEPOSIT_MONEY, new BalanceWrapper().convert(10 * e.getCurrentItem().getAmount()));
                }else if (e.getCurrentItem().getType() == Material.QUARTZ){valid = true;
                    account.deposit(5.00 * e.getCurrentItem().getAmount());
                    MessageKey.send((Player)e.getWhoClicked(), MessageKey.DEPOSIT_MONEY, new BalanceWrapper().convert(5 * e.getCurrentItem().getAmount()));
                }else if (e.getCurrentItem().getType() == Material.GOLD_INGOT){valid = true;
                    account.deposit(1.00 * e.getCurrentItem().getAmount());
                    MessageKey.send((Player)e.getWhoClicked(), MessageKey.DEPOSIT_MONEY, new BalanceWrapper().convert(1 * e.getCurrentItem().getAmount()));
                }else if (e.getCurrentItem().getType() == Material.GOLD_NUGGET){valid = true;
                    account.deposit(0.10 * e.getCurrentItem().getAmount());
                    MessageKey.send((Player)e.getWhoClicked(), MessageKey.DEPOSIT_MONEY, new BalanceWrapper().convert(0.10 * e.getCurrentItem().getAmount()) + "0");
                }else{
                    e.setCancelled(true);
                }

                if (valid){
                    e.getWhoClicked().getInventory().clear(e.getSlot());
                    new BankUseGUI().openBank((Player) e.getWhoClicked(), account.getID());
                }
            }
        }
    }

}
