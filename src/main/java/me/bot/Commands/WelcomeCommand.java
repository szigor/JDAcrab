package me.bot.Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class WelcomeCommand extends ListenerAdapter {

    @Override
    public void onGuildMemberJoin(@NotNull GuildMemberJoinEvent event) {

        String imageLink = "https://static.wikia.nocookie.net/spongebob-polska/images/9/9b/Actual-krusty-krab.jpg/revision/latest/scale-to-width-down/250?cb=20150704095618&path-prefix=pl";
        Member member = event.getMember();
        User user = member.getUser();
        int memberCount = event.getGuild().getMemberCount();
        
        Role roleKlient = event.getGuild().getRoleById("667767640571379744");

        assert roleKlient != null;
        member.getGuild().addRoleToMember(user, roleKlient).queue();
        
        EmbedBuilder builder = new EmbedBuilder()
                .setColor(0xFF4A4A)
                .setAuthor(event.getGuild().getName())
                .setThumbnail(imageLink)
                .addField("Właściciel:", event.getGuild().getMember(User.fromId("935863386997149756")).getEffectiveName(), true)
                .addField("Ilość obecnych klientów:", String.valueOf(memberCount), true)
                .setDescription("**Witamy na najlepszym serwerze w** ***Bikini Dolnym***\n" +
                        "**Enjoy** \n" +
                        "**Link do tłustego:** \n" + "https://discord.gg/KGCKuc6");

        EmbedBuilder embed = new EmbedBuilder()
                .setColor(0x5CED73)
                .setAuthor(user.getName(), user.getAvatarUrl(), user.getAvatarUrl())
                .setDescription("Witamy pod ***Tłustym Krabem***!");

        if ((event.getGuild().getDefaultChannel()) != null) {
//            event.getGuild().getDefaultChannel().asTextChannel().sendMessage(member.getAsMention() + " witamy pod ***Tłustym Krabem***!").queue();
            event.getGuild().getDefaultChannel().asTextChannel().sendMessageEmbeds(embed.build()).queue();
            member.getUser().openPrivateChannel().queue(ch -> {
                ch.sendMessageEmbeds(builder.build()).queue();
            });

        }
    }
}
