package nl.minetitan.handler.enums;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public enum MessageKey {

    MOD_OPENED_INVSEE_OPENED("&3Je hebt de inventory van &b%s &3geopend."),
    INVSEE_CANT_EDIT_ITEMS("&cJe kunt geen items uit iemand zijn inventory halen."),
    CHOOSE_AN_ACCOUNT_SDB("&3Kies je rekening."),
    PLAYER_OPENED_SDB("&3Je hebt een pin automaat geopend!"),
    FORGOT_ARGUMENT("&cJe moet wel een argument opgeven!"),
    USE_FOLLOWING_COMMAND_BANKING("&cGebruik: /%s %s %s %s %s"),
    USE_FOLLOWING_COMMAND_BANKING_2("&cGebruik: /%s %s %s"),
    INVALID_NUMBER("&c'%s' is een ongeldig getal!"),
    WRONG_SUB_COMMAND("&cJe hebt een ongeldig sub-commando gebruikt!"),
    INVALID_ACCOUNT_TYPE("&cDit account type bestaat niet!"),
    INVALID_BANK_ID("&cDit is een ongeldig rekening id."),
    PLAYER_DOESNT_EXISTS("&cDeze speler bestaat niet!"),
    ACCOUNT_CREATED("&aBank account is aangemaakt ID: %s voor de UUID: (%s)"),
    GUI_TITLE_BANK("&3Totale waarde: &b€%s"),
    WITHRAW_MONEY("&3Je hebt &b€%s &3opgenomen van de bank."),
    DEPOSIT_MONEY("&3Je hebt &b€%s &3gestort op de bank."),
    NOT_ENOUGH_INVENTORY_SPACE("&cJe heb &4geen &cgenoeg inventory ruimte."),
    NOT_ENOUGH_BALANCE("&cJij hebt &4niet &cgenoeg geld!"),
    TIME_INFO_DISPLAY("&3Je bent &b%s &3dagen, &b%s &3uren, &b%s &3minuten en &b%s &3seconden online geweest."),
    ASYNC_CHAT_FORMAT("&3[&bLevel %s&3] &8[&7%s&8] &%s%s:%s %s"),
    GUI_SELECT_PREFIX_TITLE("&3Selecteer een &bprefix&3."),
    PLAYER_ALREADY_HAS_CHATCOLOR("&cDeze speler heeft deze chatkleur al!"),
    ALREADY_CHOSE_PREFIX("&cJe hebt &4deze &cprefix al gekozen!"),
    PLAYER_ALREADY_HAS_PREFIX_PROVIDED("&cDeze speler heeft deze prefix al!"),
    PLAYER_ADDED_PREFIX_OF_PLAYER("&3Je hebt succesvol de prefix &b%s &3toegevoegd aan het account van &b%s&3."),
    PLAYER_CHANGED_LEVEL_OF_PLAYER("&3Je hebt succesvol het level van &b%s &3veranderd naar &b%s&3."),
    PLAYER_CHANGED_NAMECOLOR_OF_PLAYER("&3Je hebt succesvol de naamkleur van &b%s &3veranderd naar &b%s&3."),
    PLAYER_ADDED_CHATCOLOR_TO_PLAYER("&3Je hebt aan &b%s &3zijn account de chatkleur &b%s&3toegevoegd."),
    PLAYER_CHOSE_PREFIX("&3Je hebt de prefix &b%s &3gekozen!"),
    PLAYER_RECEIVED_LUCKYSHARDS("&3Je hebt automatisch &b%s &3LuckyShards ontvangen."),
    PLAYER_EAT_ITEM("&3Je hebt een &b%s &3opgegeten."),
    COLOR_DOESNT_EXISTS("&cDeze kleur bestaat niet."),
    COUNT_UP_MESSAGE("&3- &b%s"),
    PERSONAL_HEADER_MESSAGE("&3---- &b%s &3van &b%s &3----"),
    NUMBER_FORMAT_ERROR("&cJe hebt een ongeldig getal opgegeven!"),
    GUI_TITLE_CHOOSE_CHATKLEUR("&3Kies een &bchatkleur&3."),
    PLAYER_ALREADY_CHOSE_CHATCOLOR("&cJe hebt deze chatkleur al gekozen!"),
    PLAYER_CHOSE_NEW_CHATCOLOR("&3Je hebt de chatkleur &%sKleur &3gekozen!");


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

    public static String getKey(MessageKey key){
        return ChatColor.translateAlternateColorCodes('&', key.getMessage());
    }

}
