package com.kryeit.commands;

import com.kryeit.utils.Utils;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.Statistic;

import java.awt.*;

public class JugadorCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {

        if (event.getName().equals("jugador")) {
            OptionMapping playerNameOption = event.getOption("nombre");
            if (playerNameOption == null) {
                event.reply("Tienes que especificar a algún jugador.").setEphemeral(true).queue();
                return;
            }

            String playerName = playerNameOption.getAsString();

            OfflinePlayer player = Bukkit.getOfflinePlayer(playerName);

            long lastPlayed = player.getLastPlayed();
            long currentTime = System.currentTimeMillis();
            long timeDifference = currentTime - lastPlayed;

            String timePlayed = Utils.getTime(player.getStatistic(Statistic.PLAY_ONE_MINUTE) / 20);

            EmbedBuilder eb = new EmbedBuilder();

            eb.setColor(Color.ORANGE);
            eb.setThumbnail("https://minotar.net/helm/" + playerName +"/600.png");
            eb.setFooter("λCraft");
            eb.setTitle(playerName);
            eb.addField("Tiempo jugado", timePlayed,false);
            if(player.isOnline()) {
                eb.addField("Última vez conectado", "Está conectado en el servidor", false);

            } else {
                eb.addField("Última vez conectado", "Hace " + Utils.getTime((int) timeDifference/1000), false);
            }

            event.replyEmbeds(eb.build()).queue();
        }
    }
}
