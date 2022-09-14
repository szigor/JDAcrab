package me.bot.Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.user.update.UserUpdateAvatarEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class AvatarUpdateCommand extends ListenerAdapter {
    
    @Override
    public void onGuildMemberUpdateAvatar(@NotNull GuildMemberUpdateAvatarEvent event) {
        final String textChannelIdPlayground = "930860696332271690";
        final String textChannelId = "667764000972472323"; //tlusty
        final User user = event.getUser();

        EmbedBuilder builder = new EmbedBuilder()
                .setColor(0x78AAFF)
                .setAuthor(user.getName(), event.getOldAvatarUrl(), event.getOldAvatarUrl())
//                .setDescription("**Zmienił avatar** :open_mouth::point_right:")
                .setDescription("**Zmienił avatar** :arrow_right: :arrow_right:")
                .setThumbnail(event.getNewAvatarUrl());

        event.getJDA().getGuildChannelById(textChannelId).getGuild().getDefaultChannel().asTextChannel().sendMessageEmbeds(builder.build()).queue();
    }

    @Override
    public void onUserUpdateAvatar(@NotNull UserUpdateAvatarEvent event) {
        final String textChannelIdPlayground = "930860696332271690";
        final String textChannelId = "667764000972472323"; //tlusty
        final User user = event.getUser();

        EmbedBuilder builder = new EmbedBuilder()
                .setColor(0x78AAFF)
                .setAuthor(user.getName(), event.getOldAvatarUrl(), event.getOldAvatarUrl())
//                .setDescription("**Zmienił avatar** :open_mouth::point_right:")
                .setDescription("**Zmienił avatar** :arrow_right: :arrow_right:")
                .setThumbnail(event.getNewAvatarUrl());

        event.getJDA().getGuildChannelById(textChannelId).getGuild().getDefaultChannel().asTextChannel().sendMessageEmbeds(builder.build()).queue();
    }

}
