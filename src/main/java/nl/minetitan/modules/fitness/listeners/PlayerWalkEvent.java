package nl.minetitan.modules.fitness.listeners;
/*
Door: Maiky
Package: nl.minetitan.modules.fitness.listeners in de class PlayerWalkEvent.
*/

import nl.minetitan.modules.fitness.handler.FitnessHandler;
import org.bukkit.ChatColor;
import org.bukkit.Statistic;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.HashMap;
import java.util.UUID;

public class PlayerWalkEvent implements Listener {

    HashMap<UUID,Double> metersWalked = new HashMap<>();

    //TODO

}
