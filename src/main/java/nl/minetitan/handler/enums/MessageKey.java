package nl.minetitan.handler.enums;

import lombok.Getter;
import lombok.Setter;
import nl.minetitan.Core;
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
    PLAYER_STARTED_PIN_PAYMENT_LINE1("&3Je hebt een pin betaling gestart! &3Bedrag: &b%s"),
    PLAYER_STARTED_PIN_PAYMENT_LINE2("&3De betaling is verstuurt naar &b%s&3."),
    ACCOUNT_CREATED("&aBank account is aangemaakt ID: %s voor de UUID: (%s)"),
    GUI_TITLE_BANK("&3Totale waarde: &b€%s"),
    PLAYER_RECEIVED_PIN_PAYMENT_LINE1("&3Je hebt een pin betaling ontvangen van &b%s&3."),
    PLAYER_RECEIVED_PIN_PAYMENT_LINE2("&3Klik met &brechter-muis knop &3op een pinconsole om te betaling af te ronden, met de rekening &b%s&3."),
    PLAYER_RECEIVED_PIN_PAYMENT_PART2_LINE1("&3Volg de volgende instructies om de &bbetaling &3af te ronden."),
    PLAYER_RECEIVED_PIN_PAYMENT_PART2_LINE2("&3Typ in de chat '&baccepteren&3' om de betaling te voltooien."),
    PLAYER_RECEIVED_PIN_PAYMENT_PART2_LINE3("&3Typ in de chat '&bannuleren&3' om de betaling te annuleren."),
    NOT_A_VALID_ANSWER("&cDit is geen geldig antwoord."),
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
    PLAYER_CANNOT_PIN_SET_HIMSELF("&cJe kunt jezelf geen pinverzoek sturen."),
    COUNT_UP_MESSAGE("&3- &b%s"),
    PERSONAL_HEADER_MESSAGE("&3---- &b%s &3van &b%s &3----"),
    NUMBER_FORMAT_ERROR("&cJe hebt een ongeldig getal opgegeven!"),
    GUI_TITLE_CHOOSE_CHATKLEUR("&3Kies een &bchatkleur&3."),
    PLAYER_ALREADY_CHOSE_CHATCOLOR("&cJe hebt deze chatkleur al gekozen!"),
    PLAYER_CHOSE_NEW_CHATCOLOR("&3Je hebt de chatkleur &%sKleur &3gekozen!"),
    PLAYER_OPENED_BANK_ADMIN("&3Je hebt de rekening &b%s &3geopend."),
    PLAYER_HAS_AMOUNT_ON_BANK_ACCOUNT("&3Jij hebt &b%s &3op je rekening staan."),
    ADMIN_CREATED_PINPAS("&3Je hebt succesvol een pinpas aangemaakt voor het rekening id &b%s&3."),
    USAGE_PIN("&3Gebruik &b/%s %s %s %s"),
    PLAYER_DOESNT_HAVE_OR_ISNT_MEMBER_BUISNESS_ACCOUNT("&cJij hebt &4geen &cbedrijfsrekening en je bent ook geen lid van een!"),
    PLAYER_PAYMENT_IS_DONE("&3Je hebt de betaling van &b%s &3succesvol afgerond, volg nu de instructies van de verkoper."),
    PLAYER_PAYMENT_IS_DONE_TO_SELLER("&3De betaling van &b%s &3is succesvol afgerond."),
    PLAYER_CANCELLED_PAYMENT("&cJe hebt succesvol de betaling geannuleerd."),
    PLAYER_CANCELLED_PAYMENT_TO_SELLER("&c%s heeft de betaling geweigerd."),
    SENDER_ISNT_A_PLAYER("&cJij bent geen speler dus je kunt dit commando niet uitvoeren!"),
    PLOTINFO_THIS_ISNT_A_PLOT("&cDit is geen plot!"),
    PLOTINFO_INFORMATION_PLAYER_OWNERS("&3Eigenaren: &b%s"),
    PLOTINFO_INFORMATION_PLAYER_MEMBERS("&3Leden: &b%s"),
    PLOTINFO_INFORMATION_STAFF_DIVIDER("&3------------------------------------"),
    PLOTINFO_INFORMATION_STAFF_FLAGS("&3Flags: &b%s"),
    PLOTINFO_INFORMATION_STAFF_PLOTNAME("&3Plot naam: &b%s");


    @Getter @Setter
    String message;

    MessageKey(String message){
        setMessage(message);
    }

    public static void send(Player player, MessageKey key, String... placeholders){
        if (Core.getMessages().getConfig().getString(key.toString()) != null){
            player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                    String.format(Core.getMessages().getConfig().getString(key.toString()), placeholders)));
        }else{
            player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                    "Messages." + key.toString()));
        }
    }

    public static void send(Player player, MessageKey key){
        if (Core.getMessages().getConfig().getString(key.toString()) != null) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                    Core.getMessages().getConfig().getString(key.toString())));
        }else{
            player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                    "Messages." + key.toString()));
        }
    }

    public static String getKey(MessageKey key){
        if (Core.getMessages().getConfig().getString(key.toString()) != null) {
            return ChatColor.translateAlternateColorCodes('&', Core.getMessages().getConfig().getString(key.toString()));
        }else{
            return ChatColor.translateAlternateColorCodes('&', "Messages." + key.toString());
        }
    }

    public static void updateMessagesFile(){
        for (MessageKey key : MessageKey.values()){
            if (!Core.getMessages().getConfig().contains(key.toString())){
                Core.getMessages().getConfig().set(key.toString(), key.getMessage());
                Core.getMessages().saveConfig();
            }
        }
    }

}
