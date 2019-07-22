package nl.minetitan.util;
/*
Door: Maiky
Package: nl.minetitan.util in de class NMSUtil.
*/

import net.minecraft.server.v1_12_R1.IChatBaseComponent;
import net.minecraft.server.v1_12_R1.PacketPlayOutTitle;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class NMSUtil {

    public void send(Player p, String actionbar){
        IChatBaseComponent text = IChatBaseComponent.ChatSerializer.a("{\"text\":\"" + ChatColor.translateAlternateColorCodes('&', actionbar) + "\"}");

        PacketPlayOutTitle title = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.ACTIONBAR, text);

        ((CraftPlayer)p).getHandle().playerConnection.sendPacket(title);
    }

    public void send(Player p, String title, String subtitle, int fadein, int stay, int fadeout){
        p.sendTitle(title, subtitle, fadein, stay, fadeout);
    }

    public void send(Player p, String title, String subtitle){
        p.sendTitle(title, subtitle);
    }

}
