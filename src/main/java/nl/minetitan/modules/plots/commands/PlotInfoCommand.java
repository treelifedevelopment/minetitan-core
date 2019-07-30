package nl.minetitan.modules.plots.commands;

import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.flags.Flag;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import nl.minetitan.handler.enums.MessageKey;
import nl.minetitan.interfaces.MinetopiaCommand;
import nl.minetitan.modules.plots.handler.WorldGuardHandler;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Set;
import java.util.UUID;

public class PlotInfoCommand extends MinetopiaCommand {

    WorldGuardHandler wgHandler = new WorldGuardHandler();

    public PlotInfoCommand(){
        super("plotinfo", "minetopia.player");
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        if (!(sender instanceof Player)) sender.sendMessage(MessageKey.getKey(MessageKey.SENDER_ISNT_A_PLAYER));

        Player p = (Player)sender;

        RegionManager manager = wgHandler.getWorldGuard().getRegionManager(p.getWorld());
        ApplicableRegionSet set = manager.getApplicableRegions(p.getLocation());

        if (set == null){
            MessageKey.send(p, MessageKey.PLOTINFO_THIS_ISNT_A_PLOT);
            return true;
        }

        ProtectedRegion plotRegion = null;

        for (ProtectedRegion region : set.getRegions()){
            plotRegion = region;
            break;
        }

        if (plotRegion == null){
            MessageKey.send(p, MessageKey.PLOTINFO_THIS_ISNT_A_PLOT);
            return true;
        }

        Set<UUID> owners = plotRegion.getOwners().getUniqueIds();
        Set<UUID> members = plotRegion.getMembers().getUniqueIds();

        StringBuilder flags = new StringBuilder();

        if (!plotRegion.getFlags().isEmpty()) {
            for (Flag flag : plotRegion.getFlags().keySet()) {
                flags.append(flag.getName() + " (" + plotRegion.getFlags().get(flag) + ")");
                flags.append(", ");
            }
        }else{
            flags.append("Geen");
        }

        if (owners.isEmpty() && members.isEmpty()){
            String flagsToString = flags.toString().substring(0, flags.length()-2);

            if (!flagsToString.equalsIgnoreCase("Geen")){
                flagsToString = flags.toString().substring(0, flags.length()-2);
            }

            MessageKey.send(p, MessageKey.PLOTINFO_INFORMATION_STAFF_DIVIDER);
            MessageKey.send(p, MessageKey.PLOTINFO_INFORMATION_STAFF_PLOTNAME, plotRegion.getId());
            MessageKey.send(p, MessageKey.PLOTINFO_INFORMATION_PLAYER_OWNERS, "Geen eigenaar");
            MessageKey.send(p, MessageKey.PLOTINFO_INFORMATION_PLAYER_MEMBERS, "Geen leden");
            MessageKey.send(p, MessageKey.PLOTINFO_INFORMATION_STAFF_FLAGS, flagsToString);
            MessageKey.send(p, MessageKey.PLOTINFO_INFORMATION_STAFF_DIVIDER);
            return true;
        }

        StringBuilder eigenaren = new StringBuilder();
        StringBuilder leden = new StringBuilder();

        for (UUID uuid : owners){
            if (uuid != null){
                OfflinePlayer player = Bukkit.getOfflinePlayer(uuid);
                eigenaren.append(player.getName());
                eigenaren.append(", ");
            }
        }

        for (UUID uuid : members){
            if (uuid != null){
                OfflinePlayer player = Bukkit.getOfflinePlayer(uuid);
                leden.append(player.getName());
                leden.append(", ");
            }
        }

        if (p.hasPermission("minetopia.moderation")){
            MessageKey.send(p, MessageKey.PLOTINFO_INFORMATION_STAFF_DIVIDER);
            MessageKey.send(p, MessageKey.PLOTINFO_INFORMATION_STAFF_PLOTNAME, plotRegion.getId());

            if (owners.isEmpty()){
                MessageKey.send(p, MessageKey.PLOTINFO_INFORMATION_PLAYER_OWNERS, "Geen");
            }else{
                MessageKey.send(p, MessageKey.PLOTINFO_INFORMATION_PLAYER_OWNERS, eigenaren.toString().substring(0, eigenaren.toString().length()-2));
            }

            if (members.isEmpty()){
                MessageKey.send(p, MessageKey.PLOTINFO_INFORMATION_PLAYER_MEMBERS, "Geen");
            }else{
                MessageKey.send(p, MessageKey.PLOTINFO_INFORMATION_PLAYER_MEMBERS, leden.toString().substring(0, leden.length()-2));
            }

            if (plotRegion.getFlags().isEmpty()){
                MessageKey.send(p, MessageKey.PLOTINFO_INFORMATION_STAFF_FLAGS, "Geen flags");
            }else{
                MessageKey.send(p, MessageKey.PLOTINFO_INFORMATION_STAFF_FLAGS, flags.toString().substring(0, flags.toString().length() - 2));
            }

            MessageKey.send(p, MessageKey.PLOTINFO_INFORMATION_STAFF_DIVIDER);
            return true;
        }else{
            MessageKey.send(p, MessageKey.PLOTINFO_INFORMATION_PLAYER_OWNERS, eigenaren.toString().substring(0, eigenaren.length()-2));
            MessageKey.send(p, MessageKey.PLOTINFO_INFORMATION_PLAYER_MEMBERS, leden.toString().substring(0, leden.length()-2));
        }
        return false;
    }
}
