package nl.minetitan.handler;
/*
Door: Maiky
Package: nl.minetitan.handler in de class NmsUtil.
*/

import com.comphenix.protocol.wrappers.EnumWrappers;
import com.comphenix.protocol.wrappers.PlayerInfoData;
import com.comphenix.protocol.wrappers.WrappedChatComponent;
import com.comphenix.protocol.wrappers.WrappedGameProfile;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;

public class NmsUtil {

    public static PlayerInfoData getPlayerInfoData(Player player) {
        return new PlayerInfoData(WrappedGameProfile.fromPlayer(player), NmsUtil.getPing(player), EnumWrappers.NativeGameMode.fromBukkit(player.getGameMode()), WrappedChatComponent.fromText(player.getDisplayName()));
    }

    public static List<PlayerInfoData> getPlayerInfoDataList(Player player) {
        return Collections.singletonList(getPlayerInfoData(player));
    }

    public static int getPing(Player player){
        int ping = ((CraftPlayer) player).getHandle().ping;
        return ping;
    }

}
