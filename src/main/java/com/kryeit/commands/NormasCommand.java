package com.kryeit.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.SlashCommandInteraction;

import java.awt.*;
import java.net.URL;

import static com.kryeit.LambdaBot.ender;
import static com.kryeit.LambdaBot.muriplz;

public class NormasCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equals("normas")) {
            // Create the EmbedBuilder instance
            EmbedBuilder eb = new EmbedBuilder();
            
            // Set the properties of your embed
            eb.setColor(Color.ORANGE);
            eb.setThumbnail("https://kryeit.com/images/lambdacraft.png");// replace imageUrlString with your actual URL
            eb.setFooter("LambdaCraft");
            eb.setAuthor("Normas de LambdaCraft");
            eb.addField("1. \uD83E\uDD16 Respeta el servidor", "- No construyas máquinas de lag\n- Utiliza los canales de Discord según su función", false);
            eb.addField("2. \u26CF Respeta los jugadores", "- No hagas protecciones cerca de otros jugadores, a no ser que sea cerca de postes\n- Trata a los demás como te gustaría que te tratasen", false);
            eb.addField("3. \uD83C\uDFE0 Respeta zonas comunes", "- No destruyas zonas comunes\n- Respeta las granjas públicas", false);
            eb.addField("Contacta a los administradores si encuentras algún error", muriplz + " y " + ender, false);

            // Send the embed
            event.replyEmbeds(eb.build()).queue();
        }
    }
}
