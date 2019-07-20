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
import nl.minetitan.modules.player.commands.ModCommand;
import nl.minetitan.modules.player.listener.InvseeListener;
import nl.minetitan.modules.player.listener.PlayerJoinListener;
import nl.minetitan.modules.player.listener.PlayerLogoutListener;
import nl.minetitan.modules.player.listener.PreLoginListener;
import org.bukkit.Bukkit;

public class PlayerModule implements MinetopiaModule {

    @Getter @Setter
    private Core core;

    public PlayerModule(Core core){
        setCore(core);
    }


    @Override
    public void start() {
        CommandHandler handler = new CommandHandler();
        handler.register("mod", new ModCommand());

        Bukkit.getPluginManager().registerEvents(new InvseeListener(), getCore());
        Bukkit.getPluginManager().registerEvents(new PreLoginListener(), getCore());
        Bukkit.getPluginManager().registerEvents(new PlayerLogoutListener(), getCore());
        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), getCore());
    }

    @Override
    public void stop() {

    }
}
