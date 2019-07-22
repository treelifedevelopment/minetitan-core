package nl.minetitan.modules.player;
/*
Door: Maiky
Package: nl.minetitan.modules.player in de class MinetopiaPlayer.
*/

import nl.minetitan.Core;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class MinetopiaPlayer {

    private MinetopiaPlayerData data;
    private Player player;

    public MinetopiaPlayer(Player player){
        this.data = new MinetopiaPlayerData(player);
        this.player = player;
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

    public void loadInventory(){
        player.getInventory().clear();

        for(ItemStack item : data.getInventoryInner()){
            if (item != null) {
                player.getInventory().addItem(item);
            }
        }
    }

    public String getLevelUpString(int level, int levelTo){
        if (level > levelTo){
            return "§f" + level + " -> " + levelTo + " §f(§c-" + (level-levelTo) + "§f)";
        }

        if (level < levelTo){
            return "§f" + level + " -> " + levelTo + " §f(§a+" + (levelTo -level) + "§f)";
        }

        if (levelTo == level){
            return "§f" + level + " -> " + levelTo + " §f(§60§f)";
        }

        return "0 -> 0 (0)";
    }


}
