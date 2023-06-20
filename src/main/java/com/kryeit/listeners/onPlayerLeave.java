package com.kryeit.listeners;

import net.dv8tion.jda.api.entities.Activity;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.net.http.WebSocket;

import static com.kryeit.LambdaBot.api;

public class onPlayerLeave implements Listener {

    @EventHandler
    public void onJoin(PlayerQuitEvent e) {
        int playerCount = Bukkit.getOnlinePlayers().size();
        api.getPresence().setActivity(Activity.watching("a " + (playerCount - 1) + " jugadores"));
    }
}
