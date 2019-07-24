package nl.minetitan.handler;
/*
Door: Maiky
Package: nl.minetitan.handler in de class SimpleNameTag.
*/

import org.bukkit.ChatColor;

public class SimpleNameTag implements Nametag {

    private String text;

    SimpleNameTag(String text) {
        this.text = ChatColor.translateAlternateColorCodes('&', text);
    }

    public String getText() {
        return this.text;
    }
}