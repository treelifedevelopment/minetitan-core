package nl.minetitan.modules.player;
/*
Door: Maiky
Package: nl.minetitan.modules.player in de class PlayerModule.
*/

import lombok.Getter;
import lombok.Setter;
import nl.minetitan.Core;
import nl.minetitan.handler.CommandHandler;
import nl.minetitan.modules.MinetopiaModule;
import nl.minetitan.modules.player.commands.ChatkleurCommand;
import nl.minetitan.modules.player.commands.ModCommand;
import nl.minetitan.modules.player.commands.PrefixCommand;
import nl.minetitan.modules.player.commands.TimeCommand;
import nl.minetitan.modules.player.listener.*;
import nl.minetitan.modules.player.tasks.PlayerUpdater;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class PlayerModule implements MinetopiaModule {

    @Getter @Setter
    private Core core;

    @Getter @Setter
    public Scoreboard s;

    public PlayerModule(Core core){
        setCore(core);
    }


    @Override
    public void start() {
        CommandHandler handler = new CommandHandler();
        handler.register("mod", new ModCommand());
        handler.register("time", new TimeCommand());
        handler.register("prefix", new PrefixCommand());
        handler.register("chatkleur", new ChatkleurCommand());

        Bukkit.getPluginManager().registerEvents(new InvseeListener(), getCore());
        Bukkit.getPluginManager().registerEvents(new PreLoginListener(), getCore());
        Bukkit.getPluginManager().registerEvents(new PlayerLogoutListener(), getCore());
        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), getCore());
        Bukkit.getPluginManager().registerEvents(new InteractWithSDB(), getCore());
        Bukkit.getPluginManager().registerEvents(new AsyncChatListener(), getCore());
        Bukkit.getPluginManager().registerEvents(new PrefixGUIClick(), getCore());
        Bukkit.getPluginManager().registerEvents(new ChatkleurGUI_Listener(), getCore());
        Bukkit.getPluginManager().registerEvents(new BlockBecauseLoading(), getCore());

        PlayerUpdater updater = new PlayerUpdater();
        System.out.println("Loading updater");
        updater.start();

    }

    @Override
    public void stop() {

    }

}
