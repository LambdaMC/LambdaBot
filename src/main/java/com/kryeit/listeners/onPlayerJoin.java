package com.kryeit.listeners;

import net.dv8tion.jda.api.entities.Activity;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import static com.kryeit.LambdaBot.api;

public class onPlayerJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        int playerCount = Bukkit.getOnlinePlayers().size();
        api.getPresence().setActivity(Activity.watching("a " + playerCount + " jugadores"));
    }
}
