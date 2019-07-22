package nl.minetitan.modules.player.tasks;
/*
Door: Maiky
Package: nl.minetitan.modules.player.tasks in de class ActionbarDataTask.
*/

import nl.minetitan.Core;
import nl.minetitan.util.NMSUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ActionbarDataTask implements Runnable {

    @Override
    public void run() {
        NMSUtil util = new NMSUtil();
        String color = Core.getInstance().getConfig().getString("stad-kleur");

        for (Player p : Bukkit.getOnlinePlayers()){
            util.send(p,
                    "§" + color + "Datum: §f" +
                    new SimpleDateFormat("dd/MM/yyyy").format(new Date()) +
                    "    " +
                    "§" + color + "Tijd: §f" + new SimpleDateFormat("HH:mm").format(new Date()));
        }
    }
}
