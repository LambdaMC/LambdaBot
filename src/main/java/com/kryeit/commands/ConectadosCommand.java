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
            // Create the EmbedBuilder instance
            EmbedBuilder eb = new EmbedBuilder();

            // Set the properties of your embed
            eb.setColor(Color.ORANGE);
            eb.setThumbnail("https://kryeit.com/images/lambdacraft.png");// replace imageUrlString with your actual URL
            eb.setFooter("LambdaCraft");
            eb.setTitle("LambdaCraft");
            String players = "";
            for(Player player : Bukkit.getOnlinePlayers()) {
                players = players.concat("- " + player.getName() + "\n");
            }
            eb.addField("Hay " + Bukkit.getOnlinePlayers().size() + " jugadores conectados:", players, false);
            // Send the embed
            event.replyEmbeds(eb.build()).queue();
        }
    }
}
