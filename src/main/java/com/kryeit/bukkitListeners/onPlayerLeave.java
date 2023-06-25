package com.kryeit.bukkitListeners;

import net.dv8tion.jda.api.entities.Activity;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import static com.kryeit.LambdaBot.api;

public class onPlayerLeave implements Listener {

    @EventHandler
    public void onJoin(PlayerQuitEvent e) {
        int playerCount = Bukkit.getOnlinePlayers().size() - 1;
        if(playerCount == 1) {
            api.getPresence().setActivity(Activity.watching("a " + playerCount + " jugador"));
        } else {
            api.getPresence().setActivity(Activity.watching("a " + playerCount + " jugadores"));
        }
    }
}
