package com.kryeit.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

import static com.kryeit.LambdaBot.ender;
import static com.kryeit.LambdaBot.muriplz;

public class NormasCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equals("normas")) {
            EmbedBuilder eb = new EmbedBuilder();
            
            eb.setColor(Color.GREEN);
            eb.setThumbnail("https://kryeit.com/images/lambdacraft.png");
            eb.setImage("https://images-ext-2.discordapp.net/external/0lOfZf6LqZepiqgAWCHM8JkV9Ef7csRXOXauMeRHaaQ/https/kryeit.com/images/lambda_title.png?width=1440&height=219");
            eb.setFooter("λCraft");
            eb.setAuthor("Normas de LambdaCraft");
            eb.addField("1. \uD83E\uDD16 Respeta el servidor", "- No construyas máquinas de lag\n- Utiliza los canales de Discord según su función", false);
            eb.addField("2. \u26CF Respeta los jugadores", "- No hagas protecciones cerca de otros jugadores, a no ser que sea cerca de postes\n- Trata a los demás como te gustaría que te tratasen", false);
            eb.addField("3. \uD83C\uDFE0 Respeta zonas comunes", "- No destruyas zonas comunes\n- Respeta las granjas públicas", false);
            eb.addField("Contacta a los administradores si encuentras algún error", muriplz.getAsMention() + " y " + ender.getAsMention(), false);
            eb.addField("Disclaimer", "No tenemos nada que ver con LandaCraft. Esto es un servidor totalmente distinto", false);

            event.replyEmbeds(eb.build()).queue();
        }
    }
}
