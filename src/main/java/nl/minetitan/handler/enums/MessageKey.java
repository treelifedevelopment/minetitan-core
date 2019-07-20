package nl.minetitan.handler.enums;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public enum MessageKey {

    MOD_OPENED_INVSEE_OPENED("&3Je hebt de inventory van &b%s &3geopend."),
    INVSEE_CANT_EDIT_ITEMS("&cJe kunt geen items uit iemand zijn inventory halen.");


    @Getter @Setter
    String message;

    MessageKey(String message){
        setMessage(message);
    }

    public static void send(Player player, MessageKey key, String... placeholders){
        player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                String.format(key.getMessage(), placeholders)));
    }

    public static void send(Player player, MessageKey key){
        player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                key.getMessage()));
    }

}
