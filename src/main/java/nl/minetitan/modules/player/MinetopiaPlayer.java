package nl.minetitan.modules.player;
/*
Door: Maiky
Package: nl.minetitan.modules.player in de class MinetopiaPlayer.
*/

import nl.minetitan.Core;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class MinetopiaPlayer {

    private MinetopiaPlayerData data;

    public MinetopiaPlayer(Player player){
        this.data = new MinetopiaPlayerData(player);
    }

    public int getLevel(){
        return data.getLevel();
    }

    public int getFitness(){
        return data.getFitness();
    }

    public List<String> getChatcolors(){
        return data.getChatcolors();
    }

    public List<String> getLevelcolors(){
        return null;
    }

    public String getNamecolor(){
       return data.getNaamkleur();
    }


}
