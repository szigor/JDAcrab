package me.bot.Commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CensorCommand extends ListenerAdapter {
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {

        List<String> answers = new ArrayList<>();
        answers.add("Proszę tak nie pisać");
        answers.add("Proszę użyć innego wyrazu");
        answers.add("Więcej kultury proszę");
        answers.add("Brzydko, proszę tak więcej nie pisać");
        answers.add("Proszę nie być wulgarnym");
        answers.add("Bardzo wulgarnie");
        answers.add("Grzeczniej proszę");

        List<String> badWords = new ArrayList<>();
        badWords.add("kurw");
        badWords.add("Kurw");
        badWords.add("pierdo");
        badWords.add("pierda");
        badWords.add("jeba");
        badWords.add("jebi");
        badWords.add("Jeba");
        badWords.add("pizd");
        badWords.add("huj");

        for (String badWord : badWords) {
            if (event.getMessage().getContentRaw().contains(badWord)) {
                event.getMessage().reply(answers.get(new Random().nextInt(answers.size()))).queue();
                break;
            }
        }





    }
}
