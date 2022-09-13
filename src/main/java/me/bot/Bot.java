package me.bot;

import me.bot.Commands.AvatarUpdateCommand;
import me.bot.Commands.ByeCommand;
import me.bot.Commands.CensorCommand;
import me.bot.Commands.WelcomeCommand;
import me.bot.Commands.useless.PingCommand;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import javax.security.auth.login.LoginException;

public class Bot {
    private Bot() throws LoginException {

        JDABuilder.createDefault(
                        System.getenv("TOKEN"),
                        GatewayIntent.GUILD_MESSAGES,
                        GatewayIntent.MESSAGE_CONTENT,
                        GatewayIntent.GUILD_MEMBERS,
                        GatewayIntent.GUILD_BANS,
                        GatewayIntent.GUILD_PRESENCES,
                        GatewayIntent.DIRECT_MESSAGES,
                        GatewayIntent.GUILD_INVITES
                )
                .enableCache(CacheFlag.CLIENT_STATUS)
                .addEventListeners(
                        new PingCommand(),
                        new WelcomeCommand(),
                        new ByeCommand(),
                        new AvatarUpdateCommand(),
                        new CensorCommand()
                )
                .setActivity(Activity.watching("ciebie"))
                .setStatus(OnlineStatus.DO_NOT_DISTURB)
                .build();
    }
    public static void main(String[] args) throws LoginException {
        new Bot();
    }
}
