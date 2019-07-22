package nl.minetitan.modules.player.tasks;
/*
Door: Maiky
Package: nl.minetitan.modules.player.tasks in de class ScoreboardUpdateTask.
*/

import com.bringholm.nametagchanger.NameTagChanger;
import nl.minetitan.Core;
import nl.minetitan.modules.player.MinetopiaPlayer;
import nl.minetitan.util.FastMath;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.text.DecimalFormat;

public class ScoreboardUpdateTask implements Runnable {

    @Override
    public void run() {
        for (Player p : Bukkit.getOnlinePlayers()){
            loadScoreboard(p);
        }
    }

    public static void loadScoreboard(Player p){
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();

        MinetopiaPlayer mtPlayer = new MinetopiaPlayer(p);

        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "ne player " + p.getName() + " prefix &" + mtPlayer.getNamecolor());

        Objective objective = scoreboard.registerNewObjective("minecraft", "dummy");

        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName("§f§l" + Core.getInstance().getConfig().getString("stad-naam"));

        String color = "&" + Core.getInstance().getConfig().getString("stad-kleur");
        double temperature = 0.0;
                //FastMath.calculateTemperature(Core.getInstance().getConfig().getDouble("gem-temp"));

        objective.getScore(format(color + "Temperatuur:")).setScore(13);
        objective.getScore(format("&f" + new DecimalFormat("0.00").format(temperature) + "°C")).setScore(12);
        objective.getScore(format(" ")).setScore(11);
        objective.getScore(format(color + "Level:")).setScore(10);
        objective.getScore(format(mtPlayer.getLevelUpString(mtPlayer.getLevel(), 1))).setScore(9);
        objective.getScore(format("  ")).setScore(8);
        objective.getScore(format(color + "Fitheid:")).setScore(7);
        objective.getScore(format("&f" + mtPlayer.getFitness() + "/225")).setScore(6);
        objective.getScore(format("   ")).setScore(5);
        objective.getScore(format(color + "Lucky Shards:")).setScore(4);
        objective.getScore(format("&f0.000")).setScore(3);
        objective.getScore(format("    ")).setScore(2);
        objective.getScore(format(color + "play.minetitan.nl")).setScore(1);

        p.setScoreboard(scoreboard);
    }

    public static String format(String string){
        return ChatColor.translateAlternateColorCodes('&', string);
    }
}
