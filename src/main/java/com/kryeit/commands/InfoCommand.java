package com.kryeit.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

import static com.kryeit.LambdaBot.*;

public class InfoCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equals("informacion")) {
            EmbedBuilder eb = new EmbedBuilder();

            eb.setColor(Color.ORANGE);
            eb.setThumbnail("https://kryeit.com/images/lambdacraft.png");
            eb.setFooter("λCraft");
            eb.setAuthor("Información");
            eb.addField("1. Normas", "- Leerlas para no sancionarte\n- Las puedes leer en " + normas.getAsMention(), false);
            eb.addField("2. IP del servidor", "- Utiliza el comando /ip\n- No utilizar muchas veces seguidas el comando", false);
            eb.addField("3. Mapa interactivo del servidor", "- http://5.9.144.150:8100/", false);
            eb.addField("Contacta a los administradores si encuentras algún error", muriplz.getAsMention() + " y " + ender.getAsMention(), false);

            event.replyEmbeds(eb.build()).queue();
        }
    }
}
