package nl.minetitan.modules.player.tasks;
/*
Door: Maiky
Package: nl.minetitan.modules.player.tasks in de class TimeInfoTask.
*/

import nl.minetitan.handler.enums.MessageKey;
import nl.minetitan.modules.player.MinetopiaPlayerData;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class TimeInfoTask implements Runnable {

    @Override
    public void run() {
        for (Player p : Bukkit.getOnlinePlayers()){
            MinetopiaPlayerData data = new MinetopiaPlayerData(p.getUniqueId());

            int days = data.getDaysOnline();
            int hours = data.getHoursOnline();
            int minutes = data.getMinutesOnline();
            int seconds = data.getSecondsOnline();

            data.setSecondsOnline(seconds + 1);

            if (seconds >= 60){
                data.setSecondsOnline(0);
                data.setMinutesOnline(minutes + 1);

                if (data.getMinutesOnline() == 10 ||
                        data.getMinutesOnline() == 20 ||
                        data.getMinutesOnline() == 30 ||
                        data.getMinutesOnline() == 40 ||
                        data.getMinutesOnline() == 50 ||
                        data.getMinutesOnline() == 60) {
                    data.setLuckyshards(data.getLuckyshards() + 0.0007);
                    MessageKey.send(p, MessageKey.PLAYER_RECEIVED_LUCKYSHARDS, "0.0007");
                }
            }

            if (minutes >= 60){
                data.setMinutesOnline(0);
                data.setHoursOnline(hours + 1);
            }

            if (hours >= 24){
                data.setHoursOnline(0);
                data.setDaysOnline(1);
            }
        }
    }
}
