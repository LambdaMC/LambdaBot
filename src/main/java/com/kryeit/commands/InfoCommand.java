package com.kryeit.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.SlashCommandInteraction;

import java.awt.*;
import java.net.URL;

import static com.kryeit.LambdaBot.*;

public class InfoCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equals("informacion")) {
            // Create the EmbedBuilder instance
            EmbedBuilder eb = new EmbedBuilder();

            // Set the properties of your embed
            eb.setColor(Color.ORANGE);
            eb.setThumbnail("https://kryeit.com/images/lambdacraft.png");// replace imageUrlString with your actual URL
            eb.setFooter("LambdaCraft");
            eb.setAuthor("Información");
            eb.addField("1. Normas", "- Leerlas para no sancionarte\n- Las puedes leer en " + normas.getAsMention(), false);
            eb.addField("2. IP del servidor", "- Utiliza el comando /ip\n- No utilizar muchas veces seguidas el comando", false);
            eb.addField("Contacta a los administradores si encuentras algún error", muriplz.getAsMention() + " y " + ender.getAsMention(), false);

            // Send the embed
            event.replyEmbeds(eb.build()).queue();
        }
    }
}
