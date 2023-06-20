package com.kryeit.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class IPCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equals("ip")) {
            // Create the EmbedBuilder instance
            EmbedBuilder eb = new EmbedBuilder();

            // Set the properties of your embed
            eb.setColor(Color.ORANGE);
            eb.setThumbnail("https://kryeit.com/images/lambdacraft.png");// replace imageUrlString with your actual URL
            eb.setFooter("LambdaCraft");
            eb.setAuthor("Server IP");
            eb.addField("IP: 5.9.144.150:7777", "Nombre: LambdaCraft", false);

            // Send the embed
            event.replyEmbeds(eb.build()).queue();
        }
    }
}
