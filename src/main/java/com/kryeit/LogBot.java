import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.entities.TextChannel;

import javax.security.auth.login.LoginException;
import java.util.logging.Logger;

public class LogBot extends ListenerAdapter {
    private static final Logger logger = Logger.getLogger(LogBot.class.getName());
    private static final String LOG_CHANNEL_ID = "1120759327712624782"; // Reemplaza con el ID del canal "log-staff"

    public static void main(String[] args) throws LoginException {
        String token = "eltokenese"; // Reemplaza con tu token de bot

        JDABuilder.createDefault(token)
                .addEventListeners(new LogBot())
                .build();
    }

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        // Obtén el canal de log por su ID
        TextChannel logChannel = event.getChannel().getGuild().getTextChannelById(LOG_CHANNEL_ID);
        if (logChannel == null) {
            logger.warning("No se encontró el canal de log.");
            return;
        }

        // Envía el mensaje recibido al canal de log
        logChannel.sendMessage(event.getAuthor().getAsTag() + ": " + event.getMessage().getContentDisplay()).queue();
    }

    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        // Obtén el canal de log por su ID
        TextChannel logChannel = event.getGuild().getTextChannelById(LOG_CHANNEL_ID);
        if (logChannel == null) {
            logger.warning("No se encontró el canal de log.");
            return;
        }

        // Envía el mensaje de bienvenida al canal de log
        logChannel.sendMessage("Nuevo usuario se unió al servidor: " + event.getUser().getAsTag()).queue();
    }
}
