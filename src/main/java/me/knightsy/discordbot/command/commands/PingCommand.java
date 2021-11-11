package me.knightsy.discordbot.command.commands;

import me.knightsy.discordbot.command.Command;
import me.knightsy.discordbot.util.EmbedMessage;
import org.javacord.api.event.message.MessageCreateEvent;

public class PingCommand implements Command {

    @Override
    public void process(MessageCreateEvent event) {
        new EmbedMessage(event.getMessageAuthor(), "Title", "Pong!", "footer", null, event.getChannel());
    }
}
