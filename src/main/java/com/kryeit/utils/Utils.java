package com.kryeit.utils;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.UserSnowflake;

import java.util.concurrent.TimeUnit;

import static com.kryeit.LambdaBot.guild;
import static com.kryeit.LambdaBot.staff;

public class Utils {
    public static boolean isStaff(Member member) {
        return guild.getMembersWithRoles(staff).contains(member);
    }

    public static String getTime(int secondsx) {
        int days = (int) TimeUnit.SECONDS.toDays(secondsx);
        int hours = (int) (TimeUnit.SECONDS.toHours(secondsx) - TimeUnit.DAYS.toHours(days));
        int minutes = (int) (TimeUnit.SECONDS.toMinutes(secondsx) - TimeUnit.HOURS.toMinutes(hours)
                - TimeUnit.DAYS.toMinutes(days));
        int seconds = (int) (TimeUnit.SECONDS.toSeconds(secondsx) - TimeUnit.MINUTES.toSeconds(minutes)
                - TimeUnit.HOURS.toSeconds(hours) - TimeUnit.DAYS.toSeconds(days));

        if (days != 0) {
            return days + " días " + hours + " horas " + minutes + " minutos " + seconds + " segundos";
        } else {
            if (hours != 0) {
                return hours + " horas " + minutes + " minutos " + seconds + " segundos";
            } else {
                if (minutes != 0) {
                    return minutes + " minutos " + seconds + " segundos";
                } else {
                    return seconds + " segundos";
                }
            }

        }
    }
}
