package com.kryeit;

import com.kryeit.commands.IPCommand;
import com.kryeit.commands.InfoCommand;
import com.kryeit.commands.NormasCommand;
import com.kryeit.listeners.onPlayerJoin;
import com.kryeit.listeners.onPlayerLeave;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LambdaBot extends JavaPlugin {
    public static Guild guild;
    public static UserSnowflake muriplz = User.fromId("235400519365951488");
    public static UserSnowflake ender = User.fromId("774275869300228096");
    public static MessageChannel normas;

    public static Role staff;
    public static JDA api;

    @Override
    public void onEnable() {
        String token;

        try {
            token = new String(Files.readAllBytes(Paths.get("secret.txt"))).trim();
            api = JDABuilder.createDefault(token)
                    .setActivity(Activity.watching("a " + Bukkit.getOnlinePlayers().size() + " jugadores"))
                    .build()
                    .awaitReady();

        } catch (InterruptedException|IOException e) {
            throw new RuntimeException(e);
        }

        registerDiscordEvents();
        populateChannelObjects();
        addDiscordCommands();


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
    }

    public void populateChannelObjects() {
        guild = api.getGuildById("1119257557245104202");
        normas = guild.getTextChannelById("1119277621696549086");
        staff = guild.getRoleById("1119279826017202326");
    }

    public void addDiscordCommands() {
        guild.updateCommands().addCommands(
                Commands.slash("normas", "Manda las normas."),
                Commands.slash("ip", "Manda la IP del servidor."),
                Commands.slash("informacion", "Manda la información principal del servidor.")
        ).queue();
    }

}
