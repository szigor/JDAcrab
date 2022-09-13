package me.bot.Commands.useless;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class PingCommand extends ListenerAdapter {
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {

        String messageSent = event.getMessage().getContentRaw();

        if (messageSent.equalsIgnoreCase("!ping")) {
            event.getChannel().sendMessage("Mój ping: **" + event.getJDA().getGatewayPing() + "ms**").queue();
        }

    }
}
