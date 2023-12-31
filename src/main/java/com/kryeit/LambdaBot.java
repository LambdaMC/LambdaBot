package com.kryeit;

import com.kryeit.bukkitListeners.onPlayerJoin;
import com.kryeit.bukkitListeners.onPlayerLeave;
import com.kryeit.commands.*;
import com.kryeit.discordListeners.LogEvents;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.interactions.commands.Command;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class LambdaBot extends JavaPlugin {
    public static Guild guild;
    public static UserSnowflake muriplz = User.fromId("235400519365951488");
    public static UserSnowflake ender = User.fromId("774275869300228096");
    public static MessageChannel normas;

    public static MessageChannel logStaffChannel;


    public static List<String> allPlayers;

    public static Role staff;
    public static JDA api;

    @Override
    public void onEnable() {
        String token;

        try {
            InputStream in = this.getClass().getResourceAsStream("/secret.txt");
            if (in == null) {
                throw new FileNotFoundException("Resource not found: secret.txt");
            }
            token = new String(in.readAllBytes()).trim();
            in.close();
            api = JDABuilder.createDefault(token)
                    .setActivity(Activity.watching("a 0 jugadores"))
                    .build()
                    .awaitReady();

        } catch (InterruptedException|IOException e) {
            throw new RuntimeException(e);
        }

        populateObjects();

        registerDiscordEvents();
        registerMinecraftEvents();
        addDiscordCommands();
    }

    @Override
    public void onDisable() {
        api.shutdown();
        api = null;
    }

    public void registerMinecraftEvents() {
        registerMinecraftEvent(new onPlayerJoin());
        registerMinecraftEvent(new onPlayerLeave());
    }

    public void registerMinecraftEvent (Listener listener) {
        getServer().getPluginManager().registerEvents(listener,this);
    }

    public void registerDiscordEvents() {
        api.addEventListener(new NormasCommand());
        api.addEventListener(new IPCommand());
        api.addEventListener(new InfoCommand());
        api.addEventListener(new JugadorCommand());
        api.addEventListener(new ConectadosCommand());
        api.addEventListener(new LogEvents());
    }

    public void populateObjects() {
        guild = api.getGuildById("1119257557245104202");
        normas = guild.getTextChannelById("1119277621696549086");
        staff = guild.getRoleById("1119279826017202326");
        logStaffChannel = guild.getTextChannelById("1120759327712624782");
        allPlayers = new ArrayList<>();
        for (OfflinePlayer player : Bukkit.getOfflinePlayers()) {
            allPlayers.add(player.getName());
        }
    }

    public void addDiscordCommands() {
        List<Command.Choice> playerChoices = new ArrayList<>();
        for (String player : allPlayers) {
            playerChoices.add(new Command.Choice(player, player));
        }
        guild.upsertCommand("jugador", "Manda información sobre un jugador")
                .addOption(OptionType.STRING, "nombre", "El nombre del jugador", true, true)
                .queue();
        guild.upsertCommand("normas", "Manda las normas.")
                .queue();
        guild.upsertCommand("ip", "Manda la IP del servidor.")
                .queue();
        guild.upsertCommand("informacion", "Manda la información principal del servidor.")
                .queue();
        guild.upsertCommand("conectados", "Manda una lista con los jugadores conectados")
                .queue();
    }

}

