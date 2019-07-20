package nl.minetitan.interfaces;
/*
Door: Maiky
Package: nl.minetitan.interfaces in de class MinetopiaCommand.
*/

import lombok.Getter;
import lombok.Setter;
import org.bukkit.command.CommandSender;

public abstract class MinetopiaCommand {

    @Getter @Setter
    private String command;

    @Getter @Setter
    private String permission = null;

    public MinetopiaCommand(String command){
        setCommand(command);
    }

    public MinetopiaCommand(String command, String permission){
        this(command);
        setPermission(permission);
    }

    public abstract boolean execute(CommandSender sender, String[] args);

}
