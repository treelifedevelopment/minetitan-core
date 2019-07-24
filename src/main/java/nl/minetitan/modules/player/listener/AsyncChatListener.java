package nl.minetitan.modules.player.listener;
/*
Door: Maiky
Package: nl.minetitan.modules.player.listener in de class AsyncChatListener.
*/

import nl.minetitan.handler.enums.MessageKey;
import nl.minetitan.modules.player.MinetopiaPlayerData;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class AsyncChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e){
        MinetopiaPlayerData data = new MinetopiaPlayerData(e.getPlayer());

        e.setFormat(ChatColor.translateAlternateColorCodes('&',

                String.format(
                        MessageKey.ASYNC_CHAT_FORMAT.getMessage()
                        , String.valueOf(data.getLevel())
                        , data.getPrefixScope()
                        , data.getNaamkleur(),
                        e.getPlayer().getName(),
                        "&" + data.getChatkleurScope(),
                        e.getMessage()
                )));
    }

}
