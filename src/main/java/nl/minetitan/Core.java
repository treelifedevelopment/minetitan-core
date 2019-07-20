package nl.minetitan;

import com.zaxxer.hikari.HikariDataSource;
import lombok.Getter;
import lombok.Setter;
import nl.minetitan.handler.CommandHandler;
import nl.minetitan.interfaces.MinetopiaCommand;
import nl.minetitan.modules.ModuleManager;
import nl.minetitan.modules.player.MinetopiaPlayer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.HashMap;

public final class Core extends JavaPlugin {

    // Instance
    @Getter @Setter
    private static Core instance;

    // HikariCP
    @Getter @Setter
    public HikariDataSource hikari;

    @Getter @Setter
    private Scoreboard teams;

    @Override
    public void onLoad() {
        instance = this;
        connect();

        teams = Bukkit.getScoreboardManager().getNewScoreboard();
        for (ChatColor c : ChatColor.values()){
            Team team = teams.registerNewTeam(c.toString());
            team.setPrefix(c.toString());
        }
    }

    @Override
    public void onEnable() {
        ModuleManager manager = new ModuleManager(instance);
        manager.start();

        if (Bukkit.getOnlinePlayers().size() != 0){
            for (Player player : Bukkit.getOnlinePlayers()){
                MinetopiaPlayer mt = new MinetopiaPlayer(player);

                for (Team team : getTeams().getTeams()){
                    player.sendMessage(team.getName());
                }
            }
        }
    }

    @Override
    public void onDisable(){
        if (hikari != null){
            hikari.close();
        }
    }

    public void connect(){
        hikari = new HikariDataSource();

        //Setting Hikari properties
        hikari.setMaximumPoolSize(10);
        hikari.setDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlDataSource");
        hikari.addDataSourceProperty("serverName", "62.210.119.232");
        hikari.addDataSourceProperty("port", "3306");
        hikari.addDataSourceProperty("databaseName", "minetopia-dev");
        hikari.addDataSourceProperty("user", "system");
        hikari.addDataSourceProperty("password", "bMCEwmNcUYQEkwGZmJDDkLUfQAdskzPpZSxmJekXLKWjFZTaRMfqdRgrswCnhwFZSAeupJqR");
    }

}
