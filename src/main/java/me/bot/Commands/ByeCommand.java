package me.bot.Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.events.thread.member.ThreadMemberLeaveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class ByeCommand extends ListenerAdapter {

    @Override
    public void onThreadMemberLeave(@NotNull ThreadMemberLeaveEvent event) {

        User user = event.getMember().getUser();

        user.openPrivateChannel().queue(ch -> {
            ch.sendMessage("Żegnam. \n").queue();
            ch.sendMessage("https://discord.gg/KGCKuc6").queue();
        });

        EmbedBuilder embed = new EmbedBuilder()
                .setColor(0xFF4122)
                .setAuthor(user.getName(), user.getAvatarUrl(), user.getAvatarUrl())
                .setDescription("*" + user.getName() + "* opuścił ***Tłustego Kraba***.");

        if ((event.getGuild().getDefaultChannel()) != null) {
            event.getGuild().getDefaultChannel().asTextChannel().sendMessageEmbeds(embed.build()).queue();
        }
    }

    @Override
    public void onGuildMemberRemove(@NotNull GuildMemberRemoveEvent event) {

        User user = event.getUser();

        EmbedBuilder embed = new EmbedBuilder()
                .setColor(0xFF4122)
                .setAuthor(user.getName(), user.getAvatarUrl(), user.getAvatarUrl())
                .setDescription("*" + user.getName() + "* opuścił ***Tłustego Kraba***.");

        if ((event.getGuild().getDefaultChannel()) != null) {
            event.getGuild().getDefaultChannel().asTextChannel().sendMessageEmbeds(embed.build()).queue();
        }
    }
}
