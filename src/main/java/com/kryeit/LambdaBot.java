package com.kryeit;

import com.kryeit.commands.IPCommand;
import com.kryeit.commands.InfoCommand;
import com.kryeit.commands.NormasCommand;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

import java.nio.file.Files;
import java.nio.file.Paths;

public class LambdaBot {

    public static Guild guild;
    public static String muriplz = User.fromId("235400519365951488").getAsMention();
    public static String ender = User.fromId("774275869300228096").getAsMention();

    public static void main(String[] arguments) throws Exception
    {
        String token = new String(Files.readAllBytes(Paths.get("secret.txt"))).trim();
        JDA api = JDABuilder.createDefault(token)
                .build()
                .awaitReady();
        api.addEventListener(new NormasCommand());
        api.addEventListener(new IPCommand());
        api.addEventListener(new InfoCommand());

        guild = api.getGuildById("1119257557245104202");
        guild.updateCommands().addCommands(
                Commands.slash("normas", "Manda las normas."),
                Commands.slash("ip", "Manda la IP del servidor."),
                Commands.slash("informacion", "Manda la Información principal del servidor.")
        ).queue();

    }

}
