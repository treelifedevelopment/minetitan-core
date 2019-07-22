package nl.minetitan.modules.player.commands;
/*
Door: Maiky
Package: nl.minetitan.modules.player.commands in de class TimeCommand.
*/

import nl.minetitan.handler.enums.MessageKey;
import nl.minetitan.interfaces.MinetopiaCommand;
import nl.minetitan.modules.player.MinetopiaPlayer;
import nl.minetitan.modules.player.MinetopiaPlayerData;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TimeCommand extends MinetopiaCommand {

    public TimeCommand(){
        super("time");
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        if (sender instanceof Player){
            MinetopiaPlayerData player = new MinetopiaPlayerData((Player)sender);
            String days = String.valueOf(player.getDaysOnline());
            String hours = String.valueOf(player.getHoursOnline());
            String minutes = String.valueOf(player.getMinutesOnline());
            String seconds = String.valueOf(player.getSecondsOnline());

            MessageKey.send((Player)sender, MessageKey.TIME_INFO_DISPLAY, days, hours, minutes, seconds);
            return true;
        }
        return false;
    }
}
