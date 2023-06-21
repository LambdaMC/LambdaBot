import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class NuevoCommand extends ListenerAdapter {
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
        event.getGuild().getDefaultChannel().sendMessageEmbeds(eb.build()).queue();
    }
}
