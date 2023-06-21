package com.kryeit.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class IPCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equals("ip")) {
            EmbedBuilder eb = new EmbedBuilder();

            eb.setColor(Color.ORANGE);
            eb.setThumbnail("https://kryeit.com/images/lambdacraft.png");
            eb.setFooter("LambdaCraft");
            eb.setAuthor("Server IP");
            eb.addField("IP: 5.9.144.150:7777", "Nombre: LambdaCraft", false);

            event.replyEmbeds(eb.build()).queue();
        }
    }
}
