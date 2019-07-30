package nl.minetitan.modules.banking.listeners;

import lombok.Getter;
import nl.minetitan.handler.BalanceWrapper;
import nl.minetitan.handler.enums.MessageKey;
import nl.minetitan.modules.banking.player.BankingAccount;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PinListener implements Listener {

    @Getter
    private static HashMap<Player, HashMap<BankingAccount,Double>> awaitingPayments = new HashMap<>();
    @Getter
    private static HashMap<Player,Player> awaitingPaymentsExtension = new HashMap<>();
    @Getter
    private static HashMap<Player,BankingAccount> playerBankAccount = new HashMap<>();

    // Pin Payments
    // Hash < String ("PLAYER_THAT_HAS_TO_PAY"), HashMap<AccountTo("WHICH_BUISNESS_ACCOUNT)",Double("AMOUNT") >>

    @EventHandler
    public void onInteract(PlayerInteractEvent e){
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.LEFT_CLICK_BLOCK){
            if (e.getPlayer().getItemInHand().getType() == Material.INK_SACK
                    && e.getPlayer().getItemInHand().getDurability() == (short)10){
                // Player is holding 'pinpas' and is clicking 'pinconsole'
                // TODO
                if (awaitingPayments.containsKey(e.getPlayer())){
                    // Player has awaiting payment
                    List<BankingAccount> accounts = new ArrayList<>();

                    for (BankingAccount ba : awaitingPayments.get(e.getPlayer()).keySet()){
                        accounts.add(ba);
                    }

                    BankingAccount account = accounts.get(0);

                    double amountToPay = awaitingPayments.get(e.getPlayer()).get(account);

                    String account1 = e.getPlayer().getItemInHand().getItemMeta().getLore().get(0).replace("Rekening ID: ", "");
                    BankingAccount account2 = new BankingAccount(Integer.parseInt(account1));

                    playerBankAccount.put(e.getPlayer(), account2);

                    Player p = e.getPlayer();
                    MessageKey.send(p, MessageKey.PLAYER_RECEIVED_PIN_PAYMENT_PART2_LINE1, String.valueOf(account.getID()));
                    MessageKey.send(p, MessageKey.PLAYER_RECEIVED_PIN_PAYMENT_PART2_LINE2);
                    MessageKey.send(p, MessageKey.PLAYER_RECEIVED_PIN_PAYMENT_PART2_LINE3);
                    return;
                }
            }
        }
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e){
        if (awaitingPayments.containsKey(e.getPlayer())){
            // Player has awaiting payment
            List<BankingAccount> accounts = new ArrayList<>();

            for (BankingAccount ba : awaitingPayments.get(e.getPlayer()).keySet()){
                accounts.add(ba);
            }

            BankingAccount speler = new BankingAccount(playerBankAccount.get(e.getPlayer()).getID());
            BankingAccount bedrijf = accounts.get(0);

            double amountToPay = awaitingPayments.get(e.getPlayer()).get(bedrijf);

            Player p = e.getPlayer();
            if (e.getMessage().equalsIgnoreCase("accepteer") || e.getMessage().equalsIgnoreCase("accepteren")){
                e.setCancelled(true);

                if (!speler.has(amountToPay)){
                    MessageKey.send(p, MessageKey.NOT_ENOUGH_BALANCE);

                    MessageKey.send(p, MessageKey.PLAYER_CANCELLED_PAYMENT);
                    MessageKey.send(awaitingPaymentsExtension.get(p), MessageKey.PLAYER_CANCELLED_PAYMENT_TO_SELLER, p.getName());

                    awaitingPaymentsExtension.remove(p);
                    awaitingPayments.remove(p);
                    return;
                }else{
                    BankingAccount playerBank = playerBankAccount.get(e.getPlayer());
                    // account = buisness account
                    playerBank.take(amountToPay);
                    bedrijf.deposit(amountToPay);

                    MessageKey.send(p, MessageKey.PLAYER_PAYMENT_IS_DONE, "€" + new BalanceWrapper().convert(amountToPay));
                    MessageKey.send(awaitingPaymentsExtension.get(p), MessageKey.PLAYER_PAYMENT_IS_DONE_TO_SELLER, p.getName());

                    awaitingPaymentsExtension.remove(p);
                    awaitingPayments.remove(p);
                    return;
                }
            }else if (e.getMessage().equalsIgnoreCase("annuleer")){
                e.setCancelled(true);
                MessageKey.send(p, MessageKey.PLAYER_CANCELLED_PAYMENT);
                MessageKey.send(awaitingPaymentsExtension.get(p), MessageKey.PLAYER_CANCELLED_PAYMENT_TO_SELLER, p.getName());

                awaitingPaymentsExtension.remove(p);
                awaitingPayments.remove(p);
                return;
            }else {
                e.setCancelled(true);
                MessageKey.send(p, MessageKey.NOT_A_VALID_ANSWER);
                return;
            }
        }
    }

}
