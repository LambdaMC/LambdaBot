package com.kryeit.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.awt.*;

public class ConectadosCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equals("conectados")) {
            EmbedBuilder eb = new EmbedBuilder();

            eb.setColor(Color.ORANGE);
            eb.setThumbnail("https://kryeit.com/images/lambdacraft.png");
            eb.setFooter("λCraft");
            eb.setTitle("λCraft");
            String players = "";
            String name;
            for(Player player : Bukkit.getOnlinePlayers()) {
                name = player.getName().replace("_","\\_");
                players = players.concat("- " + name + "\n");
            }
            eb.addField("Hay " + Bukkit.getOnlinePlayers().size() + " jugadores conectados:", players, false);
            event.replyEmbeds(eb.build()).queue();
        }
    }
}
