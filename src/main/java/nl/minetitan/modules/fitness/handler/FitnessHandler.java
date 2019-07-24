package nl.minetitan.modules.fitness.handler;
/*
Door: Maiky
Package: nl.minetitan.modules.fitness.handler in de class FitnessHandler.
*/

import nl.minetitan.modules.player.MinetopiaPlayerData;
import nl.minetitan.modules.player.tasks.ScoreboardUpdateTask;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;

import java.util.UUID;

public class FitnessHandler {

    public boolean calculate(UUID uuid){
        return true;
    }

    public void grantPoint(Player p, int amount){
        MinetopiaPlayerData data = new MinetopiaPlayerData(p);

        data.setFitheidPunten(data.getFitheidPunten() + amount);
    }

    public boolean checkFitness(Player p, boolean grantOption){
        MinetopiaPlayerData data = new MinetopiaPlayerData(p);

        if (data.getFitheidPunten() >= 4000){
            if (data.getFitheidPunten() > 4000){
                int left = data.getFitheidPunten()-4000;

                if (grantOption){
                    data.setFitness(data.getFitness() + 1 * (data.getFitheidPunten()-left) / 2000);

                    ScoreboardUpdateTask.loadScoreboard(p);
                }
                return true;
            }else{
                data.setFitheidPunten(0);
                if (grantOption){
                    data.setFitness(data.getFitness() + 2);

                    ScoreboardUpdateTask.loadScoreboard(p);
                }
                return true;
            }
        }

        if (data.getFitheidPunten() >= 2000){
            if (data.getFitheidPunten() > 2000){
                int left = data.getFitheidPunten()-2000;

                data.setFitheidPunten(left);

                if (grantOption){
                    data.setFitness(data.getFitness() + 1);

                    ScoreboardUpdateTask.loadScoreboard(p);
                }
                return true;
            }else{
                data.setFitheidPunten(0);
                if (grantOption){
                    data.setFitness(data.getFitness() + 1);

                    ScoreboardUpdateTask.loadScoreboard(p);
                }
                return true;
            }
        }
        return false;
    }

    public void saveData(){
        //TODO
    }

    public double getMeterWalked(Player p){
        double d =
        p.getStatistic(Statistic.WALK_ONE_CM) +
                p.getPlayer().getStatistic(Statistic.SPRINT_ONE_CM) / 100;
        return d / 10;
    }

}
