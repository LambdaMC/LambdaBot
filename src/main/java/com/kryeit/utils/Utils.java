package com.kryeit.utils;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.UserSnowflake;

import static com.kryeit.LambdaBot.guild;
import static com.kryeit.LambdaBot.staff;

public class Utils {
    public static boolean isStaff(Member member) {
        return guild.getMembersWithRoles(staff).contains(member);
    }
}
