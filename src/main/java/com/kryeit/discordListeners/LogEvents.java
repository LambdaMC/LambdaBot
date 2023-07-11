package com.kryeit.discordListeners;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.events.message.MessageDeleteEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.kryeit.LambdaBot.logStaffChannel;

public class LogEvents extends ListenerAdapter {

    private final Map<String, Message> cache = Collections.synchronizedMap(new LinkedHashMap<String, Message>(100, 0.75f, true) {
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > 100;
        }
    });
        @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        // Obtén la información del miembro que se unió
        String userName = event.getMember().getUser().getName();
        String userAvatarUrl = event.getMember().getUser().getAvatarUrl();

        // Crea el mensaje de bienvenida
        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle("¡Bienvenido al servidor!");
        eb.setDescription("¡Hola, " + userName + "! ¡Bienvenido a nuestro servidor!");
        eb.setThumbnail(userAvatarUrl);

        // Envía el mensaje de bienvenida al canal deseado
       logStaffChannel.sendMessageEmbeds(eb.build()).queue();
    }

    @Override
    public void onMessageReceived(@Nonnull MessageReceivedEvent event) {
        Message msg = event.getMessage();
        if (msg.getContentRaw().length() <= 100) { // only cache messages smaller than or equal to 100 characters
            cache.put(msg.getId(), msg);
        }
    }

    @Override
    public void onMessageDelete(@Nonnull MessageDeleteEvent event) {
        String messageId = event.getMessageId();
        Message msg = cache.get(messageId);
        if (msg != null) {
            logStaffChannel.sendMessage("El usuario " + msg.getAuthor().getAsMention() + " ha borrado este mensaje: " + msg.toString()).queue();
            cache.remove(messageId);
        }
    }

    @Override
    public void onGuildMemberRemove(GuildMemberRemoveEvent event) {
        // Obtén el canal de log por su ID
        String userName = event.getMember().getNickname();
        String name = event.getMember().getEffectiveName();
        String userAvatarUrl = event.getMember().getUser().getAvatarUrl();

        // Crea el mensaje de bienvenida
        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle("Se fue del servidor");
        eb.setDescription("El usuario " + userName + ", " + name + " ha abandonado el servidor");
        eb.setThumbnail(userAvatarUrl);

        // Envía el mensaje de bienvenida al canal deseado
        logStaffChannel.sendMessageEmbeds(eb.build()).queue();
    }
}
