package nl.minetitan;

import com.zaxxer.hikari.HikariDataSource;
import lombok.Getter;
import lombok.Setter;
import nl.minetitan.handler.CommandHandler;
import nl.minetitan.handler.config.Configurator;
import nl.minetitan.handler.enums.MessageKey;
import nl.minetitan.interfaces.MinetopiaCommand;
import nl.minetitan.modules.ModuleManager;
import nl.minetitan.modules.player.MinetopiaPlayer;
import nl.minetitan.modules.player.tasks.ScoreboardUpdateTask;
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

    @Getter @Setter
    private static Configurator messages;

    @Override
    public void onLoad() {
        instance = this;
        connect();
    }

    @Override
    public void onEnable() {
        setMessages(new Configurator("messages.yml"));
        getMessages().loadConfig();

        MessageKey.updateMessagesFile();

        getConfig().options().copyDefaults(true);
        saveConfig();

        ModuleManager manager = new ModuleManager(instance);
        manager.start();

        if (Bukkit.getOnlinePlayers().size() > 0) {
            for (Player p : Bukkit.getOnlinePlayers()) {
                ScoreboardUpdateTask.loadScoreboard(p);
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
        hikari.addDataSourceProperty("serverName", "173.249.50.167");
        hikari.addDataSourceProperty("port", "3306");
        hikari.addDataSourceProperty("databaseName", "minetopia-dev");
        hikari.addDataSourceProperty("user", "system");
        hikari.addDataSourceProperty("password", "bMCEwmNcUYQEkwGZmJDDkLUfQAdskzPpZSxmJekXLKWjFZTaRMfqdRgrswCnhwFZSAeupJqR");
    }
}
